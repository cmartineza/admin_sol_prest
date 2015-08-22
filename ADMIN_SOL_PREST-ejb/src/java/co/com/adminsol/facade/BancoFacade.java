/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.Banco;
import co.com.adminsol.modelo.DatosUsuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class BancoFacade extends GenericDAO<Banco>{

    public BancoFacade(){
        super(Banco.class);
    }
    
    public List<Banco> getAllList(DatosUsuario datosUsuario){
        return findAll();
    }
    
    public Banco buscarId(DatosUsuario datosUsuario, Short idBanco){
        return find(idBanco);
    }
    
    public void crearBanco(DatosUsuario datosUsuario, Banco banco){
        banco.setNombreBanco(banco.getNombreBanco().toUpperCase().trim());
        Map map = new HashMap();        
        map.put("nombreBanco", "%"+banco.getNombreBanco()+"%");
        List<Banco> list = executeQueryListResult("Banco.findLikeNombre", map);
        if(list != null && list.isEmpty()){
            save(banco);
        }else{
            throw new RuntimeException("El banco ya existe");
        }       
    }
    
    public void modificar(DatosUsuario datosUsuario, Banco banco){
         banco.setNombreBanco(banco.getNombreBanco().toUpperCase().trim());
        Map map = new HashMap();        
        map.put("nombreBanco", banco.getNombreBanco());
        List<Banco> list = executeQueryListResult("Banco.findLikeNombre", map);
        if(list != null && list.isEmpty()){
            update(banco);
        }else{
            throw new RuntimeException("El banco ya existe");
        }       
        
    }
    
    public void eliminarBanco(DatosUsuario datosUsuario, Short idBanco){
        Banco banco = find(idBanco);
        if( banco != null ){
            if(banco.getPrestamoList() != null && banco.getPrestamoList().isEmpty() ){
                delete(banco);
            }else{
                throw new RuntimeException("El banco no se puede eliminar, se encuentra asociado a un prestamo");
            }
        }
    }
}
