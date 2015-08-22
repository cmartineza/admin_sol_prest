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
public class ListarBancoAction extends ApplicationJSFB{
   
    @ManagedProperty("#{bancoJSFB}")
    private BancoJSFB bancoJSFB;
    private List<Banco> listBanco;
     private DatosUsuario datosUsuario;
    @PostConstruct
    public void init(){        
        datosUsuario = getUser(FacesContext.getCurrentInstance());
        listBanco = bancoJSFB.getBancoFacade().getAllList(datosUsuario);
    }

    public List<Banco> getListBanco() {
        return listBanco;
    }

    public void setListBanco(List<Banco> listBanco) {
        this.listBanco = listBanco;
    }

    public BancoJSFB getBancoJSFB() {
        return bancoJSFB;
    }

    public void setBancoJSFB(BancoJSFB bancoJSFB) {
        this.bancoJSFB = bancoJSFB;
    }     
}
