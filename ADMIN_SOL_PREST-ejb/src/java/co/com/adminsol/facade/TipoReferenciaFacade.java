/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.TipoReferencia;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class TipoReferenciaFacade extends GenericDAO<TipoReferencia>{

    public TipoReferenciaFacade() {
        super(TipoReferencia.class);
    }

    public void crear( TipoReferencia tipoReferencia){
        save(tipoReferencia);
    }
    
    public void modificar(TipoReferencia tipoReferencia ){
        update(tipoReferencia);
    }
    
    public void eliminar( TipoReferencia tipoReferencia){
        delete(tipoReferencia);
    }
    
    public List<TipoReferencia> getAllList(){
        return findAll();
    }
}
