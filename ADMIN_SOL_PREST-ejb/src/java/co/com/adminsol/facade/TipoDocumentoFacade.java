/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import co.com.adminsol.entitys.TipoDocumento;
import co.com.adminsol.modelo.DatosUsuario;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class TipoDocumentoFacade extends GenericDAO<TipoDocumento>{

    public TipoDocumentoFacade(){
        super(TipoDocumento.class);
    }
    
    public List<TipoDocumento> getAllList(DatosUsuario datosUsuario){
        return findAll();
    }
    
    public TipoDocumento buscarId(DatosUsuario datosUsuario, Short idBanco){
        return find(idBanco);
    }
    
    public void crearTipoDocumento(DatosUsuario datosUsuario, TipoDocumento tipoDocumento){
        tipoDocumento.setDescDocumento(tipoDocumento.getDescDocumento().toUpperCase().trim());
        Map map = new HashMap();        
        map.put("descDocumento", tipoDocumento.getDescDocumento());
        List<TipoDocumento> list = executeQueryListResult("TipoDocumento.findLikeDocumento", map);
        if(list != null && list.isEmpty()){
            save(tipoDocumento);
        }else{
            throw new RuntimeException("El tipo documento ya existe");
        }       
    }
    
    public void modificarTipoDocumento(DatosUsuario datosUsuario, TipoDocumento tipoDocumento){
         tipoDocumento.setDescDocumento(tipoDocumento.getDescDocumento().toUpperCase().trim());
        Map map = new HashMap();        
        map.put("descDocumento", "%"+tipoDocumento.getDescDocumento()+"%");
        List<TipoDocumento> list = executeQueryListResult("TipoDocumento.findLikeDocumento", map);
        if(list != null && list.isEmpty()){
            update(tipoDocumento);
        }else{
            throw new RuntimeException("El tipo documento ya existe ya existe");
        }       
        
    }
    
    public void eliminarTipoDocumento(DatosUsuario datosUsuario, Short idBanco){
        TipoDocumento tipoDocumento = find(idBanco);
        if( tipoDocumento != null ){
            if(tipoDocumento.getDocumentoUsuarioList() != null && tipoDocumento.getDocumentoUsuarioList().isEmpty() ){
                delete(tipoDocumento);
            }else{
                throw new RuntimeException("El tipo de documento no se puede eliminar, se encuentra asociado a un cliente");
            }
        }
    }
}
