
package com.gestionventas.bean.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
public class CalendarView {
    private Date date9;
    
    public void onDateSelect(SelectEvent event){
        FacesContext context = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Fecha Seleccionada", format.format(event.getObject())));
    }
    
    public void click(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    public Date getDate9() {
        return date9;
    }

    public void setDate9(Date date9) {
        this.date9 = date9;
    }
    
    
    
    
}
