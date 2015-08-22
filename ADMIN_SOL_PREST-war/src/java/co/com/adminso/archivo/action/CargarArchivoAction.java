/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.archivo.action;

import co.com.adminso.archivo.jsfb.ArchivoJSFB;
import co.com.adminso.core.ApplicationJSFB;
import co.com.adminso.prestamo.action.ConsultarClienteAction;
import co.com.adminso.prestamo.jsfb.PrestamoJSFB;
import co.com.adminsol.entitys.Cliente;
import co.com.adminsol.entitys.DocumentoUsuario;
import co.com.adminsol.entitys.TipoDocumento;
import co.com.adminsol.entitys.TipoIdentificacion;
import co.com.adminsol.modelo.DatosUsuario;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author MARA
 */
@ManagedBean
@RequestScoped
public class CargarArchivoAction extends ApplicationJSFB{

    @ManagedProperty("#{archivoJSFB}") private ArchivoJSFB archivoJSFB;
    private FacesContext ctx;
    private DatosUsuario datosUsuario;
    private Short idTipoDocumento;
    private UploadedFile file;
    
    @PostConstruct
    public void init(){
        ctx = FacesContext.getCurrentInstance();
        datosUsuario = getUser(ctx);
    }
    
    public String adjuntarArchivo( ){
        Cliente cliente = (Cliente) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get(ConsultarClienteAction.USUARIO_KEY_CONSULTA);
        
        //UploadedFile file = event.getFile();
        DocumentoUsuario documentoUsuario = new DocumentoUsuario();
        documentoUsuario.setFechaCreacion(new Date());
        documentoUsuario.setNombreDocumento(file.getFileName());
        documentoUsuario.setTipoDocumento(new TipoDocumento(idTipoDocumento));
        documentoUsuario.setTipoIdentificacion(String.valueOf(cliente.getClientePK().getTipoIdentificacion()));
        documentoUsuario.setNumeroDocumento(cliente.getClientePK().getNumeroDocumento());
        
        try {
            archivoJSFB.getArchivoFacade().crear(documentoUsuario, file.getInputstream());
            presentarInfo(ctx, "Mensaje", "Se creo correctamente el archivo");
        } catch (IOException ex) {
            logger.error("CargarArchivoAction.adjuntarArchivo",ex );
            presentarError(ctx, "Error", ex.getMessage());
        }
        return "";
        
    }

    public ArchivoJSFB getArchivoJSFB() {
        return archivoJSFB;
    }

    public void setArchivoJSFB(ArchivoJSFB archivoJSFB) {
        this.archivoJSFB = archivoJSFB;
    }

    public Short getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Short idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    
}
