/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.referencias.jsfb;

import co.com.adminsol.entitys.Parentesco;
import co.com.adminsol.entitys.ReferenciasClientes;
import co.com.adminsol.entitys.TipoReferencia;
import co.com.adminsol.facade.ParentescoFacade;
import co.com.adminsol.facade.ReferenciasClientesFacade;
import co.com.adminsol.facade.TipoReferenciaFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author MARA
 */
@ManagedBean(name = "referenciaJSFB")
@SessionScoped
public class ReferenciaJSFB {

    @EJB private ReferenciasClientesFacade facadeReferencias;
    @EJB private TipoReferenciaFacade facadeTipoReferencia;
    @EJB private ParentescoFacade facadeParentesco;
    private List<ReferenciasClientes> listReferencias;
    private List<TipoReferencia> listTipoReferencia;
    private List<Parentesco> listParentesco;
    private ReferenciasClientes refernciaTarget;
    private List<ReferenciasClientes> listFilterReferncias;
    
    @PostConstruct
    public void init(){
        listTipoReferencia = facadeTipoReferencia.getAllList();
        listParentesco = facadeParentesco.getAllList();
    }
    
    public ReferenciasClientesFacade getFacadeReferencias() {
        return facadeReferencias;
    }

    public void setFacadeReferencias(ReferenciasClientesFacade facadeReferencias) {
        this.facadeReferencias = facadeReferencias;
    }

    public List<ReferenciasClientes> getListReferencias() {
        return listReferencias;
    }

    public void setListReferencias(List<ReferenciasClientes> listReferencias) {
        this.listReferencias = listReferencias;
    }

    public List<TipoReferencia> getListTipoReferencia() {
        return listTipoReferencia;
    }

    public void setListTipoReferencia(List<TipoReferencia> listTipoReferencia) {
        this.listTipoReferencia = listTipoReferencia;
    }

    public List<Parentesco> getListParentesco() {
        return listParentesco;
    }

    public void setListParentesco(List<Parentesco> listParentesco) {
        this.listParentesco = listParentesco;
    }    

    public ReferenciasClientes getRefernciaTarget() {
        return refernciaTarget;
    }

    public void setRefernciaTarget(ReferenciasClientes refernciaTarget) {
        this.refernciaTarget = refernciaTarget;
    }

    public List<ReferenciasClientes> getListFilterReferncias() {
        return listFilterReferncias;
    }

    public void setListFilterReferncias(List<ReferenciasClientes> listFilterReferncias) {
        this.listFilterReferncias = listFilterReferncias;
    }
}
