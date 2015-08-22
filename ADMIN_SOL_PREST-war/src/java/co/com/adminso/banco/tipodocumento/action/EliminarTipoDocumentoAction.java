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
import com.sun.prism.impl.BaseMesh;
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
@ManagedBean(name = "eliminarTipoDocumentoAction")
@RequestScoped
public class EliminarTipoDocumentoAction extends ApplicationJSFB{

    @ManagedProperty("#{tipoDocumentoJSFB}")
    private TipoDocumentoJSFB tipoDocumentoJSFB;
    private DatosUsuario datosUsuario; 
    private FacesContext ctx;
    private TipoDocumento tipoDocumento;
    
    @PostConstruct
    public void init(){
        ctx = FacesContext.getCurrentInstance();
        datosUsuario = getUser(ctx);
    }
    
    public void eliminar(TipoDocumento documento){
        try{
            tipoDocumentoJSFB.getFacade().eliminarTipoDocumento(datosUsuario, 
                    documento.getTipoDocumentoId());
            presentarInfo(ctx, "Mensaje", "Se elimino correctamente el tipo de documento");
        }catch(Exception ex){
            presentarError(ctx, "Error", "Se genero el error: "+ex.getMessage());
        }
        redirectPage(ctx, "secure/m_admin/documento_administracion.xhtml");
    }

    public TipoDocumentoJSFB getTipoDocumentoJSFB() {
        return tipoDocumentoJSFB;
    }

    public void setTipoDocumentoJSFB(TipoDocumentoJSFB tipoDocumentoJSFB) {
        this.tipoDocumentoJSFB = tipoDocumentoJSFB;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
