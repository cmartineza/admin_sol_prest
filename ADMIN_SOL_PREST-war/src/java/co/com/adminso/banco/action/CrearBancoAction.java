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
public class CrearBancoAction extends ApplicationJSFB{

    @ManagedProperty("#{bancoJSFB}")
    private BancoJSFB bancoJSFB;
    private String nombreBanco;
    private FacesContext ctx;
    private DatosUsuario datosUsuario;
    @PostConstruct
    public void init(){
        ctx = FacesContext.getCurrentInstance();
        datosUsuario = getUser(ctx);
    }
     
    public void crearBanco(ActionEvent event){
        try{
            Banco banco = new Banco();
            banco.setNombreBanco(nombreBanco);
            bancoJSFB.getBancoFacade().crearBanco(datosUsuario,banco);
            presentarInfo(ctx, "Mensaje", "Se creo correctamente el banco");
            nombreBanco = "";
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

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
}
