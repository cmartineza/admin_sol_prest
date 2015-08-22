/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "REFERENCIAS_CLIENTES", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReferenciasClientes.findAll", query = "SELECT r FROM ReferenciasClientes r"),
    @NamedQuery(name = "ReferenciasClientes.findByReferenciaId", query = "SELECT r FROM ReferenciasClientes r WHERE r.referenciaId = :referenciaId"),
    @NamedQuery(name = "ReferenciasClientes.findByNombres", query = "SELECT r FROM ReferenciasClientes r WHERE r.nombres = :nombres"),
    @NamedQuery(name = "ReferenciasClientes.findByApellidos", query = "SELECT r FROM ReferenciasClientes r WHERE r.apellidos = :apellidos"),
    @NamedQuery(name = "ReferenciasClientes.findByTelefonoContacto", query = "SELECT r FROM ReferenciasClientes r WHERE r.telefonoContacto = :telefonoContacto"),
    @NamedQuery(name = "ReferenciasClientes.findByDireccion", query = "SELECT r FROM ReferenciasClientes r WHERE r.direccion = :direccion"),
    @NamedQuery(name = "ReferenciasClientes.findByBarrio", query = "SELECT r FROM ReferenciasClientes r WHERE r.barrio = :barrio"),
    @NamedQuery(name = "ReferenciasClientes.findByCliente", query = "SELECT r FROM ReferenciasClientes r INNER JOIN r.cliente c  WHERE c.clientePK.numeroDocumento = :docId AND c.clientePK.tipoIdentificacion = :tpoId")
})
public class ReferenciasClientes implements Serializable {
  
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REFERENCIA_ID")
    @GeneratedValue(generator = "referenciaSEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "referenciaSEQ", sequenceName = "REFERENCIAS_CLIENTES_SEQ",allocationSize = 1, initialValue = 1)
    private BigDecimal referenciaId;
    @Size(max = 100)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 100)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 25)
    @Column(name = "TELEFONO_CONTACTO")
    private String telefonoContacto;
    @Size(max = 150)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 150)
    @Column(name = "BARRIO")
    private String barrio;
    @ManyToMany(mappedBy = "referenciasClientesList")
    private List<Prestamo> prestamoList;
    @JoinColumns({
        @JoinColumn(name = "TIPO_IDENTIFICACION_CL", referencedColumnName = "TIPO_IDENTIFICACION"),
        @JoinColumn(name = "NUMERO_DOCUMENTO_CL", referencedColumnName = "NUMERO_DOCUMENTO")})
    @ManyToOne
    private Cliente cliente;
    @JoinColumn(name = "PARENTESCO", referencedColumnName = "PARENTESCO_ID")
    @ManyToOne
    private Parentesco parentesco;
    @JoinColumn(name = "TIPO_REFERENCIA", referencedColumnName = "TIPO_REFERENCIA_ID")
    @ManyToOne
    private TipoReferencia tipoReferencia;

    public ReferenciasClientes() {
    }

    public ReferenciasClientes(BigDecimal referenciaId) {
        this.referenciaId = referenciaId;
    }

    public BigDecimal getReferenciaId() {
        return referenciaId;
    }

    public void setReferenciaId(BigDecimal referenciaId) {
        this.referenciaId = referenciaId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    @XmlTransient
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    public TipoReferencia getTipoReferencia() {
        return tipoReferencia;
    }

    public void setTipoReferencia(TipoReferencia tipoReferencia) {
        this.tipoReferencia = tipoReferencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referenciaId != null ? referenciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReferenciasClientes)) {
            return false;
        }
        ReferenciasClientes other = (ReferenciasClientes) object;
        if ((this.referenciaId == null && other.referenciaId != null) || (this.referenciaId != null && !this.referenciaId.equals(other.referenciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.ReferenciasClientes[ referenciaId=" + referenciaId + " ]";
    }
}
