/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.Cliente;
import co.com.adminsol.entitys.DocumentoUsuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import static java.nio.file.Files.delete;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class DocumentoUsuarioFacade extends GenericDAO<DocumentoUsuario> {

    public DocumentoUsuarioFacade() {
        super(DocumentoUsuario.class);
    }

    public void crear(DocumentoUsuario documentoUsuario, InputStream inputStream) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
            save(documentoUsuario);
            String pathProp = System.getProperty("ConfigProperties");
            String archivo = "\\config.properties";
            Properties properties = new Properties();
            properties.load(new FileInputStream(pathProp + archivo));
            File folder = new File(properties.getProperty("ruta_archivos") + documentoUsuario.getNumeroDocumento());
            if (!folder.mkdir()) {
                folder.mkdirs();
            }

            File file = new File(folder.getAbsolutePath(), sdf.format(new Date()) + "_" + documentoUsuario.getNombreDocumento());
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new RuntimeException("Error creando el archivo.");
                }
            }
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(buffer);
            documentoUsuario.setCarpeta(file.getAbsolutePath());
            update(documentoUsuario);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void modificar(DocumentoUsuario documentoUsuario) {
        update(documentoUsuario);
    }

    public void eliminar(DocumentoUsuario documentoUsuario) {
        delete(documentoUsuario);
        File file = new File(documentoUsuario.getCarpeta());
        if(file.delete()){
            System.out.println("Se elimino archivo");
        }
        
    }

    public List<DocumentoUsuario> getAllList() {
        return findAll();
    }
    
    public List<DocumentoUsuario> listDocumentosCliente(Cliente cliente){
        Map map = new HashMap();
        map.put("numeroDocumento", cliente.getClientePK().getNumeroDocumento());
        map.put("idTpoDoc", String.valueOf(cliente.getClientePK().getTipoIdentificacion()));
        return executeQueryListResult("DocumentoUsuario.findByCliente", map);
    }
}
