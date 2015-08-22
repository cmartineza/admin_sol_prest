/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MARA
 */
@Entity
@Table(name = "CLIENTE", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByTipoIdentificacion", query = "SELECT c FROM Cliente c WHERE c.clientePK.tipoIdentificacion = :tipoIdentificacion"),
    @NamedQuery(name = "Cliente.findByNumeroDocumento", query = "SELECT c FROM Cliente c WHERE c.clientePK.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Cliente.findByNombres", query = "SELECT c FROM Cliente c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Cliente.findByApellidos", query = "SELECT c FROM Cliente c WHERE c.apellidos = :apellidos"),
    @NamedQuery(name = "Cliente.findByFechaNacimiento", query = "SELECT c FROM Cliente c WHERE c.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Cliente.findByFechaExpedicionDoc", query = "SELECT c FROM Cliente c WHERE c.fechaExpedicionDoc = :fechaExpedicionDoc"),
    @NamedQuery(name = "Cliente.findByEmpresa", query = "SELECT c FROM Cliente c WHERE c.empresa = :empresa"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cliente.findByCelular", query = "SELECT c FROM Cliente c WHERE c.celular = :celular"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
    @NamedQuery(name = "Cliente.findByDireccionResidencia", query = "SELECT c FROM Cliente c WHERE c.direccionResidencia = :direccionResidencia")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientePK clientePK;
    @Size(max = 100)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 100)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(name = "FECHA_EXPEDICION_DOC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExpedicionDoc;
    @Size(max = 200)
    @Column(name = "EMPRESA")
    private String empresa;
    @Column(name = "TELEFONO")
    private Long telefono;
    @Column(name = "CELULAR")
    private Long celular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 150)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 150)
    @Column(name = "DIRECCION_RESIDENCIA")
    private String direccionResidencia;
    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER)
    private List<Prestamo> prestamoList;
    @JoinColumn(name = "CIUDAD_RESIDENCIA", referencedColumnName = "CIUDAD_ID")
    @ManyToOne
    private Ciudad ciudadResidencia;
    @JoinColumn(name = "EPS", referencedColumnName = "EPS_ID")
    @ManyToOne
    private Eps eps;
    @JoinColumn(name = "ESTADO_CIVIL", referencedColumnName = "ESTADO_CIVIL_ID")
    @ManyToOne
    private EstadoCivil estadoCivil;
    @JoinColumn(name = "TENENCIA_VIVIENDA", referencedColumnName = "TENENCIA_VIVIENDA_ID")
    @ManyToOne
    private TenenciaVivienda tenenciaVivienda;
    @JoinColumn(name = "TIPO_IDENTIFICACION", referencedColumnName = "TIPO_DOCUMENTO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoIdentificacion tipoIdentificacion1;
    @JoinColumn(name = "TIPO_VIVIENDA", referencedColumnName = "TIPO_VIVIENDA_ID")
    @ManyToOne
    private TipoVivienda tipoVivienda;
    @OneToMany(mappedBy = "cliente")
    private List<ReferenciasClientes> referenciasClientesList;

    public Cliente() {
    }

    public Cliente(ClientePK clientePK) {
        this.clientePK = clientePK;
    }

    public Cliente(short tipoIdentificacion, String numeroDocumento) {
        this.clientePK = new ClientePK(tipoIdentificacion, numeroDocumento);
    }

    public ClientePK getClientePK() {
        return clientePK;
    }

    public void setClientePK(ClientePK clientePK) {
        this.clientePK = clientePK;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaExpedicionDoc() {
        return fechaExpedicionDoc;
    }

    public void setFechaExpedicionDoc(Date fechaExpedicionDoc) {
        this.fechaExpedicionDoc = fechaExpedicionDoc;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    @XmlTransient
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }

    public Ciudad getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(Ciudad ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public Eps getEps() {
        return eps;
    }

    public void setEps(Eps eps) {
        this.eps = eps;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public TenenciaVivienda getTenenciaVivienda() {
        return tenenciaVivienda;
    }

    public void setTenenciaVivienda(TenenciaVivienda tenenciaVivienda) {
        this.tenenciaVivienda = tenenciaVivienda;
    }

    public TipoIdentificacion getTipoIdentificacion1() {
        return tipoIdentificacion1;
    }

    public void setTipoIdentificacion1(TipoIdentificacion tipoIdentificacion1) {
        this.tipoIdentificacion1 = tipoIdentificacion1;
    }

    public TipoVivienda getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(TipoVivienda tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    @XmlTransient
    public List<ReferenciasClientes> getReferenciasClientesList() {
        return referenciasClientesList;
    }

    public void setReferenciasClientesList(List<ReferenciasClientes> referenciasClientesList) {
        this.referenciasClientesList = referenciasClientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientePK != null ? clientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clientePK == null && other.clientePK != null) || (this.clientePK != null && !this.clientePK.equals(other.clientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.Cliente[ clientePK=" + clientePK + " ]";
    }
    
}
