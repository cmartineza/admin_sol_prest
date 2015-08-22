/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.prestamo.action;

import co.com.adminso.core.ApplicationJSFB;
import co.com.adminso.prestamo.jsfb.PrestamoJSFB;
import co.com.adminsol.entitys.EstadoPrestamo;
import co.com.adminsol.entitys.Prestamo;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author MARA
 */
@ManagedBean
@RequestScoped
public class ModificarPrestamoAction extends ApplicationJSFB{

    @ManagedProperty("#{prestamoJSFB}")
    private PrestamoJSFB pjsfb;
    
    public void modificar(ActionEvent actionEvent){
        Prestamo prestamoMemo = pjsfb.getPrestamo();
        try {
            Prestamo prestamoM = pjsfb.getPrestamoFacade().buscarPrestamo(prestamoMemo.getPrestamoId());
            prestamoM.setValorAprobado(prestamoMemo.getValorAprobado());
            prestamoM.setEstadoPrestamo(new EstadoPrestamo(prestamoMemo.getEstadoPrestamo().getEstadoId()));
            prestamoM.setFechaRadicacion(prestamoMemo.getFechaRadicacion());
            prestamoM.setAlerta(prestamoMemo.getAlerta());
            prestamoM.setProPago(prestamoMemo.getProPago());
            pjsfb.getPrestamoFacade().modificar(prestamoM);
            presentarInfo(FacesContext.getCurrentInstance(), "Mensaje", "Se actualizo correctamente el prestamo.");
        }catch(Exception ex){
            logger.error("ModificarPrestamoAction", ex);
            presentarError(FacesContext.getCurrentInstance(), "Error", "Se ha presentado un error");
        }
    }

    public PrestamoJSFB getPjsfb() {
        return pjsfb;
    }

    public void setPjsfb(PrestamoJSFB pjsfb) {
        this.pjsfb = pjsfb;
    }
}
