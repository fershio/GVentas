package com.gestionventas.bean;

import com.gestionventas.entry.VentaCabecera;
import com.gestionventas.bean.util.JsfUtil;
import com.gestionventas.bean.util.JsfUtil.PersistAction;
import com.gestionventas.entry.Cliente;
import com.gestionventas.entry.Vendedor;
import com.gestionventas.sessions.VentaCabeceraFacade;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.context.RequestContext;

@Named("ventaCabeceraController")
@SessionScoped
public class VentaCabeceraController implements Serializable {

    @EJB
    private com.gestionventas.sessions.VentaCabeceraFacade ejbFacade;
    
    @EJB
    private com.gestionventas.sessions.ClienteFacade ejbFacadeCliente;
    private List<VentaCabecera> items = null;
    private VentaCabecera selected;
    private boolean disabled;
    private boolean disabledNuevo;
    private boolean disabledDetalle;
    private boolean disabledCancelar;

   
    private String direccionCliente;
    private String telefono;

    

    public boolean isDisabledDetalle() {
        return disabledDetalle;
    }

    public void setDisabledDetalle(boolean disabledDetalle) {
        this.disabledDetalle = disabledDetalle;
    }
    private String nroFactura;
    private boolean disabledFactura;
    private Integer codCliente;
    private Integer codVendedor;

    public boolean isDisabledFactura() {
        return disabledFactura;
    }

    public void setDisabledFactura(boolean disabledFactura) {
        this.disabledFactura = disabledFactura;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isDisabledNuevo() {
        return disabledNuevo;
    }

    public void setDisabledNuevo(boolean disabledNuevo) {
        this.disabledNuevo = disabledNuevo;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }
    
     public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(Integer codVendedor) {
        this.codVendedor = codVendedor;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    private String ruc;

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }
    
    public boolean isDisabledCancelar() {
        return disabledCancelar;
    }

    public void setDisabledCancelar(boolean disabledCancelar) {
        this.disabledCancelar = disabledCancelar;
    }
    

    public VentaCabeceraController() {
    }
    
    @PostConstruct
    public void init(){
        
        prepareCreate();
        this.disabled =  selected.getNumeroFactura() == null;
        this.disabledNuevo = !this.disabled;
        this.disabledFactura =  selected.getImporteTotal()==null;
        this.disabledCancelar = true;
        this.disabledDetalle = true;
    }
    
    public void nuevaVenta(){
        nroFactura = ejbFacade.getFactura();
        if (selected == null)
             selected = new VentaCabecera();
        
        selected.setNumeroFactura(nroFactura);
        selected.setFechaVenta(new Date());
        selected.setCondicionPago(-1);
        this.disabled = selected.getNumeroFactura() == null;
        this.disabledNuevo = !this.disabled;
        this.disabledFactura =  selected.getImporteTotal()==null;
        this.disabledDetalle = true;
        this.disabledCancelar = false;
    }
    
    
    public void cancelarVenta(){
        this.selected =  null;
        this.disabled = selected == null;
        this.disabledNuevo = !this.disabled;
        this.disabledFactura =  selected==null;
        this.codCliente = null;
        this.codVendedor = null;
        this.disabledDetalle = true;
    }
    
    public void agregarDetalle(){
        RequestContext context = RequestContext.getCurrentInstance();        

        if (codCliente == null ){
           context.showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"Gestion Ventas","Favor Seleccione un Cliente"));
           return;
        }
        
        
        selected.setCodigoCliente(new Cliente(codCliente) );
        selected.setCodigoVendedor(new Vendedor(codVendedor));
        selected.setEstadoVenta('F');
        selected.setImporteExento(BigInteger.ZERO);
        selected.setImporteGravado(BigInteger.ZERO);
        selected.setImporteIva(BigInteger.ZERO);
        selected.setImporteTotal(BigInteger.ZERO);
        this.disabled = selected.getNumeroFactura() != null;
        this.disabledNuevo = this.disabled;
        this.disabledFactura =  selected.getImporteTotal()==null;
        this.disabledDetalle = false;
        if(selected != null){
            this.create();
        }
    }
    

    public VentaCabecera getSelected() {
        return selected;
    }

    public void setSelected(VentaCabecera selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private VentaCabeceraFacade getFacade() {
        return ejbFacade;
    }

    public VentaCabecera prepareCreate() {
        selected = new VentaCabecera();
        initializeEmbeddableKey();
        return selected;
    }
    
    

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("VentaCabeceraCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("VentaCabeceraUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("VentaCabeceraDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<VentaCabecera> getItems() {
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

    public VentaCabecera getVentaCabecera(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<VentaCabecera> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<VentaCabecera> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = VentaCabecera.class)
    public static class VentaCabeceraControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VentaCabeceraController controller = (VentaCabeceraController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ventaCabeceraController");
            return controller.getVentaCabecera(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof VentaCabecera) {
                VentaCabecera o = (VentaCabecera) object;
                return getStringKey(o.getNumeroFactura());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), VentaCabecera.class.getName()});
                return null;
            }
        }

    }

    public void obtenerDatosClientes(){
        if (codCliente != null){
        Cliente cliente =  ejbFacadeCliente.find(codCliente);
        this.direccionCliente = cliente.getDireccion();
        this.telefono = cliente.getTelefono();
        this.ruc = cliente.getRuc();
        }
    }
    
    
    
}
