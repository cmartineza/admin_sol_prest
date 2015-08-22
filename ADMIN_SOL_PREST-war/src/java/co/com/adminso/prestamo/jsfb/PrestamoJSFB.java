/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.prestamo.jsfb;

import co.com.adminsol.entitys.Cliente;
import co.com.adminsol.entitys.EstadoPrestamo;
import co.com.adminsol.entitys.Prestamo;
import co.com.adminsol.entitys.ReferenciasClientes;
import co.com.adminsol.facade.ClienteFacade;
import co.com.adminsol.facade.EstadoPrestamoFacade;
import co.com.adminsol.facade.PrestamoFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author MARA
 */
@ManagedBean(name = "prestamoJSFB")
@SessionScoped
public class PrestamoJSFB {

    @EJB
    private ClienteFacade clienteFacade;
    @EJB
    private PrestamoFacade prestamoFacade;
    @EJB
    private EstadoPrestamoFacade epFacade;
    private Cliente clienteConsulta;
    private List<ReferenciasClientes> listReferencia;
    private List<Prestamo> listPrestamoFilter;
    private List<EstadoPrestamo> listEstadoPrestamo;
    private Prestamo prestamo;

    @PostConstruct
    public void init() {
        listEstadoPrestamo = epFacade.listEstadosPrestamo();
    }

    public ClienteFacade getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    public Cliente getClienteConsulta() {
        return clienteConsulta;
    }

    public void setClienteConsulta(Cliente clienteConsulta) {
        this.clienteConsulta = clienteConsulta;
    }

    public List<ReferenciasClientes> getListReferencia() {
        return listReferencia;
    }

    public void setListReferencia(List<ReferenciasClientes> listReferencia) {
        this.listReferencia = listReferencia;
    }

    public PrestamoFacade getPrestamoFacade() {
        return prestamoFacade;
    }

    public void setPrestamoFacade(PrestamoFacade prestamoFacade) {
        this.prestamoFacade = prestamoFacade;
    }

    public List<Prestamo> getListPrestamoFilter() {
        return listPrestamoFilter;
    }

    public void setListPrestamoFilter(List<Prestamo> listPrestamoFilter) {
        this.listPrestamoFilter = listPrestamoFilter;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public List<EstadoPrestamo> getListEstadoPrestamo() {
        return listEstadoPrestamo;
    }

    public void setListEstadoPrestamo(List<EstadoPrestamo> listEstadoPrestamo) {
        this.listEstadoPrestamo = listEstadoPrestamo;
    }
    
    public boolean mostrarCrearProyeccion(){
        return !(this.prestamo.getProyeccionPagoList() != null 
                && !this.prestamo.getProyeccionPagoList().isEmpty());
    }
}
