/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.banco.tipodocumento.jsfb;

import co.com.adminsol.entitys.TipoDocumento;
import co.com.adminsol.facade.TipoDocumentoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author MARA
 */
@ManagedBean(name = "tipoDocumentoJSFB")
@SessionScoped
public class TipoDocumentoJSFB {

    @EJB private TipoDocumentoFacade facade;
    private TipoDocumento documentoTarget;
    private List<TipoDocumento> listFiltro;
    
    public TipoDocumentoJSFB() {
    }

    public TipoDocumentoFacade getFacade() {
        return facade;
    }

    public void setFacade(TipoDocumentoFacade facade) {
        this.facade = facade;
    }

    public TipoDocumento getDocumentoTarget() {
        return documentoTarget;
    }

    public void setDocumentoTarget(TipoDocumento documentoTarget) {
        this.documentoTarget = documentoTarget;
    }

    public List<TipoDocumento> getListFiltro() {
        return listFiltro;
    }

    public void setListFiltro(List<TipoDocumento> listFiltro) {
        this.listFiltro = listFiltro;
    }
    
}
