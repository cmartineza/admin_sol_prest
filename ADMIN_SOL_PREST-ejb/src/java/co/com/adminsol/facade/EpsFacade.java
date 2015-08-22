/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.Eps;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class EpsFacade extends GenericDAO<Eps>{

    public EpsFacade() {
        super(Eps.class);
    }

    public void crear( Eps eps){
        save(eps);
    }
    
    public void modificar(Eps eps){
        update(eps);
    }
    
    public void eliminar(Eps eps){
        delete(eps);
    }
    
    public List<Eps> getAllList(){
        return findAll();
    }
}
