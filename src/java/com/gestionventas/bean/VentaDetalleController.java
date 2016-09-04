package com.gestionventas.bean;

import com.gestionventas.entry.VentaDetalle;
import com.gestionventas.bean.util.JsfUtil;
import com.gestionventas.bean.util.JsfUtil.PersistAction;
import com.gestionventas.entry.Producto;
import com.gestionventas.sessions.VentaDetalleFacade;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("ventaDetalleController")
@SessionScoped
public class VentaDetalleController implements Serializable {

    @EJB
    private com.gestionventas.sessions.VentaDetalleFacade ejbFacade;
    
    @EJB
    private com.gestionventas.sessions.ProductoFacade ejbFacadeArticulo;

    
    private List<VentaDetalle> items = null;
    private VentaDetalle selected;
    private boolean disabledDetalle; 
    private Integer codProducto;
    private Integer precioVenta;


    public VentaDetalleController(VentaDetalleFacade ejbFacade, VentaDetalle selected, boolean disabledDetalle, Integer codProducto) {
        this.ejbFacade = ejbFacade;
        this.selected = selected;
        this.disabledDetalle = disabledDetalle;
        this.codProducto = codProducto;
    }

    public boolean isDisabledDetalle() {
        return disabledDetalle;
    }

    public void setDisabledDetalle(boolean disabledDetalle) {
        this.disabledDetalle = disabledDetalle;
    }
    
    public Integer getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public VentaDetalleController() {
    }

    
    public VentaDetalle getSelected() {
        return selected;
    }

    public void setSelected(VentaDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getVentaDetallePK().setCodigoProducto(selected.getProducto().getCodigoProducto());
        selected.getVentaDetallePK().setNumeroFactura(selected.getVentaCabecera().getNumeroFactura());
    }

    protected void initializeEmbeddableKey() {
        selected.setVentaDetallePK(new com.gestionventas.entry.VentaDetallePK());
    }
    
    public void agregarDetalle(){
        if (selected == null)
            selected = new VentaDetalle();
        selected.setProducto(new Producto(codProducto));
        selected.setPrecioVenta(precioVenta);
        selected.setImporteTotal(BigInteger.ZERO);
        selected.setImporteGravado(BigInteger.ZERO);
        selected.setImporteIva10(BigInteger.ZERO);
        selected.setImporteIva5(BigInteger.ZERO);
        selected.setImporteExento(BigInteger.ZERO);
        create();
        
    }

    private VentaDetalleFacade getFacade() {
        return ejbFacade;
    }

    public VentaDetalle prepareCreate() {
        selected = new VentaDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("VentaDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("VentaDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("VentaDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<VentaDetalle> getItems() {
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

    public VentaDetalle getVentaDetalle(com.gestionventas.entry.VentaDetallePK id) {
        return getFacade().find(id);
    }

    public List<VentaDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<VentaDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = VentaDetalle.class)
    public static class VentaDetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VentaDetalleController controller = (VentaDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ventaDetalleController");
            return controller.getVentaDetalle(getKey(value));
        }

        com.gestionventas.entry.VentaDetallePK getKey(String value) {
            com.gestionventas.entry.VentaDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.gestionventas.entry.VentaDetallePK();
            key.setNumeroFactura(values[0]);
            key.setCodigoProducto(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.gestionventas.entry.VentaDetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNumeroFactura());
            sb.append(SEPARATOR);
            sb.append(value.getCodigoProducto());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof VentaDetalle) {
                VentaDetalle o = (VentaDetalle) object;
                return getStringKey(o.getVentaDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), VentaDetalle.class.getName()});
                return null;
            }
        }

    }

    public void obtenerDatosProducto(){
        if (codProducto != null){
            Producto producto = ejbFacadeArticulo.find(codProducto);
            precioVenta = producto.getPrecioVenta().intValue();
            try{
               if (selected == null)
                   selected = new VentaDetalle();
            this.selected.setPrecioVenta(precioVenta);
            }catch(Exception ex){
                System.out.print(ex);
            }
        }
    }

    
}
