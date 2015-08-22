/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.alerta.action;

import co.com.adminso.alerta.jsfb.AlertaJSFB;
import co.com.adminso.core.ApplicationJSFB;
import co.com.adminsol.entitys.Alerta;
import javax.annotation.PostConstruct;
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
public class ModificarAlertaAction extends ApplicationJSFB {

    @ManagedProperty("#{AlertaJSFB}")
    private AlertaJSFB alertaJSFB;
    private Alerta alertaTarget;
    private FacesContext facesContext;

    @PostConstruct
    public void init() {
        facesContext = FacesContext.getCurrentInstance();
    }

    public void modificarAlerta(ActionEvent actionEventl) {
        try {
            Alerta alerta = alertaJSFB.getAlertaFacade().findById(alertaTarget.getIdAlerta());
            alerta.setActiva("N");
            alertaJSFB.getAlertaFacade().modificarAlerta(alerta);
            presentarInfo(facesContext, "Mensaje", "Se modifico correctamente la alerta");
        } catch (Exception ex) {
            logger.error("modificarAlerta", ex);
            presentarError(facesContext, "Error", "Se ha presentado un error tecnico");
        }
    }

    public Alerta getAlertaTarget() {
        return alertaTarget;
    }

    public void setAlertaTarget(Alerta alertaTarget) {
        this.alertaTarget = alertaTarget;
    }

    public AlertaJSFB getAlertaJSFB() {
        return alertaJSFB;
    }

    public void setAlertaJSFB(AlertaJSFB alertaJSFB) {
        this.alertaJSFB = alertaJSFB;
    }
}
