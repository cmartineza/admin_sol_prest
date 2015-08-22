/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.cliente.action;

import co.com.adminso.cliente.jsfb.ClienteJSFB;
import co.com.adminso.core.ApplicationJSFB;
import co.com.adminsol.entitys.Cliente;
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
public class EliminarClienteAction extends ApplicationJSFB {

    @ManagedProperty("#{clienteJSFB}")
    private ClienteJSFB clienteJSFB;
    private Cliente cliente;
    private DatosUsuario datosUsuario;
    private FacesContext ctx;

    @PostConstruct
    public void init() {
        ctx = FacesContext.getCurrentInstance();
        datosUsuario = getUser(ctx);
    }

    public void eliminar(Cliente cliente) {
        try {
            clienteJSFB.getClienteFacade().eliminar(cliente);
            redirectPage(ctx, "secure/m_admin/cliente_admin.xhtml");
        } catch (Exception ex) {
            presentarAdvertencia(ctx, "Error", ex.getMessage());
        }
    }

    public ClienteJSFB getClienteJSFB() {
        return clienteJSFB;
    }

    public void setClienteJSFB(ClienteJSFB clienteJSFB) {
        this.clienteJSFB = clienteJSFB;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    

}
