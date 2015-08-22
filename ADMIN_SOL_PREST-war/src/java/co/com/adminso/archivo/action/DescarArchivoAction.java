/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.archivo.action;

import co.com.adminso.core.ApplicationJSFB;
import co.com.adminsol.entitys.DocumentoUsuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author MARA
 */
@ManagedBean
@SessionScoped
public class DescarArchivoAction extends ApplicationJSFB {

    public StreamedContent getArchivo(DocumentoUsuario documentoUsuario) {
        InputStream stream = null;
        StreamedContent file = null;
        
        try {
            stream = new FileInputStream(documentoUsuario.getCarpeta());
            file = new DefaultStreamedContent(stream,null, documentoUsuario.getNombreDocumento());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DescarArchivoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return file;
    }
}
