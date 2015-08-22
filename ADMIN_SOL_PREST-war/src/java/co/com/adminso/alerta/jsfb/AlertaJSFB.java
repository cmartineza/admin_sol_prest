/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.alerta.jsfb;

import co.com.adminsol.entitys.Alerta;
import co.com.adminsol.facade.AlertaFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author MARA
 */
@ManagedBean
@SessionScoped
public class AlertaJSFB {

   @EJB private AlertaFacade alertaFacade;
   private Alerta alerta; 
   
    public AlertaJSFB() {
    }

    public AlertaFacade getAlertaFacade() {
        return alertaFacade;
    }

    public void setAlertaFacade(AlertaFacade alertaFacade) {
        this.alertaFacade = alertaFacade;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }
}
