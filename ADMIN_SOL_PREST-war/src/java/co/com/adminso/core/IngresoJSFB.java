/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.core;

import co.com.adminsol.entitys.UsuarioApl;
import co.com.adminsol.facade.UsuarioFacade;
import co.com.adminsol.modelo.DatosUsuario;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MARA
 */
@ManagedBean
@RequestScoped
public class IngresoJSFB extends ApplicationJSFB{
    
    @EJB private UsuarioFacade facadeUsuario;
    private DatosUsuario datosUsuario;
    private String idUsuario;
    private String clave;
    protected static final String KEY_USER = "usuario_id";

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public void login(ActionEvent actionEvent) {
        FacesMessage ms = null;
        FacesContext context = FacesContext.getCurrentInstance();
        boolean loggedIn = false;
        String ip = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
        datosUsuario = new DatosUsuario();
        datosUsuario.setUsuario(new UsuarioApl());
        datosUsuario.setIp(ip);

        UsuarioApl u = facadeUsuario.loginUsuario(datosUsuario, idUsuario, clave);
        if (u != null) {
            loggedIn = true;
            context.getExternalContext().getSessionMap().put(KEY_USER, datosUsuario);
            presentarInfo(context, "Bienvenido", u.getNombreUsuario());
            redirectPage(FacesContext.getCurrentInstance(), "/secure/index.xhtml");
        } else {
            loggedIn = false;
            presentarError(context, "Error de Ingreso", "Credenciales"
                    + " Invalidas");
        }

    }
    
    public String cerrarSesion(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "salir";
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
