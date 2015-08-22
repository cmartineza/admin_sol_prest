/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.ProyeccionPago;
import java.math.BigDecimal;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class ProyeccionPagoFacade extends GenericDAO<ProyeccionPago> {

    public ProyeccionPagoFacade() {
        super(ProyeccionPago.class);
    }

    public ProyeccionPago buscar(BigDecimal idProyeccion) {
        return find(idProyeccion);
    }

    public void crearProyeccion(ProyeccionPago proyeccionPago) {
        save(proyeccionPago);
    }

    public void modificarProyeccion(ProyeccionPago proyeccionPago) {
        update(proyeccionPago);
    }
}
