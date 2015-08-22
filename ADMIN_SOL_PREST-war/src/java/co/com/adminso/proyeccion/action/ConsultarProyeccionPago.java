/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.proyeccion.action;

import co.com.adminso.core.ApplicationJSFB;
import co.com.adminso.prestamo.jsfb.PrestamoJSFB;
import co.com.adminso.proyeccion.jsfb.ProyeccionPagoJSFB;
import co.com.adminsol.entitys.ProyeccionPago;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
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
public class ConsultarProyeccionPago extends ApplicationJSFB{
    
    @ManagedProperty("#{proyeccionPagoJSFB}")
    private ProyeccionPagoJSFB proyeccionPagoJSFB;
    @ManagedProperty("#{prestamoJSFB}")
    private PrestamoJSFB prestamoJSFB;
    private FacesContext context;
    private ProyeccionPago proyeccionPago;
    private BigDecimal idProyeccionPago;
    private boolean mostrarCrear;
    private List<ProyeccionPago> listProyeccion;
    
    @PostConstruct
    public void init(){
        try{
        context = FacesContext.getCurrentInstance();
        List<ProyeccionPago> idProPago  = prestamoJSFB.getPrestamo().getProyeccionPagoList();
        if( idProPago != null && idProPago.size() > 0){
            idProyeccionPago = idProPago.get(0).getProyeccionId();
            proyeccionPago = proyeccionPagoJSFB.getProyeccionPagoFacade().buscar(idProyeccionPago);
            mostrarCrear = true;
            listProyeccion = new ArrayList<>();
            for(int i = 0; i < proyeccionPago.getCalculo(); i ++){
                ProyeccionPago aux = new ProyeccionPago();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(proyeccionPago.getFechaPago());
                calendar.add(Calendar.MONTH, i);
                aux.setFechaPago(calendar.getTime());
                aux.setNoCuenta(proyeccionPago.getNoCuenta());
                aux.setPagoMinimo(proyeccionPago.getPagoMinimo());
                listProyeccion.add(aux);
            }
        }else{
            mostrarCrear = true;
        }
        }catch(Exception ex){
            logger.error("ConsultrProyeccionPago", ex);
            presentarError(context, "Error", "Error Tecnico");
        }
    }

    public ProyeccionPago getProyeccionPago() {
        return proyeccionPago;
    }

    public void setProyeccionPago(ProyeccionPago proyeccionPago) {
        this.proyeccionPago = proyeccionPago;
    }

    public BigDecimal getIdProyeccionPago() {
        return idProyeccionPago;
    }

    public void setIdProyeccionPago(BigDecimal idProyeccionPago) {
        this.idProyeccionPago = idProyeccionPago;
    }

    public boolean isMostrarCrear() {
        return mostrarCrear;
    }

    public void setMostrarCrear(boolean mostrarCrear) {
        this.mostrarCrear = mostrarCrear;
    }

    public List<ProyeccionPago> getListProyeccion() {
        return listProyeccion;
    }

    public void setListProyeccion(List<ProyeccionPago> listProyeccion) {
        this.listProyeccion = listProyeccion;
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
}
