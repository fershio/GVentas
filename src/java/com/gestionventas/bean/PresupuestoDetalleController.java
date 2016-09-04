package com.gestionventas.bean;

import com.gestionventas.entry.PresupuestoDetalle;
import com.gestionventas.bean.util.JsfUtil;
import com.gestionventas.bean.util.JsfUtil.PersistAction;
import com.gestionventas.sessions.PresupuestoDetalleFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("presupuestoDetalleController")
@SessionScoped
public class PresupuestoDetalleController implements Serializable {

    @EJB
    private com.gestionventas.sessions.PresupuestoDetalleFacade ejbFacade;
    private List<PresupuestoDetalle> items = null;
    private PresupuestoDetalle selected;

    public PresupuestoDetalleController() {
    }

    public PresupuestoDetalle getSelected() {
        return selected;
    }

    public void setSelected(PresupuestoDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getPresupuestoDetallePK().setPresupuestoNumero(selected.getPresupuestoCabecera().getNumeroPresupuesto());
        selected.getPresupuestoDetallePK().setCodigoProducto(selected.getProducto().getCodigoProducto());
    }

    protected void initializeEmbeddableKey() {
        selected.setPresupuestoDetallePK(new com.gestionventas.entry.PresupuestoDetallePK());
    }

    private PresupuestoDetalleFacade getFacade() {
        return ejbFacade;
    }

    public PresupuestoDetalle prepareCreate() {
        selected = new PresupuestoDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PresupuestoDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PresupuestoDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PresupuestoDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PresupuestoDetalle> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public PresupuestoDetalle getPresupuestoDetalle(com.gestionventas.entry.PresupuestoDetallePK id) {
        return getFacade().find(id);
    }

    public List<PresupuestoDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PresupuestoDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PresupuestoDetalle.class)
    public static class PresupuestoDetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PresupuestoDetalleController controller = (PresupuestoDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "presupuestoDetalleController");
            return controller.getPresupuestoDetalle(getKey(value));
        }

        com.gestionventas.entry.PresupuestoDetallePK getKey(String value) {
            com.gestionventas.entry.PresupuestoDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.gestionventas.entry.PresupuestoDetallePK();
            key.setPresupuestoNumero(Integer.parseInt(values[0]));
            key.setCodigoProducto(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.gestionventas.entry.PresupuestoDetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getPresupuestoNumero());
            sb.append(SEPARATOR);
            sb.append(value.getCodigoProducto());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PresupuestoDetalle) {
                PresupuestoDetalle o = (PresupuestoDetalle) object;
                return getStringKey(o.getPresupuestoDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PresupuestoDetalle.class.getName()});
                return null;
            }
        }

    }

}
