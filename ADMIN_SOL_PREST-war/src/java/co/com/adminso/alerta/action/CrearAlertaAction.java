/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.alerta.action;

import co.com.adminso.alerta.jsfb.AlertaJSFB;
import co.com.adminso.core.ApplicationJSFB;
import co.com.adminsol.entitys.ProyeccionPago;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author MARA
 */
@ManagedBean
@RequestScoped
public class CrearAlertaAction extends ApplicationJSFB{

    @ManagedProperty("#{alertaJSFB}")
    private AlertaJSFB alertaJSFB;
    private FacesContext facesContext;
    
    public CrearAlertaAction(){
        facesContext = FacesContext.getCurrentInstance();
    }

    public void crearAlerta(ProyeccionPago proyeccionPago) {
        try {
            alertaJSFB.getAlertaFacade().crearAlerta(proyeccionPago);
        } catch (Exception ex) {
            logger.error("CrearAlerta", ex);
            presentarError(facesContext, "Error", "Se ha presentado un error tecnico creando las alertas");
        }
    }

    public AlertaJSFB getAlertaJSFB() {
        return alertaJSFB;
    }

    public void setAlertaJSFB(AlertaJSFB alertaJSFB) {
        this.alertaJSFB = alertaJSFB;
    }

}
