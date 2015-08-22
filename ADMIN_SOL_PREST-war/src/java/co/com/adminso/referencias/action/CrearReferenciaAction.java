/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.referencias.action;

import co.com.adminso.core.ApplicationJSFB;
import co.com.adminso.prestamo.action.ConsultarClienteAction;
import co.com.adminso.referencias.jsfb.ReferenciaJSFB;
import co.com.adminsol.entitys.Cliente;
import co.com.adminsol.entitys.ClientePK;
import co.com.adminsol.entitys.Parentesco;
import co.com.adminsol.entitys.ReferenciasClientes;
import co.com.adminsol.entitys.TipoReferencia;
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
public class CrearReferenciaAction extends ApplicationJSFB {

    @ManagedProperty("#{referenciaJSFB}")
    ReferenciaJSFB referenciaJSFB;
    private FacesContext context;
    private DatosUsuario datosUsuario;
    private Short idTipoReferencia;
    private Short idTipoParentesco;
    private ReferenciasClientes referenciasClientes;
    private Cliente clienteConsultado;

    @PostConstruct
    public void init() {
        context = FacesContext.getCurrentInstance();
        datosUsuario = getUser(context);
        referenciasClientes = new ReferenciasClientes();
        clienteConsultado = (Cliente) context.getExternalContext()
                .getSessionMap().get(ConsultarClienteAction.USUARIO_KEY_CONSULTA);
        if (clienteConsultado == null) {
            throw new RuntimeException("No se econtro el cliente consultado");
        }
    }

    public void crearReferencia(ActionEvent event) {
        try {

            referenciasClientes.setCliente(clienteConsultado);
            referenciasClientes.setParentesco(new Parentesco(idTipoParentesco));
            referenciasClientes.setTipoReferencia(new TipoReferencia(idTipoReferencia));
            referenciaJSFB.getFacadeReferencias().crear(referenciasClientes);
            referenciasClientes = new ReferenciasClientes();
            idTipoReferencia = null;
            idTipoParentesco = null;
            presentarInfo(context, "Mensaje", "Se creo correctamente la referencia");
        } catch (Exception ex) {
            presentarError(context, "Error", ex.getMessage());
        }

    }

    public ReferenciaJSFB getReferenciaJSFB() {
        return referenciaJSFB;
    }

    public void setReferenciaJSFB(ReferenciaJSFB referenciaJSFB) {
        this.referenciaJSFB = referenciaJSFB;
    }

    public Short getIdTipoReferencia() {
        return idTipoReferencia;
    }

    public void setIdTipoReferencia(Short idTipoReferencia) {
        this.idTipoReferencia = idTipoReferencia;
    }

    public Short getIdTipoParentesco() {
        return idTipoParentesco;
    }

    public void setIdTipoParentesco(Short idTipoParentesco) {
        this.idTipoParentesco = idTipoParentesco;
    }

    public ReferenciasClientes getReferenciasClientes() {
        return referenciasClientes;
    }

    public void setReferenciasClientes(ReferenciasClientes referenciasClientes) {
        this.referenciasClientes = referenciasClientes;
    }
    
    

}
