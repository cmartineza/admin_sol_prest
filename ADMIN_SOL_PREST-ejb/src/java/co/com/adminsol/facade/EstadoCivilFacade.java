/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.EstadoCivil;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class EstadoCivilFacade  extends GenericDAO<EstadoCivil>{

    public EstadoCivilFacade() {
        super(EstadoCivil.class);
    }

    public void crear(EstadoCivil  estadoCivil){
        save(estadoCivil);
    }
    
    public void modificar(EstadoCivil estadoCivil){
        update(estadoCivil);
    }
    
    public void eliminar(EstadoCivil estadoCivil){
        delete(estadoCivil);
    }
    
    public List<EstadoCivil> getAllList(){
        return findAll();
    }
}
