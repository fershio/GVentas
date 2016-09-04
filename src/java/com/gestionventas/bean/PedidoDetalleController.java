package com.gestionventas.bean;

import com.gestionventas.entry.PedidoDetalle;
import com.gestionventas.bean.util.JsfUtil;
import com.gestionventas.bean.util.JsfUtil.PersistAction;
import com.gestionventas.sessions.PedidoDetalleFacade;

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

@Named("pedidoDetalleController")
@SessionScoped
public class PedidoDetalleController implements Serializable {

    @EJB
    private com.gestionventas.sessions.PedidoDetalleFacade ejbFacade;
    private List<PedidoDetalle> items = null;
    private PedidoDetalle selected;

    public PedidoDetalleController() {
    }

    public PedidoDetalle getSelected() {
        return selected;
    }

    public void setSelected(PedidoDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getPedidoDetallePK().setCodigoProducto(selected.getProducto().getCodigoProducto());
        selected.getPedidoDetallePK().setNumeroPedido(selected.getPedidoCabecera().getNumeroPedido());
    }

    protected void initializeEmbeddableKey() {
        selected.setPedidoDetallePK(new com.gestionventas.entry.PedidoDetallePK());
    }

    private PedidoDetalleFacade getFacade() {
        return ejbFacade;
    }

    public PedidoDetalle prepareCreate() {
        selected = new PedidoDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PedidoDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PedidoDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PedidoDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PedidoDetalle> getItems() {
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

    public PedidoDetalle getPedidoDetalle(com.gestionventas.entry.PedidoDetallePK id) {
        return getFacade().find(id);
    }

    public List<PedidoDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PedidoDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PedidoDetalle.class)
    public static class PedidoDetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PedidoDetalleController controller = (PedidoDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pedidoDetalleController");
            return controller.getPedidoDetalle(getKey(value));
        }

        com.gestionventas.entry.PedidoDetallePK getKey(String value) {
            com.gestionventas.entry.PedidoDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.gestionventas.entry.PedidoDetallePK();
            key.setNumeroPedido(Integer.parseInt(values[0]));
            key.setCodigoProducto(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.gestionventas.entry.PedidoDetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNumeroPedido());
            sb.append(SEPARATOR);
            sb.append(value.getCodigoProducto());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PedidoDetalle) {
                PedidoDetalle o = (PedidoDetalle) object;
                return getStringKey(o.getPedidoDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PedidoDetalle.class.getName()});
                return null;
            }
        }

    }

}
