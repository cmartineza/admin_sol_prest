/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.Parentesco;
import static java.nio.file.Files.delete;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class ParentescoFacade extends GenericDAO<Parentesco>{

    public ParentescoFacade() {
        super(Parentesco.class);
    }

    public void crear(Parentesco parentesco){
        save(parentesco);
    }
    
    public void modificar(Parentesco parentesco){
        update(parentesco);
    }
    
    public void eliminar(Parentesco parentesco){
        delete(parentesco);
    }
    
    public List<Parentesco> getAllList(){
        return findAll();
    }// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
