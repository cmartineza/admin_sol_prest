/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.cliente.action;

import co.com.adminso.cliente.jsfb.ClienteJSFB;
import co.com.adminso.core.ApplicationJSFB;
import co.com.adminsol.entitys.Ciudad;
import co.com.adminsol.entitys.Cliente;
import co.com.adminsol.entitys.ClientePK;
import co.com.adminsol.entitys.Eps;
import co.com.adminsol.entitys.EstadoCivil;
import co.com.adminsol.entitys.TenenciaVivienda;
import co.com.adminsol.entitys.TipoVivienda;
import co.com.adminsol.modelo.DatosUsuario;
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
public class CrearClienteAction extends ApplicationJSFB {

    private @ManagedProperty("#{clienteJSFB}")
    ClienteJSFB clienteJSFB;
    private Cliente cliente;
    private ClientePK clientePK;
    private FacesContext ctx;
    private DatosUsuario datosUsuario;
    private String idCliente;
    private Short idTipoId;
    private Short idTipoVivienda;
    private Short idTenenciaVivienda;
    private Short idCiudadResidencia;
    private Short idEstadoCivil;
    private Short idEps;

    @PostConstruct
    public void init() {
        ctx = FacesContext.getCurrentInstance();
        clientePK = new ClientePK();
        cliente = new Cliente();
        datosUsuario = getUser(ctx);
    }

    public void crear(ActionEvent event) {
        try {
            //clientePK.setTipoIdentificacion(idTipoId);
            if (idTipoVivienda != null) {
                cliente.setTipoVivienda(new TipoVivienda(idTipoVivienda));
            }

            if (idTenenciaVivienda != null) {
                cliente.setTenenciaVivienda(new TenenciaVivienda(idTenenciaVivienda));
            }

            if (idCiudadResidencia != null) {
                cliente.setCiudadResidencia(new Ciudad(idCiudadResidencia));
            }

            if (idEstadoCivil != null) {
                cliente.setEstadoCivil(new EstadoCivil(idEstadoCivil));
            }
            
            if(idEps != null){
                cliente.setEps(new Eps(idEps));
            }

            cliente.setClientePK(clientePK);

            clienteJSFB.getClienteFacade().crear(cliente);
            cliente = new Cliente();
            idCiudadResidencia = null;
            idCliente = null;
            idEps = null;
            idEstadoCivil = null;
            idTenenciaVivienda = null;
            idTipoId  = null;
            idTipoVivienda  = null;
            presentarInfo(ctx, "Mensaje", "Se creo correctamente el cliente");
        } catch (Exception ex) {
            presentarError(ctx, "Error", ex.getMessage());
        }
    }

    public ClienteJSFB getClienteJSFB() {
        return clienteJSFB;
    }

    public void setClienteJSFB(ClienteJSFB clienteJSFB) {
        this.clienteJSFB = clienteJSFB;
    }
    
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Short getIdTipoId() {
        return idTipoId;
    }

    public void setIdTipoId(Short idTipoId) {
        this.idTipoId = idTipoId;
    }

    public Short getIdTipoVivienda() {
        return idTipoVivienda;
    }

    public void setIdTipoVivienda(Short idTipoVivienda) {
        this.idTipoVivienda = idTipoVivienda;
    }

    public Short getIdTenenciaVivienda() {
        return idTenenciaVivienda;
    }

    public void setIdTenenciaVivienda(Short idTenenciaVivienda) {
        this.idTenenciaVivienda = idTenenciaVivienda;
    }

    public Short getIdCiudadResidencia() {
        return idCiudadResidencia;
    }

    public void setIdCiudadResidencia(Short idCiudadResidencia) {
        this.idCiudadResidencia = idCiudadResidencia;
    }

    public Short getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Short idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Short getIdEps() {
        return idEps;
    }

    public void setIdEps(Short idEps) {
        this.idEps = idEps;
    }

    public ClientePK getClientePK() {
        return clientePK;
    }

    public void setClientePK(ClientePK clientePK) {
        this.clientePK = clientePK;
    }
}
