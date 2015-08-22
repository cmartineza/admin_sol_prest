/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.alerta.action;

import co.com.adminso.alerta.jsfb.AlertaJSFB;
import co.com.adminso.core.ApplicationJSFB;
import co.com.adminsol.entitys.Alerta;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class ListarAlertaAction extends ApplicationJSFB{

    @ManagedProperty("#{alertaJSFB}")
    private AlertaJSFB alertaJSFB;
    private List<Alerta> listAlerta;
    private FacesContext facesContext;
    
    @PostConstruct
    public void init(){
        facesContext = FacesContext.getCurrentInstance();        
        listAlerta = alertaJSFB.getAlertaFacade().listAlertasActivas();
    }
    
    public AlertaJSFB getAlertaJSFB() {
        return alertaJSFB;
    }

    public void setAlertaJSFB(AlertaJSFB alertaJSFB) {
        this.alertaJSFB = alertaJSFB;
    }

    public List<Alerta> getListAlerta() {
        return listAlerta;
    }

    public void setListAlerta(List<Alerta> listAlerta) {
        this.listAlerta = listAlerta;
    }    
}
