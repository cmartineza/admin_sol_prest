/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.proyeccion.jsfb;

import co.com.adminsol.entitys.ProyeccionPago;
import co.com.adminsol.facade.ProyeccionPagoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author MARA
 */
@ManagedBean
@SessionScoped
public class ProyeccionPagoJSFB {

    @EJB
    private ProyeccionPagoFacade proyeccionPagoFacade;
    private ProyeccionPago proyeccionPago;

    public ProyeccionPagoJSFB() {
    }

    public ProyeccionPagoFacade getProyeccionPagoFacade() {
        return proyeccionPagoFacade;
    }

    public void setProyeccionPagoFacade(ProyeccionPagoFacade proyeccionPagoFacade) {
        this.proyeccionPagoFacade = proyeccionPagoFacade;
    }

    public ProyeccionPago getProyeccionPago() {
        return proyeccionPago;
    }

    public void setProyeccionPago(ProyeccionPago proyeccionPago) {
        this.proyeccionPago = proyeccionPago;
    }
}
