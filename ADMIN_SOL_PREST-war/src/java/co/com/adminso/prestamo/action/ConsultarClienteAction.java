/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.prestamo.action;

import co.com.adminso.core.ApplicationJSFB;
import co.com.adminsol.modelo.DatosUsuario;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import co.com.adminso.prestamo.jsfb.PrestamoJSFB;
import co.com.adminsol.entitys.Cliente;
import co.com.adminsol.entitys.ClientePK;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author MARA
 */
@ManagedBean(name = "consultarClienteAction")
@SessionScoped
public class ConsultarClienteAction extends ApplicationJSFB{
    
    @ManagedProperty("#{prestamoJSFB}") PrestamoJSFB prestamoJSFB;
    public static final String USUARIO_KEY_CONSULTA = "cliente_Prestamo";
    private DatosUsuario datosUsuario;
    private FacesContext ctx;
    private Short idTipoId;
    private String identificacion;
    
    @PostConstruct
    public void init(){
        ctx = FacesContext.getCurrentInstance();
        datosUsuario = getUser(ctx);
    }
    
    public void consultarCliente(ActionEvent event){
        ClientePK clientePK = new ClientePK();
        clientePK.setNumeroDocumento(identificacion);
        clientePK.setTipoIdentificacion(idTipoId);
        ctx = FacesContext.getCurrentInstance();
        Cliente cliente = prestamoJSFB.getClienteFacade().findById(clientePK);
        if(cliente != null){
            prestamoJSFB.setClienteConsulta(cliente);
            ctx.getExternalContext().getSessionMap().put(USUARIO_KEY_CONSULTA, cliente);
        }else{
            prestamoJSFB.setClienteConsulta(null);
            ctx.getExternalContext().getSessionMap().put(USUARIO_KEY_CONSULTA, null);
            presentarInfo(ctx, "Mensaje", "No se encontro ningun cliente");
        }
    }
    
    public String limipiar(){
        removeBeanSession(FacesContext.getCurrentInstance(), "prestamoJSFB");
        removeBeanSession(FacesContext.getCurrentInstance(), "consultarClienteAction");
        return "volver_prestamo";
    }

    public PrestamoJSFB getPrestamoJSFB() {
        return prestamoJSFB;
    }

    public void setPrestamoJSFB(PrestamoJSFB prestamoJSFB) {
        this.prestamoJSFB = prestamoJSFB;
    }

    public Short getIdTipoId() {
        return idTipoId;
    }

    public void setIdTipoId(Short idTipoId) {
        this.idTipoId = idTipoId;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    
}

