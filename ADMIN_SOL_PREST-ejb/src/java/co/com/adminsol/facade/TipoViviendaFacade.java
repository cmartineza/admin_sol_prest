/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.TipoVivienda;
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
public class TipoViviendaFacade extends GenericDAO<TipoVivienda>{

    public TipoViviendaFacade() {
        super(TipoVivienda.class);
    }

    public void crear(TipoVivienda tipoVivienda){
        save(tipoVivienda);
    }
    
    public void modificar(TipoVivienda tipoVivienda){
        update(tipoVivienda);
    }
    
    public void eliminar(TipoVivienda tipoVivienda){
        delete(tipoVivienda);
    }
    
    public List<TipoVivienda> getAllList(){
        return findAll();
    }
}
