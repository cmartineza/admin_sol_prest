/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.EstadoPrestamo;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class EstadoPrestamoFacade extends GenericDAO<EstadoPrestamo>{
    
    public EstadoPrestamoFacade(){
        super(EstadoPrestamo.class);
    }
    
    public List<EstadoPrestamo> listEstadosPrestamo(){
        return findAll();
    }
}
