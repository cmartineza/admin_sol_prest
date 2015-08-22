/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import co.com.adminsol.entitys.TipoIdentificacion;
import java.util.List;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class TipoIdentificacionFacade extends GenericDAO<TipoIdentificacion>{

    public TipoIdentificacionFacade() {
        super(TipoIdentificacion.class);
    }

    public void crear(TipoIdentificacion identificacion){
        save(identificacion);
    }
    
    public void modificar(TipoIdentificacion identificacion){
        update(identificacion);
    }
    
    public void eliminar(TipoIdentificacion identificacion){
        delete(identificacion);
    }
    
    public List<TipoIdentificacion> getAllList(){
        return findAll();
    }
}
