/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminso.prestamo.action;

import co.com.adminso.core.ApplicationJSFB;
import co.com.adminso.prestamo.jsfb.PrestamoJSFB;
import co.com.adminsol.entitys.Banco;
import co.com.adminsol.entitys.Cliente;
import co.com.adminsol.entitys.DocumentoUsuario;
import co.com.adminsol.entitys.Prestamo;
import co.com.adminsol.entitys.ReferenciasClientes;
import co.com.adminsol.facade.DocumentoUsuarioFacade;
import co.com.adminsol.facade.ReferenciasClientesFacade;
import co.com.adminsol.modelo.DatosUsuario;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author MARA
 */
@ManagedBean
@SessionScoped
public class CrearPrestamoAction extends ApplicationJSFB {

    @EJB
    private DocumentoUsuarioFacade documentoUsuarioFacade;
    @EJB
    private ReferenciasClientesFacade referenciasClientesFacade;
    @ManagedProperty("#{prestamoJSFB}")
    private PrestamoJSFB prestamoJSFB;
    private FacesContext ctx;
    private DatosUsuario datosUsuario;
    private List<DocumentoUsuario> listDocUsuario;
    private List<ReferenciasClientes> listClientes;
    private List<ReferenciasClientes> listaReferenciaCliente;
    private List<DocumentoUsuario> listDocumentoCliente;
    private Short idBanco;
    private BigInteger valorSolicitado;
    private DualListModel documentosUsuario;
    private DualListModel referenciasClientes;
    private Cliente cliente;
    private String bndProyeccionPago;
    private String bndAlerta;
    
    @PostConstruct
    public void init() {
        ctx = FacesContext.getCurrentInstance();
         idBanco = null;
            valorSolicitado = null;
        cliente = (Cliente) ctx.getExternalContext().getSessionMap().get(ConsultarClienteAction.USUARIO_KEY_CONSULTA);
        //lista actual de documentos del cliente
        listDocUsuario = documentoUsuarioFacade.listDocumentosCliente(cliente);
        //Lista para crear documentos usuarios
        listDocumentoCliente = new ArrayList<>();
        //lista actual de referencias del cliente
        listClientes = referenciasClientesFacade.buscarPorCliente(cliente.getClientePK().getTipoIdentificacion(), cliente.getClientePK().getNumeroDocumento());
        //Lista para crear referencia.
        listaReferenciaCliente = new ArrayList<>();
        //dual model referencias cliente
        referenciasClientes = new DualListModel<>(listClientes, listaReferenciaCliente);
        //dual model documentos cliente
        documentosUsuario = new DualListModel<>(listDocUsuario, listDocumentoCliente);
    }

    public void crearPrestamo(ActionEvent actionEvent) {
        try {
            Prestamo prestamoL = new Prestamo();
            for (int i = 0; i < documentosUsuario.getTarget().size(); i++) {
                listDocumentoCliente.add(new DocumentoUsuario(
                        new BigDecimal(documentosUsuario.getTarget().get(i).toString())));
            }

            for (int i = 0; i < referenciasClientes.getTarget().size(); i++) {
                listaReferenciaCliente.add(new ReferenciasClientes(
                        new BigDecimal(referenciasClientes.getTarget().get(i).toString())));
            }

            prestamoL.setDocumentoUsuarioList(listDocumentoCliente);
            prestamoL.setReferenciasClientesList(listaReferenciaCliente);
            prestamoL.setBanco(new Banco(idBanco));
            prestamoL.setValorSolicitado(valorSolicitado);
            prestamoL.setCliente(cliente);
            prestamoL.setAlerta(bndAlerta);
            prestamoL.setProPago(bndProyeccionPago);
            prestamoJSFB.getPrestamoFacade().crear(prestamoL);
        
           
            this.init();            
            presentarInfo(ctx, "Mensaje", "Se creo correctamente el prestamo");
        } catch (Exception ex) {
            logger.fatal("Crear prestamo", ex);
            presentarError(ctx, "Error", ex.getMessage());
        }
    }

    public PrestamoJSFB getPrestamoJSFB() {
        return prestamoJSFB;
    }

    public void setPrestamoJSFB(PrestamoJSFB prestamoJSFB) {
        this.prestamoJSFB = prestamoJSFB;
    }

    public List<DocumentoUsuario> getListDocUsuario() {
        return listDocUsuario;
    }

    public void setListDocUsuario(List<DocumentoUsuario> listDocUsuario) {
        this.listDocUsuario = listDocUsuario;
    }

    public List<ReferenciasClientes> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<ReferenciasClientes> listClientes) {
        this.listClientes = listClientes;
    }

    public List<ReferenciasClientes> getListaReferenciaCliente() {
        return listaReferenciaCliente;
    }

    public void setListaReferenciaCliente(List<ReferenciasClientes> listaReferenciaCliente) {
        this.listaReferenciaCliente = listaReferenciaCliente;
    }

    public List<DocumentoUsuario> getListDocumentoCliente() {
        return listDocumentoCliente;
    }

    public void setListDocumentoCliente(List<DocumentoUsuario> listDocumentoCliente) {
        this.listDocumentoCliente = listDocumentoCliente;
    }

    public Short getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Short idBanco) {
        this.idBanco = idBanco;
    }

    public BigInteger getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(BigInteger valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public DualListModel<DocumentoUsuario> getDocumentosUsuario() {
        return documentosUsuario;
    }

    public void setDocumentosUsuario(DualListModel<DocumentoUsuario> documentosUsuario) {
        this.documentosUsuario = documentosUsuario;
    }

    public DualListModel<ReferenciasClientes> getReferenciasClientes() {
        return referenciasClientes;
    }

    public void setReferenciasClientes(DualListModel<ReferenciasClientes> referenciasClientes) {
        this.referenciasClientes = referenciasClientes;
    }

    public String getBndProyeccionPago() {
        return bndProyeccionPago;
    }

    public void setBndProyeccionPago(String bndProyeccionPago) {
        this.bndProyeccionPago = bndProyeccionPago;
    }

    public String getBndAlerta() {
        return bndAlerta;
    }

    public void setBndAlerta(String bndAlerta) {
        this.bndAlerta = bndAlerta;
    }    
}

