/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.TenenciaVivienda;
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
public class TenenciaViviendaFacade extends GenericDAO<TenenciaVivienda>{

    public TenenciaViviendaFacade() {
        super(TenenciaVivienda.class);
    }

    public void crear(TenenciaVivienda tenenciaVivienda){
        save(tenenciaVivienda);
    }
    
    public void modificar(TenenciaVivienda tenenciaVivienda){
        update(tenenciaVivienda);
    }
    
    public void eliminar(TenenciaVivienda tenenciaVivienda){
        delete(tenenciaVivienda);
    }
    
    public List<TenenciaVivienda> getAllList(){
        return findAll();
    }
}
