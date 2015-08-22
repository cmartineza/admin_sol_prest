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
import java.math.BigDecimal;
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
public class ModificarReferenciaAction extends ApplicationJSFB {

    @ManagedProperty("#{referenciaJSFB}")
    private ReferenciaJSFB referenciaJSFB;
    private FacesContext context;
    private DatosUsuario datos;

    @PostConstruct
    public void init() {
        context = FacesContext.getCurrentInstance();
    }

    public void modificarReferencia(ActionEvent actionEvent) {
        try {

            ReferenciasClientes refCliente = referenciaJSFB.getFacadeReferencias()
                    .buscarPorId(referenciaJSFB.getRefernciaTarget().getReferenciaId());
            ReferenciasClientes refModificada = referenciaJSFB.getRefernciaTarget();
            refCliente.setNombres(refModificada.getNombres());
            refCliente.setApellidos(refModificada.getApellidos());
            refCliente.setTelefonoContacto(refModificada.getTelefonoContacto());
            refCliente.setDireccion(refModificada.getDireccion());
            refCliente.setBarrio(refModificada.getBarrio());
            refCliente.setTipoReferencia(refModificada.getTipoReferencia());
            refCliente.setParentesco(refModificada.getParentesco());

            referenciaJSFB.getFacadeReferencias().modificar(refCliente);
            presentarInfo(context, "Mensaje", "Se modifico correctamente la referencia");
        } catch (Exception ex) {
            presentarError(context, "Erro", ex.getMessage());
        }

    }

    public ReferenciaJSFB getReferenciaJSFB() {
        return referenciaJSFB;
    }

    public void setReferenciaJSFB(ReferenciaJSFB referenciaJSFB) {
        this.referenciaJSFB = referenciaJSFB;
    }
    
    
}
