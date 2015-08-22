/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.referencias.action;

import co.com.adminso.core.ApplicationJSFB;
import co.com.adminso.referencias.jsfb.ReferenciaJSFB;
import co.com.adminsol.entitys.ReferenciasClientes;
import co.com.adminsol.modelo.DatosUsuario;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIViewParameter;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author MARA
 */
@ManagedBean
@RequestScoped
public class EliminarRefernciaAction extends ApplicationJSFB {

    @ManagedProperty("#{referenciaJSFB}")
    ReferenciaJSFB referenciaJSFB;
    private FacesContext context;
    private DatosUsuario datosUsuario;
    
    @PostConstruct
    public void init(){
        context = FacesContext.getCurrentInstance();
        datosUsuario = getUser(context);
    }

    public void eliminar(ReferenciasClientes referenciasClientes){
        try{
            referenciaJSFB.getFacadeReferencias().eliminar(referenciasClientes);
            presentarInfo(context, "Mensaje", "Se elimino correctamente la referencia.");       
        }catch( Exception ex){
            presentarError(context, "Error", ex.getMessage());
        }
    }

    public ReferenciaJSFB getReferenciaJSFB() {
        return referenciaJSFB;
    }

    public void setReferenciaJSFB(ReferenciaJSFB referenciaJSFB) {
        this.referenciaJSFB = referenciaJSFB;
    }
    
    
}
