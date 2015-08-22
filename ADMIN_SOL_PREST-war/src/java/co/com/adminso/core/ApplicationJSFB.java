/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.core;

import co.com.adminsol.modelo.DatosUsuario;
import co.com.adminsol.utilidades.Log;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author MARA
 */
public class ApplicationJSFB extends Log{
    
    public void redirectPage(FacesContext ctx, String pagina) {
        try {
            ctx.getExternalContext().redirect(ctx.getExternalContext().getRequestContextPath() + "/faces/"+pagina);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationJSFB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void redirectPageOut(FacesContext ctx, String pagina) {
        try {
            ctx.getExternalContext().redirect(pagina);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationJSFB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeBeanSession(FacesContext ctx, String beanName){
        ctx.getExternalContext().getSessionMap().remove(beanName);
    }
    
    public void presentarError(FacesContext ctx, String titulo, String detalle){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,titulo,detalle);
        ctx.addMessage(null, msg);
    }
    
    public void presentarInfo(FacesContext ctx, String titulo, String detalle){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,titulo,detalle);
        ctx.addMessage(null, msg);
    }
    
    public void presentarAdvertencia(FacesContext ctx, String titulo, String detalle){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,titulo,detalle);
        ctx.addMessage(null, msg);
    }
    
    public DatosUsuario getUser(FacesContext ctx){
        return (DatosUsuario) ctx.getExternalContext().getSessionMap()
                .get(IngresoJSFB.KEY_USER);
    }
}
