/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.bean;

import com.gestionventas.bean.util.JsfUtil;
import com.gestionventas.entry.Cliente;
import com.gestionventas.entry.Producto;
import com.gestionventas.entry.Vendedor;
import com.gestionventas.entry.VentaCabecera;
import com.gestionventas.entry.VentaDetalle;
import com.gestionventas.entry.Ventas;
import com.gestionventas.sessions.ClienteFacade;
import com.gestionventas.sessions.VentaCabeceraFacade;
import com.gestionventas.sessions.VentaDetalleFacade;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author guillermo.paez
 */
@Named("ventasController")
@SessionScoped
public class VentasController implements Serializable{
    
    @EJB
    private com.gestionventas.sessions.VentaCabeceraFacade ejbFacade;
    
    @EJB
    private com.gestionventas.sessions.VentaDetalleFacade ejbFacadeDet;
    
    @EJB
    private com.gestionventas.sessions.ClienteFacade ejbFacadeCliente;
    
    @EJB
    private com.gestionventas.sessions.ProductoFacade ejbFacadeArticulo;
    
    private List<VentaCabecera> items = null;
    private List<VentaDetalle> itemsDet = null;
    private List<VentaDetalle> itemsDetActual = null;

    public List<VentaDetalle> getItemsDetActual() {
        return itemsDetActual;
    }

    public void setItemsDetActual(List<VentaDetalle> itemsDetActual) {
        this.itemsDetActual = itemsDetActual;
    }
    private VentaCabecera selected;
    private VentaDetalle selectedDetalle;
    private boolean disabled;
    private boolean disabledNuevo;
    private boolean disabledNuevoProducto;
    private boolean disabledDetalle;
    private boolean disabledCancelar; 
    private String direccionCliente;
    private String telefono;
    private String nroFactura;
    private boolean disabledFactura;
    private Integer codCliente;
    private Integer codVendedor;
    private String ruc;
    private Integer codProducto;
    private Integer precioVenta;
    private String nombreProducto;
    private short iva;
    private RequestContext context;
    private int totalDet;
    private int stock;
    private Producto producto;

    public VentasController() {
        context = RequestContext.getCurrentInstance();   
    }
    
    public VentaCabecera prepareCreate() {
        selected = new VentaCabecera();
        initializeEmbeddableKey();
        return selected;
    }

    public VentaCabeceraFacade getEjbFacade() {
        return ejbFacade;
    }
    
    @PostConstruct
    public void init(){
        
        prepareCreate();
        this.disabled =  selected.getNumeroFactura() == null;
        this.disabledNuevo = !this.disabled;
        this.disabledFactura =  selected.getImporteTotal()==null;
        this.disabledCancelar = true;
        this.disabledDetalle = true;
        this.disabledNuevoProducto = true;
        totalDet = 8;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Getter and Setter ">

    public boolean isDisabledNuevoProducto() {
        return disabledNuevoProducto;
    }

    public void setDisabledNuevoProducto(boolean disabledNuevoProducto) {
        this.disabledNuevoProducto = disabledNuevoProducto;
    }

    public List<VentaCabecera> getItems() {
       if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<VentaCabecera> items) {
        this.items = items;
    }

    public VentaCabecera getSelected() {
        return selected;
    }

    public void setSelected(VentaCabecera selected) {
        this.selected = selected;
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

    public boolean isDisabledDetalle() {
        return disabledDetalle;
    }

    public void setDisabledDetalle(boolean disabledDetalle) {
        this.disabledDetalle = disabledDetalle;
    }

    public boolean isDisabledCancelar() {
        return disabledCancelar;
    }

    public void setDisabledCancelar(boolean disabledCancelar) {
        this.disabledCancelar = disabledCancelar;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    public boolean isDisabledFactura() {
        return disabledFactura;
    }

    public void setDisabledFactura(boolean disabledFactura) {
        this.disabledFactura = disabledFactura;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public VentaDetalle getSelectedDetalle() {
        return selectedDetalle;
    }

    public void setSelectedDetalle(VentaDetalle selectedDetalle) {
        this.selectedDetalle = selectedDetalle;
    }
    
    public VentaDetalleFacade getFacadeDet(){
        return ejbFacadeDet;
    }
    
    public List<VentaDetalle> getItemsDet() {
        if (itemsDet == null) {
           itemsDet = new ArrayList<>();
       }
        return itemsDet;
    }

    public Integer getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public Integer getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Integer precioVenta) {
        this.precioVenta = precioVenta;
    }

    
    
    
    //</editor-fold>
    
    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
    public void create() {
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("VentaCabeceraCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(JsfUtil.PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("VentaCabeceraUpdated"));
    }

    public void destroy() {
        persist(JsfUtil.PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("VentaCabeceraDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    private VentaCabeceraFacade getFacade() {
        return ejbFacade;
    }
    
    private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != JsfUtil.PersistAction.DELETE) {
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

    public void obtenerDatosClientes(){
        if (codCliente != null){
        Cliente cliente =  ejbFacadeCliente.find(codCliente);
        this.direccionCliente = cliente.getDireccion();
        this.telefono = cliente.getTelefono();
        this.ruc = cliente.getRuc();
        }
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
        itemsDet = null;
        selected = null;
        selectedDetalle = null;
        codCliente = null;
        codVendedor = null;
        this.disabledFactura = true;
        this.disabled = true;
        this.disabledNuevoProducto = true;
        this.disabledDetalle = true;
        this.disabledCancelar = true;
        this.disabledNuevo = false;
        this.direccionCliente = null;
        this.ruc = null;
        this.telefono = null;
    }
    
    public void agregarDetalle(){
             
        // <editor-fold defaultstate="collapsed" desc=" Validaciones ">
        if (codCliente == null ){
           context.showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"Gestion Ventas","Favor Seleccione un Cliente"));
           return;
        }
        if (codVendedor == null){
           context.showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"Gestion Ventas","Favor Seleccione un Vendedor"));
           return; 
        }
        
        if (selected.getCondicionPago() == -1){
           context.showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"Gestion Ventas","Favor Seleccione un condicion de venta"));
           return;
        }
        // </editor-fold>
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
        this.disabledNuevoProducto = false;
        
        
    }

    protected void setEmbeddableKeysDet() {
        selectedDetalle.getVentaDetallePK().setCodigoProducto(codProducto);
        selectedDetalle.getVentaDetallePK().setNumeroFactura(selected.getNumeroFactura());
    }

    protected void initializeEmbeddableKeyDet() {
        selectedDetalle.setVentaDetallePK(new com.gestionventas.entry.VentaDetallePK());
    }

    public VentaDetalle prepareCreateDet() {
        selectedDetalle = new VentaDetalle();
        initializeEmbeddableKeyDet();
        return selectedDetalle;
    }

    public List<VentaDetalle> getVentaDetalle(com.gestionventas.entry.VentaDetallePK id) {
        return itemsDetActual =   getFacadeDet().findAll();
    }

    public List<VentaDetalle> getItemsAvailableSelectManyDet() {
        return getFacadeDet().findAll();
    }

    public List<VentaDetalle> getItemsAvailableSelectOneDet() {
        return getFacadeDet().findAll();
    }

    private void persistDet(JsfUtil.PersistAction persistAction, String successMessage) {
        if (selectedDetalle != null) {
            //setEmbeddableKeysDet();
            try {
                if (persistAction != JsfUtil.PersistAction.DELETE) {
                    getFacadeDet().edit(selectedDetalle);
                } else {
                    getFacadeDet().remove(selectedDetalle);
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

    public void createDet() {
        persistDet(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("VentaDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            //itemsDet = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void updateDet() {
        persistDet(JsfUtil.PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("VentaDetalleUpdated"));
    }

    public void destroyDet() {
        persistDet(JsfUtil.PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("VentaDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selectedDetalle = null; // Remove selection
            itemsDet = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void obtenerDatosProducto(){
        if (codProducto != null){
            producto = ejbFacadeArticulo.find(codProducto);
            precioVenta = producto.getPrecioVenta().intValue();
            nombreProducto = producto.getDescripcionProducto();
            iva = producto.getTipoImpuesto();
            stock = producto.getStock();
            try{
            this.selectedDetalle.setPrecioVenta(precioVenta);
            }catch(Exception ex){
                System.out.print(ex);
            }
        }
    }

    public void agregarArticulos(){
        long total = 0;
        try {
            if (itemsDet.size() > totalDet-1){
                context.showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"Gestion Ventas","Ya ha superado el maximo de items por factura"));
                return;
            }
            if (selectedDetalle.getCantidad().intValue() > this.stock){
               context.showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_WARN,"Gestion Ventas","Stock insuficiente, verifique"));
               return; 
            }
            setEmbeddableKeysDet();
            this.selectedDetalle.setImporteExento(BigInteger.ZERO);
            this.selectedDetalle.setImporteGravado(BigInteger.ZERO);
            this.selectedDetalle.setImporteIva10(BigInteger.ZERO);
            this.selectedDetalle.setImporteIva5(BigInteger.ZERO);
            this.selectedDetalle.setImporteTotal(BigInteger.ZERO);
            this.selectedDetalle.setProducto(producto);
//            this.selectedDetalle.setDescripcionProducto("");
            total = (this.selectedDetalle.getCantidad().intValue() * this.selectedDetalle.getPrecioVenta());
            if (iva == 5) {
               this.selectedDetalle.setImporteExento(BigInteger.ZERO);
               this.selectedDetalle.setImporteIva5(BigInteger.valueOf(total));
               this.selectedDetalle.setImporteTotal(BigInteger.valueOf(total) ); 
            }else if(iva == 10){
               this.selectedDetalle.setImporteIva10(BigInteger.valueOf(total));
               this.selectedDetalle.setImporteTotal(BigInteger.valueOf(total) ); 
            }
            this.disabledNuevoProducto = false;
            this.disabledDetalle = true;
            itemsDet.add(selectedDetalle);
            this.disabledFactura = false;
            if (this.selectedDetalle == null){
                prepareCreateDet();
            }
            
        } catch (Exception e) {
             context.showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"Gestion Ventas",e.getMessage()));
        }
       
    }
    
    public void nuevoDetalle(){
        if(selected != null){
            //this.create();
            prepareCreateDet();
            this.disabledDetalle = false;
            this.disabledNuevoProducto = true;
        }
    }
   
    public void guardarFactura(){
        create();
        for (int i = 0; i < itemsDet.size(); i++) {
            selectedDetalle = itemsDet.get(i);
            createDet();
        }
        cancelarVenta();
    }

 
}
