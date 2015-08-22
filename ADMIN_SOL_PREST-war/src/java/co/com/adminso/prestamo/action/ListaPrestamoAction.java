/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.prestamo.action;

import co.com.adminso.core.ApplicationJSFB;
import co.com.adminso.prestamo.jsfb.PrestamoJSFB;
import co.com.adminsol.entitys.Cliente;
import co.com.adminsol.entitys.Prestamo;
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
@ManagedBean(name = "listarPrestamoAction")
@RequestScoped
public class ListaPrestamoAction extends ApplicationJSFB {

    @ManagedProperty("#{prestamoJSFB}")
    private PrestamoJSFB prestamoJSFB;
    private List<Prestamo> listPrestamo;
    private FacesContext ctx;
    private DatosUsuario datosUsuario;

    @PostConstruct
    public void init() {
        ctx = FacesContext.getCurrentInstance();
        datosUsuario = getUser(ctx);
        Cliente cliente = (Cliente) ctx.getExternalContext().getSessionMap()
                .get(ConsultarClienteAction.USUARIO_KEY_CONSULTA);
        listPrestamo = prestamoJSFB.getPrestamoFacade().getListCliente(cliente);
    }

    public PrestamoJSFB getPrestamoJSFB() {
        return prestamoJSFB;
    }

    public void setPrestamoJSFB(PrestamoJSFB prestamoJSFB) {
        this.prestamoJSFB = prestamoJSFB;
    }

    public List<Prestamo> getListPrestamo() {
        return listPrestamo;
    }

    public void setListPrestamo(List<Prestamo> listPrestamo) {
        this.listPrestamo = listPrestamo;
    }  
}
