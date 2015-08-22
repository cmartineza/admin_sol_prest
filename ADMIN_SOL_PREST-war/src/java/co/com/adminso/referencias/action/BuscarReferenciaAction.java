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
import co.com.adminsol.entitys.ReferenciasClientes;
import co.com.adminsol.modelo.DatosUsuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author MARA
 */
@ManagedBean
@RequestScoped
public class BuscarReferenciaAction extends ApplicationJSFB{
    
    @ManagedProperty("#{referenciaJSFB}") private ReferenciaJSFB referenciaJSFB;
    private FacesContext context;
    private DatosUsuario datosUsuario;
    private String identificacion;
    private Short  tpoIdentificaion;
    
    @PostConstruct
    public void init(){
        this.context =  FacesContext.getCurrentInstance();
        this.datosUsuario = getUser(context);
    }
    
    public void buscaReferencias(){
        Cliente cliente = (Cliente) context.getExternalContext()
                .getSessionMap().get(ConsultarClienteAction.USUARIO_KEY_CONSULTA);
        if(cliente == null){
            throw new RuntimeException("No se encontro el cliente a consultar");
        }
        this.tpoIdentificaion = cliente.getClientePK().getTipoIdentificacion();
        this.identificacion = cliente.getClientePK().getNumeroDocumento();
        List<ReferenciasClientes> listReferencias =
                referenciaJSFB.getFacadeReferencias().buscarPorCliente(tpoIdentificaion, identificacion);
        referenciaJSFB.setListReferencias(listReferencias);
        RequestContext.getCurrentInstance().update("formTableReferencia");
    }

    public ReferenciaJSFB getReferenciaJSFB() {
        return referenciaJSFB;
    }

    public void setReferenciaJSFB(ReferenciaJSFB referenciaJSFB) {
        this.referenciaJSFB = referenciaJSFB;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Short getTpoIdentificaion() {
        return tpoIdentificaion;
    }

    public void setTpoIdentificaion(Short tpoIdentificaion) {
        this.tpoIdentificaion = tpoIdentificaion;
    }
    
    
}
