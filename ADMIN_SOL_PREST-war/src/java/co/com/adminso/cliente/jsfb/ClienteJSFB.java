/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.cliente.jsfb;

import co.com.adminsol.entitys.Ciudad;
import co.com.adminsol.entitys.Cliente;
import co.com.adminsol.entitys.Eps;
import co.com.adminsol.entitys.EstadoCivil;
import co.com.adminsol.entitys.TenenciaVivienda;
import co.com.adminsol.entitys.TipoIdentificacion;
import co.com.adminsol.entitys.TipoVivienda;
import co.com.adminsol.facade.CiudadFacade;
import co.com.adminsol.facade.ClienteFacade;
import co.com.adminsol.facade.EpsFacade;
import co.com.adminsol.facade.EstadoCivilFacade;
import co.com.adminsol.facade.TenenciaViviendaFacade;
import co.com.adminsol.facade.TipoIdentificacionFacade;
import co.com.adminsol.facade.TipoViviendaFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author MARA
 */
@ManagedBean(name = "clienteJSFB")
@SessionScoped
public class ClienteJSFB {

    private @EJB
    ClienteFacade clienteFacade;
    private @EJB
    TipoIdentificacionFacade tipoIdentificacionFacade;
    private @EJB
    EpsFacade epsFacade;
    private @EJB
    TenenciaViviendaFacade tenenciaViviendaFacade;
    private @EJB
    TipoViviendaFacade tipoViviendaFacade;
    private @EJB
    EstadoCivilFacade estadoCivilFacade;
    private @EJB
    CiudadFacade ciudadFacade;
    private Cliente clienteTarget;
    private List<TipoIdentificacion> listTipoIdentificacion;
    private List<Eps> listEps;
    private List<TenenciaVivienda> listTenenciaVivienda;
    private List<TipoVivienda> listTipoVivienda;
    private List<EstadoCivil> listEstadoCivil;
    private List<Ciudad> listCiudad;
    private List<Cliente> listClienteFiltro;

    @PostConstruct
    public void init() {
        listTipoIdentificacion = tipoIdentificacionFacade.getAllList();
        listEps = epsFacade.getAllList();
        listTenenciaVivienda = tenenciaViviendaFacade.getAllList();
        listTipoVivienda = tipoViviendaFacade.getAllList(); 
        listEstadoCivil = estadoCivilFacade.getAllList();
        listCiudad = ciudadFacade.getAllList();
    }

    public ClienteFacade getClienteFacade() {
        return clienteFacade;
    }

    public void setClienteFacade(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    public Cliente getClienteTarget() {
        return clienteTarget;
    }

    public void setClienteTarget(Cliente clienteTarget) {
        this.clienteTarget = clienteTarget;
    }

    public List<TipoIdentificacion> getListTipoIdentificacion() {
        return listTipoIdentificacion;
    }

    public void setListTipoIdentificacion(List<TipoIdentificacion> listTipoIdentificacion) {
        this.listTipoIdentificacion = listTipoIdentificacion;
    }

    public List<Eps> getListEps() {
        return listEps;
    }

    public void setListEps(List<Eps> listEps) {
        this.listEps = listEps;
    }

    public List<TenenciaVivienda> getListTenenciaVivienda() {
        return listTenenciaVivienda;
    }

    public void setListTenenciaVivienda(List<TenenciaVivienda> listTenenciaVivienda) {
        this.listTenenciaVivienda = listTenenciaVivienda;
    }

    public List<TipoVivienda> getListTipoVivienda() {
        return listTipoVivienda;
    }

    public void setListTipoVivienda(List<TipoVivienda> listTipoVivienda) {
        this.listTipoVivienda = listTipoVivienda;
    }

    public List<EstadoCivil> getListEstadoCivil() {
        return listEstadoCivil;
    }

    public void setListEstadoCivil(List<EstadoCivil> listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    public List<Ciudad> getListCiudad() {
        return listCiudad;
    }

    public void setListCiudad(List<Ciudad> listCiudad) {
        this.listCiudad = listCiudad;
    }

    public List<Cliente> getListClienteFiltro() {
        return listClienteFiltro;
    }

    public void setListClienteFiltro(List<Cliente> listClienteFiltro) {
        this.listClienteFiltro = listClienteFiltro;
    }
}
