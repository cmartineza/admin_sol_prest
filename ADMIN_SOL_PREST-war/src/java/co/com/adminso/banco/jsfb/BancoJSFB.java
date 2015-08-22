/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.banco.jsfb;

import co.com.adminsol.entitys.Banco;
import co.com.adminsol.facade.BancoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author MARA
 */
@ManagedBean(name = "bancoJSFB")
@SessionScoped
public class BancoJSFB {

    @EJB
    private BancoFacade bancoFacade;
    private List<Banco> listFiltro;
    private Banco bancoTarget;

    public BancoFacade getBancoFacade() {
        return bancoFacade;
    }

    public List<Banco> getListFiltro() {
        return listFiltro;
    }

    public void setListFiltro(List<Banco> listFiltro) {
        this.listFiltro = listFiltro;
    }

    public Banco getBancoTarget() {
        return bancoTarget;
    }

    public void setBancoTarget(Banco bancoTarget) {
        this.bancoTarget = bancoTarget;
    }    
}
