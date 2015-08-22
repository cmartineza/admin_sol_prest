/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.banco.action;

import co.com.adminso.banco.jsfb.BancoJSFB;
import co.com.adminso.core.ApplicationJSFB;
import co.com.adminsol.entitys.Banco;
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
public class EliminarBancoAction extends ApplicationJSFB{

    @ManagedProperty("#{bancoJSFB}")
    private BancoJSFB bancoJSFB;
    private FacesContext ctx;
    private Banco bancoEliminar;
    private DatosUsuario datosUsuario;
    @PostConstruct
    public void init(){
        ctx = FacesContext.getCurrentInstance();
        datosUsuario = getUser(ctx);
    }
     
    public void eliminarBanco(Banco pBanco){
        try{
            bancoJSFB.getBancoFacade().eliminarBanco(datosUsuario,pBanco.getBancoId());
            presentarInfo(ctx, "Mensaje", "Se elimino correctamente el banco");
        }catch(Exception ex){
            presentarError(ctx, "Error", ex.getMessage());
        }      
        redirectPage(ctx, "secure/m_admin/banco_administracion.xhtml");
    }
      public BancoJSFB getBancoJSFB() {
        return bancoJSFB;
    }

    public void setBancoJSFB(BancoJSFB bancoJSFB) {
        this.bancoJSFB = bancoJSFB;
    }

    public Banco getBancoEliminar() {
        return bancoEliminar;
    }

    public void setBancoEliminar(Banco bancoEliminar) {
        this.bancoEliminar = bancoEliminar;
    }
    
    
}
