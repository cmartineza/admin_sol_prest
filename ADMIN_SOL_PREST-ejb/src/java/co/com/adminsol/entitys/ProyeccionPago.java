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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "PROYECCION_PAGO", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyeccionPago.findAll", query = "SELECT p FROM ProyeccionPago p"),
    @NamedQuery(name = "ProyeccionPago.findByProyeccionId", query = "SELECT p FROM ProyeccionPago p WHERE p.proyeccionId = :proyeccionId"),
    @NamedQuery(name = "ProyeccionPago.findByFechaPago", query = "SELECT p FROM ProyeccionPago p WHERE p.fechaPago = :fechaPago"),
    @NamedQuery(name = "ProyeccionPago.findByNoCuenta", query = "SELECT p FROM ProyeccionPago p WHERE p.noCuenta = :noCuenta"),
    @NamedQuery(name = "ProyeccionPago.findByPagoMinimo", query = "SELECT p FROM ProyeccionPago p WHERE p.pagoMinimo = :pagoMinimo"),
    @NamedQuery(name = "ProyeccionPago.findByCalculo", query = "SELECT p FROM ProyeccionPago p WHERE p.calculo = :calculo")})
public class ProyeccionPago implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROYECCION_ID")
    @SequenceGenerator(name = "proyeccionSeq", sequenceName = "PROYECCION_PAGO_SEQ", initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "proyeccionSeq", strategy = GenerationType.SEQUENCE)
    private BigDecimal proyeccionId;
    @Column(name = "FECHA_PAGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Size(max = 30)
    @Column(name = "NO_CUENTA")
    private String noCuenta;
    @Column(name = "PAGO_MINIMO")
    private BigInteger pagoMinimo;
    @Column(name = "CALCULO")
    private Short calculo;
    @JoinColumn(name = "PRESTAMO", referencedColumnName = "PRESTAMO_ID")
    @ManyToOne
    private Prestamo prestamo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyeccion")
    private List<Alerta> alertaList;
    
    public ProyeccionPago() {
    }

    public ProyeccionPago(BigDecimal proyeccionId) {
        this.proyeccionId = proyeccionId;
    }

    public BigDecimal getProyeccionId() {
        return proyeccionId;
    }

    public void setProyeccionId(BigDecimal proyeccionId) {
        this.proyeccionId = proyeccionId;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public BigInteger getPagoMinimo() {
        return pagoMinimo;
    }

    public void setPagoMinimo(BigInteger pagoMinimo) {
        this.pagoMinimo = pagoMinimo;
    }

    public Short getCalculo() {
        return calculo;
    }

    public void setCalculo(Short calculo) {
        this.calculo = calculo;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
    
    @XmlTransient
    public List<Alerta> getAlertaList() {
        return alertaList;
    }

    public void setAlertaList(List<Alerta> alertaList) {
        this.alertaList = alertaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyeccionId != null ? proyeccionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyeccionPago)) {
            return false;
        }
        ProyeccionPago other = (ProyeccionPago) object;
        if ((this.proyeccionId == null && other.proyeccionId != null) || (this.proyeccionId != null && !this.proyeccionId.equals(other.proyeccionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.ProyeccionPago[ proyeccionId=" + proyeccionId + " ]";
    }
    
}
