package com.gestionventas.bean;

import com.gestionventas.entry.PresupuestoCabecera;
import com.gestionventas.bean.util.JsfUtil;
import com.gestionventas.bean.util.JsfUtil.PersistAction;
import com.gestionventas.sessions.PresupuestoCabeceraFacade;

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

@Named("presupuestoCabeceraController")
@SessionScoped
public class PresupuestoCabeceraController implements Serializable {

    @EJB
    private com.gestionventas.sessions.PresupuestoCabeceraFacade ejbFacade;
    private List<PresupuestoCabecera> items = null;
    private PresupuestoCabecera selected;

    public PresupuestoCabeceraController() {
    }

    public PresupuestoCabecera getSelected() {
        return selected;
    }

    public void setSelected(PresupuestoCabecera selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PresupuestoCabeceraFacade getFacade() {
        return ejbFacade;
    }

    public PresupuestoCabecera prepareCreate() {
        selected = new PresupuestoCabecera();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PresupuestoCabeceraCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PresupuestoCabeceraUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PresupuestoCabeceraDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PresupuestoCabecera> getItems() {
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

    public PresupuestoCabecera getPresupuestoCabecera(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<PresupuestoCabecera> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PresupuestoCabecera> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PresupuestoCabecera.class)
    public static class PresupuestoCabeceraControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PresupuestoCabeceraController controller = (PresupuestoCabeceraController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "presupuestoCabeceraController");
            return controller.getPresupuestoCabecera(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PresupuestoCabecera) {
                PresupuestoCabecera o = (PresupuestoCabecera) object;
                return getStringKey(o.getNumeroPresupuesto());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PresupuestoCabecera.class.getName()});
                return null;
            }
        }

    }

}
