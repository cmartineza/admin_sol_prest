/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.archivo.jsfb;

import co.com.adminsol.entitys.DocumentoUsuario;
import co.com.adminsol.entitys.TipoDocumento;
import co.com.adminsol.facade.DocumentoUsuarioFacade;
import co.com.adminsol.facade.TipoDocumentoFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author MARA
 */
@ManagedBean
@SessionScoped
public class ArchivoJSFB {

    @EJB
    private DocumentoUsuarioFacade archivoFacade;
    private List<DocumentoUsuario> listFilterDoc;

    public DocumentoUsuarioFacade getArchivoFacade() {
        return archivoFacade;
    }

    public void setArchivoFacade(DocumentoUsuarioFacade archivoFacade) {
        this.archivoFacade = archivoFacade;
    }

    public List<DocumentoUsuario> getListFilterDoc() {
        return listFilterDoc;
    }

    public void setListFilterDoc(List<DocumentoUsuario> listFilterDoc) {
        this.listFilterDoc = listFilterDoc;
    }
}
