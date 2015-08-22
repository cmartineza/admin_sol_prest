/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.core;

import co.com.adminsol.entitys.UsuarioApl;
import co.com.adminsol.facade.UsuarioFacade;
import co.com.adminsol.modelo.DatosUsuario;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author MARA
 */
@ManagedBean
@ViewScoped
public class PreguntasClaveJSFB extends ApplicationJSFB {

    @EJB
    private UsuarioFacade uf;
    private UsuarioApl usuario;
    private String idUSuario;
    private String pregunta1;
    private String pregunta2;
    private String pregunta3;
    private DatosUsuario datosUsuario;

    @PostConstruct
    public void init() {

    }

    public void buscarUsuario(ActionEvent action) {
        usuario = uf.buscarUSuario(idUSuario);
        if (usuario == null) {
            presentarError(FacesContext.getCurrentInstance(), "Error", "No se encontro el usuario");
        }else{
            usuario.setRespuesta1("");
            usuario.setRespuesta2("");
            usuario.setRespuesta3("");
            usuario.setClave("");
        }
    }

    public String validarPreguntas() {
        String valor = uf.restauraContrasena(usuario);
        FacesContext ctx =FacesContext.getCurrentInstance();
        if ("MaxIntentos".equals(valor)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Usuario Bloqueado", "Se supero el maximo de intentos");
            ctx.addMessage(null, message);
            return "preguntas_seguridad.xhtml?faces_redirect=true";
        } else {
            if ("failRta".equals(valor)) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Respuestas Invalidas", "Por favor valide las respuestas e intente nuevamente");
                ctx.addMessage(null, message);
                return "preguntas_seguridad.xhtml?faces_redirect=true";
            } else {
            }
        }
        removeBeanSession(ctx, "restauraContrasenaJSFB");
        redirectPage(ctx, "m_local/restaura_clave.xhtml?value=" + valor);
        return "/m_local/restaura_clave.xhtml?faces_redirect=true&value=" + valor;
    }

    public UsuarioApl getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioApl usuario) {
        this.usuario = usuario;
    }

    public String getIdUSuario() {
        return idUSuario;
    }

    public void setIdUSuario(String idUSuario) {
        this.idUSuario = idUSuario;
    }

    public String getPregunta1() {
        return pregunta1;
    }

    public void setPregunta1(String pregunta1) {
        this.pregunta1 = pregunta1;
    }

    public String getPregunta2() {
        return pregunta2;
    }

    public void setPregunta2(String pregunta2) {
        this.pregunta2 = pregunta2;
    }

    public String getPregunta3() {
        return pregunta3;
    }

    public void setPregunta3(String pregunta3) {
        this.pregunta3 = pregunta3;
    }

}
