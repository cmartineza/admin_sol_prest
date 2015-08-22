/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.TipoPrestamo;
import java.util.List;

/**
 *
 * @author MARA
 */
public class TipoPrestamoFacade extends GenericDAO<TipoPrestamo>{

    public TipoPrestamoFacade() {
        super(TipoPrestamo.class);
    }

    public void crear(TipoPrestamo tipoPrestamo){
        save(tipoPrestamo);
    }
    
    public void modificar(TipoPrestamo tipoPrestamo){
        update(tipoPrestamo);
    }
    
    public void eliminar(TipoPrestamo tipoPrestamo){
        delete(tipoPrestamo);
    }
    
    public List<TipoPrestamo> getAllList(){
        return findAll();
    }
}
