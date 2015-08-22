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
public class ModificarBancoAction extends  ApplicationJSFB{
   
    @ManagedProperty("#{bancoJSFB}")
    private BancoJSFB bancoJSFB;
    private FacesContext ctx;
    private DatosUsuario datosUsuario;
    
    @PostConstruct
    public void init(){
        ctx = FacesContext.getCurrentInstance();
        datosUsuario = getUser(ctx);
    }
     
    public void modificarBanco(ActionEvent event){
        try{
            Banco lBanco = bancoJSFB.getBancoFacade().buscarId(datosUsuario,
                    bancoJSFB.getBancoTarget().getBancoId());
            lBanco.setNombreBanco(bancoJSFB.getBancoTarget().getNombreBanco());
            bancoJSFB.getBancoFacade().modificar(datosUsuario,lBanco);
            presentarInfo(ctx, "Mensaje", "Se modifico correctamente el banco");
        }catch(Exception ex){
            presentarError(ctx, "Error", ex.getMessage());
        }        
    }
    
      public BancoJSFB getBancoJSFB() {
        return bancoJSFB;
    }

    public void setBancoJSFB(BancoJSFB bancoJSFB) {
        this.bancoJSFB = bancoJSFB;
    }
}
