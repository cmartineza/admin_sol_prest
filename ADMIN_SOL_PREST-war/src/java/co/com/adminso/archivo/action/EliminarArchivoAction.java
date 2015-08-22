/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.archivo.action;

import co.com.adminso.archivo.jsfb.ArchivoJSFB;
import co.com.adminso.core.ApplicationJSFB;
import co.com.adminsol.entitys.DocumentoUsuario;
import co.com.adminsol.modelo.DatosUsuario;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author MARA
 */
@ManagedBean
@RequestScoped
public class EliminarArchivoAction extends ApplicationJSFB{

    @ManagedProperty("#{archivoJSFB}") private ArchivoJSFB archivoJSFB;
    private DatosUsuario datosUsuario;
    private FacesContext ctx;
    
    @PostConstruct
    public void init(){
        ctx = FacesContext.getCurrentInstance();
        datosUsuario = getUser(ctx);
    }
    
    public void eliminar(DocumentoUsuario documentoUsuario){
        try{
            archivoJSFB.getArchivoFacade().eliminar(documentoUsuario);
            redirectPage(ctx, "secure/m_credito/ingreso_prestamo.xhtml");
        }catch(Exception ex){
            logger.error("Error eliminando documento.", ex);
            presentarError(ctx, "Error", ex.getMessage());
        }
    }

    public ArchivoJSFB getArchivoJSFB() {
        return archivoJSFB;
    }

    public void setArchivoJSFB(ArchivoJSFB archivoJSFB) {
        this.archivoJSFB = archivoJSFB;
    }
}
