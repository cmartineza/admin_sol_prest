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
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author MARA
 */
@ManagedBean(name = "listarTipoDocumentoAction")
@RequestScoped
public class ListarTipoDocumentoAction extends ApplicationJSFB {

    @ManagedProperty("#{tipoDocumentoJSFB}")
    private TipoDocumentoJSFB tipoDocumentoJSFB;
    private FacesContext ctx;
    private DatosUsuario datosUsuario;
    private List<TipoDocumento> listTipoDocumento;

    @PostConstruct
    public void init() {
        ctx = FacesContext.getCurrentInstance();
        datosUsuario = getUser(ctx);
        listTipoDocumento = tipoDocumentoJSFB.getFacade().getAllList(datosUsuario);
    }

    public TipoDocumentoJSFB getTipoDocumentoJSFB() {
        return tipoDocumentoJSFB;
    }

    public void setTipoDocumentoJSFB(TipoDocumentoJSFB tipoDocumentoJSFB) {
        this.tipoDocumentoJSFB = tipoDocumentoJSFB;
        }

    public List<TipoDocumento> getListTipoDocumento() {
        return listTipoDocumento;
    }

    public void setListTipoDocumento(List<TipoDocumento> listTipoDocumento) {
        this.listTipoDocumento = listTipoDocumento;
    }

}
