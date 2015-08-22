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
@ManagedBean(name = "modificarTipoDocumentoAction")
@RequestScoped
public class ModificarTipoDocumentoAction extends ApplicationJSFB{

    @ManagedProperty("#{tipoDocumentoJSFB}")
    private TipoDocumentoJSFB tipoDocumentoJSFB;
    private FacesContext ctx;
    private DatosUsuario datosUsuario;
    
    @PostConstruct
    public void init() {
        ctx = FacesContext.getCurrentInstance();
        datosUsuario = getUser(ctx);
    }

    public void modificar( ActionEvent event ) {
        try {
            TipoDocumento documento = tipoDocumentoJSFB.getFacade()
                    .buscarId(datosUsuario,tipoDocumentoJSFB.getDocumentoTarget().getTipoDocumentoId());
            documento.setDescDocumento(tipoDocumentoJSFB.getDocumentoTarget().getDescDocumento());
            tipoDocumentoJSFB.getFacade().modificarTipoDocumento(datosUsuario, documento);
            presentarInfo(ctx, "Mensaje", "Se modifico correctamente el tipo de documento");
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
}
