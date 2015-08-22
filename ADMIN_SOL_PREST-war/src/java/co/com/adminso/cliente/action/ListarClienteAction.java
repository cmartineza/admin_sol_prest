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
public class ListarClienteAction extends ApplicationJSFB{

    @ManagedProperty("#{clienteJSFB}")
    private ClienteJSFB clienteJSFB;
    private List<Cliente> listCliente;
    private DatosUsuario datos;
    private FacesContext ctx;
    
    @PostConstruct
    public void init() {
        ctx = FacesContext.getCurrentInstance();
        datos = getUser(ctx);
        listCliente = clienteJSFB.getClienteFacade().getAllList();
    }

    public ClienteJSFB getClienteJSFB() {
        return clienteJSFB;
    }

    public void setClienteJSFB(ClienteJSFB clienteJSFB) {
        this.clienteJSFB = clienteJSFB;
    }

    public List<Cliente> getListCliente() {
        return listCliente;
    }

    public void setListCliente(List<Cliente> listCliente) {
        this.listCliente = listCliente;
    }    
}
