/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.proyeccion.action;

import co.com.adminso.alerta.action.CrearAlertaAction;
import co.com.adminso.core.ApplicationJSFB;
import co.com.adminso.prestamo.jsfb.PrestamoJSFB;
import co.com.adminso.proyeccion.jsfb.ProyeccionPagoJSFB;
import co.com.adminsol.entitys.ProyeccionPago;
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
public class CrearProyeccionAction extends ApplicationJSFB {

    private ProyeccionPago proyeccionPago;
    @ManagedProperty("#{proyeccionPagoJSFB}")
    private ProyeccionPagoJSFB proyeccionPagoJSFB;
    @ManagedProperty("#{prestamoJSFB}")
    private PrestamoJSFB prestamoJSFB;
    @ManagedProperty("#{crearAlertaAction}")
    private CrearAlertaAction crearAlertaAction;
    private FacesContext ctx;

    @PostConstruct
    public void init() {
        ctx = FacesContext.getCurrentInstance();
        proyeccionPago = new ProyeccionPago();
    }

    public void crearProyeccion(ActionEvent actionEvent) {
        try{
            proyeccionPago.setPrestamo(prestamoJSFB.getPrestamo());
            proyeccionPago.setCalculo(new Short("6"));
            proyeccionPagoJSFB.getProyeccionPagoFacade().crearProyeccion(proyeccionPago);
            crearAlertaAction.crearAlerta(proyeccionPago);
            presentarInfo(ctx, "Mensaje", "Se guardo correctamente la información");
        }catch(Exception ex){
            logger.error("crearProyeccion",ex);
            presentarError(ctx, "Error", "Error tecnico");
        }
    }

    public ProyeccionPago getProyeccionPago() {
        return proyeccionPago;
    }

    public void setProyeccionPago(ProyeccionPago proyeccionPago) {
        this.proyeccionPago = proyeccionPago;
    }

    public ProyeccionPagoJSFB getProyeccionPagoJSFB() {
        return proyeccionPagoJSFB;
    }

    public void setProyeccionPagoJSFB(ProyeccionPagoJSFB proyeccionPagoJSFB) {
        this.proyeccionPagoJSFB = proyeccionPagoJSFB;
    }

    public PrestamoJSFB getPrestamoJSFB() {
        return prestamoJSFB;
    }

    public void setPrestamoJSFB(PrestamoJSFB prestamoJSFB) {
        this.prestamoJSFB = prestamoJSFB;
    }

    public CrearAlertaAction getCrearAlertaAction() {
        return crearAlertaAction;
    }

    public void setCrearAlertaAction(CrearAlertaAction crearAlertaAction) {
        this.crearAlertaAction = crearAlertaAction;
    }
}
