/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "PRESTAMO", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p"),
    @NamedQuery(name = "Prestamo.findByPrestamoId", query = "SELECT p FROM Prestamo p WHERE p.prestamoId = :prestamoId"),
    @NamedQuery(name = "Prestamo.findByBanco", query = "SELECT p FROM Prestamo p WHERE p.banco = :banco"),
    @NamedQuery(name = "Prestamo.findByValorSolicitado", query = "SELECT p FROM Prestamo p WHERE p.valorSolicitado = :valorSolicitado"),
    @NamedQuery(name = "Prestamo.findByCliente", query = "SELECT p FROM Prestamo p INNER JOIN p.cliente c  WHERE c.clientePK.numeroDocumento = :idCliente AND  c.clientePK.tipoIdentificacion = :tpoId"),
    @NamedQuery(name = "Prestamo.reporteTotal",query = "SELECT p FROM Prestamo p INNER JOIN p.cliente c WHERE p.fechaRadicacion BETWEEN :fechaIni AND :fechaFin AND p.estadoPrestamo.estadoId = :idEstado")
})
public class Prestamo implements Serializable {
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "FECHA_RADICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaRadicacion;
    @Size(max = 1)
    @Column(name = "PRO_PAGO")
    private String proPago;
    @Size(max = 1)
    @Column(name = "ALERTA")
    private String alerta;
    @Column(name = "VALOR_APROBADO")
    private BigInteger valorAprobado;
    @OneToMany(mappedBy = "prestamo",fetch = FetchType.EAGER)
    private List<ProyeccionPago> proyeccionPagoList;
    @JoinColumn(name = "ESTADO_PRESTAMO", referencedColumnName = "ESTADO_ID")
    @ManyToOne
    private EstadoPrestamo estadoPrestamo;
    

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRESTAMO_ID")
    @GeneratedValue(generator = "prestamoSEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "prestamoSEQ", sequenceName = "PRESTAMO_SEQ", allocationSize = 1, initialValue = 1)
    private BigDecimal prestamoId;
    @JoinColumn(name = "BANCO", referencedColumnName = "BANCO_ID")
    @ManyToOne
    private Banco banco;
    @Column(name = "VALOR_SOLICITADO")
    private BigInteger valorSolicitado;
    @JoinTable(name = "REFERENCIAS_PRESTAMOS", inverseJoinColumns = {
        @JoinColumn(name = "REFERENCIA", referencedColumnName = "REFERENCIA_ID")}, joinColumns = {
        @JoinColumn(name = "PRESTAMO", referencedColumnName = "PRESTAMO_ID")})
    @ManyToMany
    private List<ReferenciasClientes> referenciasClientesList;
    @JoinTable(name = "DOCUMENTOS_ENTREGADOS", inverseJoinColumns = {
        @JoinColumn(name = "DOCUMENTO_ID", referencedColumnName = "DOCUMENTO_ID")}, joinColumns = {
        @JoinColumn(name = "PRESTAMO", referencedColumnName = "PRESTAMO_ID")})
    @ManyToMany
    private List<DocumentoUsuario> documentoUsuarioList;
    @JoinColumns({
        @JoinColumn(name = "TIPO_IDENTIFICACION", referencedColumnName = "TIPO_IDENTIFICACION"),
        @JoinColumn(name = "NUMERO_DOCUMENTO", referencedColumnName = "NUMERO_DOCUMENTO")})
    @ManyToOne
    private Cliente cliente;

    public Prestamo() {
    }

    public Prestamo(BigDecimal prestamoId) {
        this.prestamoId = prestamoId;
    }

    public BigDecimal getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(BigDecimal prestamoId) {
        this.prestamoId = prestamoId;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public BigInteger getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(BigInteger valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    @XmlTransient
    public List<ReferenciasClientes> getReferenciasClientesList() {
        return referenciasClientesList;
    }

    public void setReferenciasClientesList(List<ReferenciasClientes> referenciasClientesList) {
        this.referenciasClientesList = referenciasClientesList;
    }

    @XmlTransient
    public List<DocumentoUsuario> getDocumentoUsuarioList() {
        return documentoUsuarioList;
    }

    public void setDocumentoUsuarioList(List<DocumentoUsuario> documentoUsuarioList) {
        this.documentoUsuarioList = documentoUsuarioList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prestamoId != null ? prestamoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.prestamoId == null && other.prestamoId != null) || (this.prestamoId != null && !this.prestamoId.equals(other.prestamoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.Prestamo[ prestamoId=" + prestamoId + " ]";
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaRadicacion() {
        return fechaRadicacion;
    }

    public void setFechaRadicacion(Date fechaRadicacion) {
        this.fechaRadicacion = fechaRadicacion;
    }

    public String getProPago() {
        return proPago;
    }

    public void setProPago(String proPago) {
        this.proPago = proPago;
    }

    public String getAlerta() {
        return alerta;
    }

    public void setAlerta(String alerta) {
        this.alerta = alerta;
    }

    public BigInteger getValorAprobado() {
        return valorAprobado;
    }

    public void setValorAprobado(BigInteger valorAprobado) {
        this.valorAprobado = valorAprobado;
    }
    
    @XmlTransient
    public List<ProyeccionPago> getProyeccionPagoList() {
        return proyeccionPagoList;
    }

    public void setProyeccionPagoList(List<ProyeccionPago> proyeccionPagoList) {
        this.proyeccionPagoList = proyeccionPagoList;
    }

    public EstadoPrestamo getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }
}
