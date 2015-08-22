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
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.facelets.FaceletContext;

/**
 *
 * @author MARA
 */
@ManagedBean
@RequestScoped
public class ModificarClienteAction extends ApplicationJSFB {

    @ManagedProperty("#{clienteJSFB}")
    private ClienteJSFB clienteJSFB;
    private DatosUsuario datosUsuario;
    private FacesContext ctx;

    @PostConstruct
    public void init() {
        ctx = FacesContext.getCurrentInstance();
        datosUsuario = getUser(ctx);
    }

    public void modificar(ActionEvent event) {
        try {
            Cliente cliente = clienteJSFB.getClienteFacade()
                    .findById(clienteJSFB.getClienteTarget().getClientePK());
            cliente.setNombres(clienteJSFB.getClienteTarget().getNombres());
            cliente.setApellidos(clienteJSFB.getClienteTarget().getApellidos());
            cliente.setFechaNacimiento(clienteJSFB.getClienteTarget().getFechaNacimiento());
            cliente.setFechaExpedicionDoc(clienteJSFB.getClienteTarget().getFechaExpedicionDoc());
            cliente.setEmpresa(clienteJSFB.getClienteTarget().getEmpresa());
            cliente.setTelefono(clienteJSFB.getClienteTarget().getTelefono());
            cliente.setCelular(clienteJSFB.getClienteTarget().getCelular());
            cliente.setEmail(clienteJSFB.getClienteTarget().getEmail());
            cliente.setDireccionResidencia(clienteJSFB.getClienteTarget().getDireccionResidencia());
            cliente.setCiudadResidencia(clienteJSFB.getClienteTarget().getCiudadResidencia());
            cliente.setEps(clienteJSFB.getClienteTarget().getEps());
            cliente.setEstadoCivil(clienteJSFB.getClienteTarget().getEstadoCivil());
            cliente.setTipoVivienda(clienteJSFB.getClienteTarget().getTipoVivienda());
            clienteJSFB.getClienteFacade().modificar(cliente);
        
            presentarInfo(ctx, "Mensaje", "Se modfico correctamente el cliente");
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
}
