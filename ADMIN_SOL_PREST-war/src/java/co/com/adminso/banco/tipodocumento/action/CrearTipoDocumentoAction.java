/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.banco.tipodocumento.action;

import co.com.adminso.banco.tipodocumento.jsfb.TipoDocumentoJSFB;
import co.com.adminso.core.ApplicationJSFB;
import co.com.adminsol.entitys.TipoDocumento;
import co.com.adminsol.modelo.DatosUsuario;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author MARA
 */
@ManagedBean(name = "crearTipoDocumentoAction")
@RequestScoped
public class CrearTipoDocumentoAction extends ApplicationJSFB {

    @ManagedProperty("#{tipoDocumentoJSFB}")
    private TipoDocumentoJSFB tipoDocumentoJSFB;
    private FacesContext ctx;
    private String nombreDocumento;
    private DatosUsuario datosUsuario;

    @PostConstruct
    public void init() {
        ctx = FacesContext.getCurrentInstance();
        datosUsuario = getUser(ctx);
    }

    public void crearDocumento(ActionEvent event) {
        try {
            TipoDocumento tipoDocumento = new TipoDocumento();
            tipoDocumento.setDescDocumento(nombreDocumento);
            tipoDocumentoJSFB.getFacade().crearTipoDocumento(datosUsuario, tipoDocumento);
            presentarInfo(ctx, "Mensaje", "Se creo correctamente el tipo de documento");
        } catch (Exception ex) {
            presentarError(ctx, "Error", ex.getMessage());
        }
    }

    public TipoDocumentoJSFB getTipoDocumentoJSFB() {
        return tipoDocumentoJSFB;
    }

    public void setTipoDocumentoJSFB(TipoDocumentoJSFB tipoDocumentoJSFB) {
        this.tipoDocumentoJSFB = tipoDocumentoJSFB;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

}
