/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.reportes.totalaprobado.action;

import co.com.adminso.core.ApplicationJSFB;
import co.com.adminsol.entitys.Prestamo;
import co.com.adminsol.facade.PrestamoFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author MARA
 */
@ManagedBean
@RequestScoped
public class ListarTotalAprobadoAction extends ApplicationJSFB {

    @EJB
    private PrestamoFacade prestamoFacade;
    private FacesContext facesContext;
    private Date fechaInicial;
    private Date fechaFinal;
    private List<Prestamo> listPrestamo;
    private BigDecimal sumaTotal;

    @PostConstruct
    public void init() {
        facesContext = FacesContext.getCurrentInstance();
    }

    public void listarResultado(ActionEvent actionEvent) {
        try {
            listPrestamo = prestamoFacade.listReporteTotal(fechaInicial, fechaFinal);
            if (listPrestamo != null && listPrestamo.size() > 0) {
                sumaTotal = new BigDecimal(BigInteger.ZERO);
                listPrestamo.stream().forEach((aux) -> {
                    sumaTotal = sumaTotal.add(new BigDecimal(aux.getValorAprobado().toString()));
                });
            }else{
                presentarInfo(facesContext, "Mensaje", "La consulta no genero ningun resultado");
            }
        } catch (Exception ex) {
            logger.error("listarResultado",ex);
            presentarError(facesContext, "Error", "Se ha presentado un error tecnico.");
        }
    }

    public PrestamoFacade getPrestamoFacade() {
        return prestamoFacade;
    }

    public void setPrestamoFacade(PrestamoFacade prestamoFacade) {
        this.prestamoFacade = prestamoFacade;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public List<Prestamo> getListPrestamo() {
        return listPrestamo;
    }

    public void setListPrestamo(List<Prestamo> listPrestamo) {
        this.listPrestamo = listPrestamo;
    }

    public BigDecimal getSumaTotal() {
        return sumaTotal;
    }

    public void setSumaTotal(BigDecimal sumaTotal) {
        this.sumaTotal = sumaTotal;
    }
}
