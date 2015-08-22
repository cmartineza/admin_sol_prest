/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.archivo.action;

import co.com.adminso.archivo.jsfb.ArchivoJSFB;
import co.com.adminso.core.ApplicationJSFB;
import co.com.adminso.prestamo.action.ConsultarClienteAction;
import co.com.adminsol.entitys.Cliente;
import co.com.adminsol.entitys.DocumentoUsuario;
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
@ManagedBean
@RequestScoped
public class ListarArchivoAction extends ApplicationJSFB{

    @ManagedProperty("#{archivoJSFB}") ArchivoJSFB archivoJSFB;
    private List<DocumentoUsuario>  listDocumento;
    private Cliente cliente;
    private FacesContext ctx;
    
    @PostConstruct
    public void init(){
        ctx = FacesContext.getCurrentInstance();
        cliente = (Cliente) ctx.getExternalContext().getSessionMap()
                .get(ConsultarClienteAction.USUARIO_KEY_CONSULTA);
        if(cliente != null){
            listDocumento = archivoJSFB.getArchivoFacade().listDocumentosCliente(cliente);
        }
    }

    public ArchivoJSFB getArchivoJSFB() {
        return archivoJSFB;
    }

    public void setArchivoJSFB(ArchivoJSFB archivoJSFB) {
        this.archivoJSFB = archivoJSFB;
    }

    public List<DocumentoUsuario> getListDocumento() {
        return listDocumento;
    }

    public void setListDocumento(List<DocumentoUsuario> listDocumento) {
        this.listDocumento = listDocumento;
    }
    
    
    
}
