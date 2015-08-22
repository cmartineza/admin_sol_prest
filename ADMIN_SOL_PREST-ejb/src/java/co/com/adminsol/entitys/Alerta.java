/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "ALERTA", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alerta.findAll", query = "SELECT a FROM Alerta a"),
    @NamedQuery(name = "Alerta.findByIdAlerta", query = "SELECT a FROM Alerta a WHERE a.idAlerta = :idAlerta"),
    @NamedQuery(name = "Alerta.findByActiva", query = "SELECT a FROM Alerta a WHERE a.activa = :activa"),
    @NamedQuery(name = "Alerta.findByFechaCreacion", query = "SELECT a FROM Alerta a WHERE a.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Alerta.findByFechaInactivacion", query = "SELECT a FROM Alerta a WHERE a.fechaInactivacion = :fechaInactivacion"),
    @NamedQuery(name = "Alerta.findByDuracion", query = "SELECT a FROM Alerta a WHERE a.duracion = :duracion"),
    @NamedQuery(name = "Alerta.findByAlertaActivas", query = "SELECT a FROM Alerta a WHERE a.fechaCreacion >= :fechaC AND a.activa = :activa"),
    @NamedQuery(name = "Alerta.updateAlertaActiva", query = "UPDATE Alerta a SET a.activa = 'S' WHERE a.fechaCreacion >= :fechaIni AND a.fechaCreacion <= :fechaFin AND a.activa = 'P'")
})
public class Alerta implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ALERTA")
    @SequenceGenerator(name = "alertaSeq", sequenceName = "ALERTA_SEQ", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alertaSeq")
    private BigDecimal idAlerta;
    @Size(max = 1)
    @Column(name = "ACTIVA")
    private String activa;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "FECHA_INACTIVACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInactivacion;
    @Column(name = "DURACION")
    private Short duracion;
    @JoinColumn(name = "PROYECCION", referencedColumnName = "PROYECCION_ID")
    @ManyToOne(optional = false)
    private ProyeccionPago proyeccion;

    public Alerta() {
    }

    public Alerta(BigDecimal idAlerta) {
        this.idAlerta = idAlerta;
    }

    public BigDecimal getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(BigDecimal idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getActiva() {
        return activa;
    }

    public void setActiva(String activa) {
        this.activa = activa;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaInactivacion() {
        return fechaInactivacion;
    }

    public void setFechaInactivacion(Date fechaInactivacion) {
        this.fechaInactivacion = fechaInactivacion;
    }

    public Short getDuracion() {
        return duracion;
    }

    public void setDuracion(Short duracion) {
        this.duracion = duracion;
    }

    public ProyeccionPago getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(ProyeccionPago proyeccion) {
        this.proyeccion = proyeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlerta != null ? idAlerta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alerta)) {
            return false;
        }
        Alerta other = (Alerta) object;
        if ((this.idAlerta == null && other.idAlerta != null) || (this.idAlerta != null && !this.idAlerta.equals(other.idAlerta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.Alerta[ idAlerta=" + idAlerta + " ]";
    }
    
}
