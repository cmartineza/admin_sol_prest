/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.core;

import co.com.adminsol.entitys.UsuarioApl;
import co.com.adminsol.facade.UsuarioFacade;
import co.com.adminsol.utilidades.CryptoUtilidad;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author MARA
 */
@ManagedBean
@ViewScoped
public class RestauraContrasenaJSFB extends ApplicationJSFB {

    private String clave;
    private String idUsuario;
    @EJB
    private UsuarioFacade uf;
    private UsuarioApl usuarioApl;
    private boolean muestraValores;
    private boolean btnActivar;
    
    @PostConstruct
    public void init() {
        btnActivar = false;
        CryptoUtilidad cryptoUtilidad = new CryptoUtilidad();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map params = externalContext.getRequestParameterMap();
        String parametroUrl = (String) params.get("value");
        try {
            String valorParam = cryptoUtilidad.Desencriptar(parametroUrl);
            String[] parametros = valorParam.split("\\$");
            if (parametros.length == 2) {
                if (parametros[0].contains("generate=")) {
                    String timeStamp = parametros[0].replaceAll("generate\\=", "");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                    Date dateParam = sdf.parse(timeStamp);
                    Date diaActual = new Date();
                    if (diaActual.getYear() == dateParam.getYear()) {
                        if (diaActual.getMonth() == dateParam.getMonth()) {
                            if (diaActual.getDay() == dateParam.getDay()) {
                                if (diaActual.getHours() == dateParam.getHours()) {
                                    if (diaActual.getMinutes() == dateParam.getMinutes()) {
                                        idUsuario = parametros[1];
                                        usuarioApl = uf.buscarUSuario(idUsuario);
                                        muestraValores = usuarioApl != null;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            presentarError(facesContext, "Error", "Error tecnico.");
            logger.error("RestauraContrasenaJSFB", ex);
        }
    }

    public void cambiarClave(ActionEvent actionEvent) {
        try {
            usuarioApl = uf.buscarUSuario(usuarioApl.getIdUsuario());
            usuarioApl.setClave(clave);
            uf.modificarUsuario(usuarioApl);
            presentarInfo(FacesContext.getCurrentInstance(), "Mensaje", "Se restauro contraseña correctamente.");
            clave = "";
            btnActivar = true;
        } catch (Exception ex) {
            logger.error("RestauraContrasenaJSFB.cambiarClave", ex);
            presentarError(FacesContext.getCurrentInstance(), "Error", "Error tecnico");
        }
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isMuestraValores() {
        return muestraValores;
    }

    public void setMuestraValores(boolean muestraValores) {
        this.muestraValores = muestraValores;
    }

    public boolean isBtnActivar() {
        return btnActivar;
    }

    public void setBtnActivar(boolean btnActivar) {
        this.btnActivar = btnActivar;
    }
}
