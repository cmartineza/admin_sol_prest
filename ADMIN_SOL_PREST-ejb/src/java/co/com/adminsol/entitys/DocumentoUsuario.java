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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.jboss.logging.Param;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "DOCUMENTO_USUARIO", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoUsuario.findAll", query = "SELECT d FROM DocumentoUsuario d"),
    @NamedQuery(name = "DocumentoUsuario.findByDocumentoId", query = "SELECT d FROM DocumentoUsuario d WHERE d.documentoId = :documentoId"),
    @NamedQuery(name = "DocumentoUsuario.findByTipoIdentificacion", query = "SELECT d FROM DocumentoUsuario d WHERE d.tipoIdentificacion = :tipoIdentificacion"),
    @NamedQuery(name = "DocumentoUsuario.findByNumeroDocumento", query = "SELECT d FROM DocumentoUsuario d WHERE d.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "DocumentoUsuario.findByCarpeta", query = "SELECT d FROM DocumentoUsuario d WHERE d.carpeta = :carpeta"),
    @NamedQuery(name = "DocumentoUsuario.findByNombreDocumento", query = "SELECT d FROM DocumentoUsuario d WHERE d.nombreDocumento = :nombreDocumento"),
    @NamedQuery(name = "DocumentoUsuario.findByCliente", query = "SELECT d FROM DocumentoUsuario d WHERE d.numeroDocumento = :numeroDocumento AND d.tipoIdentificacion = :idTpoDoc")
})
public class DocumentoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENTO_ID")
    @GeneratedValue(generator = "documentoUSEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "documentoUSEQ", sequenceName = "DOCUMENTO_USUARIO_SEQ", initialValue = 1,allocationSize = 1)
    private BigDecimal documentoId;
    @Size(max = 3)
    @Column(name = "TIPO_IDENTIFICACION")
    private String tipoIdentificacion;
    @Size(max = 18)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Size(max = 120)
    @Column(name = "CARPETA")
    private String carpeta;
    @Size(max = 100)
    @Column(name = "NOMBRE_DOCUMENTO")
    private String nombreDocumento;
    @ManyToMany(mappedBy = "documentoUsuarioList")
    private List<Prestamo> prestamoList;
    @JoinColumn(name = "TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO_ID")
    @ManyToOne
    private TipoDocumento tipoDocumento;
    @Column(name = "FECHA_CREACION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "PROYECCION")
    private BigInteger proyeccion;
    
    public DocumentoUsuario() {
    }

    public DocumentoUsuario(BigDecimal documentoId) {
        this.documentoId = documentoId;
    }

    public BigDecimal getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(BigDecimal documentoId) {
        this.documentoId = documentoId;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    @XmlTransient
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }

    public BigInteger getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(BigInteger proyeccion) {
        this.proyeccion = proyeccion;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoId != null ? documentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoUsuario)) {
            return false;
        }
        DocumentoUsuario other = (DocumentoUsuario) object;
        if ((this.documentoId == null && other.documentoId != null) || (this.documentoId != null && !this.documentoId.equals(other.documentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.DocumentoUsuario[ documentoId=" + documentoId + " ]";
    }
    
}
