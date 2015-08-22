/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "USUARIO_APL", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioApl.findAll", query = "SELECT u FROM UsuarioApl u"),
    @NamedQuery(name = "UsuarioApl.findByIdUsuario", query = "SELECT u FROM UsuarioApl u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuarioApl.findByNombreUsuario", query = "SELECT u FROM UsuarioApl u WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "UsuarioApl.findByActivo", query = "SELECT u FROM UsuarioApl u WHERE u.activo = :activo"),
    @NamedQuery(name = "UsuarioApl.findByUltimoIngreso", query = "SELECT u FROM UsuarioApl u WHERE u.ultimoIngreso = :ultimoIngreso"),
    @NamedQuery(name = "UsuarioApl.findByUltimoIngresoAux", query = "SELECT u FROM UsuarioApl u WHERE u.ultimoIngresoAux = :ultimoIngresoAux"),
    @NamedQuery(name = "UsuarioApl.loginUser", query = "SELECT u FROM UsuarioApl u WHERE u.idUsuario = :idUSuario and u.clave = :clave"),
    @NamedQuery(name = "UsuarioApl.validaPreguntas", query = "SELECT u FROM UsuarioApl u WHERE u.respuesta1 = :respuesta1 and u.respuesta2 = :respuesta2 and u.respuesta3 = :respuesta3")
})
public class UsuarioApl implements Serializable {
    @Size(max = 150)
    @Column(name = "PREGUNTA_1")
    private String pregunta1;
    @Size(max = 150)
    @Column(name = "RESPUESTA_1")
    private String respuesta1;
    @Size(max = 150)
    @Column(name = "PREGUNTA_2")
    private String pregunta2;
    @Size(max = 150)
    @Column(name = "RESPUESTA_2")
    private String respuesta2;
    @Size(max = 150)
    @Column(name = "PREGUNTA_3")
    private String pregunta3;
    @Size(max = 150)
    @Column(name = "RESPUESTA_3")
    private String respuesta3;
    @Size(max = 180)
    @Column(name = "CLAVE")
    private String clave;
    
    @Size(max = 3)
    @Column(name = "INTENTOS")
    private String intentos;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ID_USUARIO")
    private String idUsuario;
    @Size(max = 100)
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Size(max = 1)
    @Column(name = "ACTIVO")
    private String activo;
    @Column(name = "ULTIMO_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoIngreso;
    @Column(name = "ULTIMO_INGRESO_AUX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoIngresoAux;
    @Column(name = "ULTIMO_INTENTO_PR")
    @Temporal(TemporalType.DATE)
    private Date ultimoIngresoPr;
    
    public UsuarioApl() {
    }

    public UsuarioApl(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Date getUltimoIngreso() {
        return ultimoIngreso;
    }

    public void setUltimoIngreso(Date ultimoIngreso) {
        this.ultimoIngreso = ultimoIngreso;
    }

    public Date getUltimoIngresoAux() {
        return ultimoIngresoAux;
    }

    public void setUltimoIngresoAux(Date ultimoIngresoAux) {
        this.ultimoIngresoAux = ultimoIngresoAux;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioApl)) {
            return false;
        }
        UsuarioApl other = (UsuarioApl) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.UsuarioApl[ idUsuario=" + idUsuario + " ]";
    }

    public String getPregunta1() {
        return pregunta1;
    }

    public void setPregunta1(String pregunta1) {
        this.pregunta1 = pregunta1;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getPregunta2() {
        return pregunta2;
    }

    public void setPregunta2(String pregunta2) {
        this.pregunta2 = pregunta2;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getPregunta3() {
        return pregunta3;
    }

    public void setPregunta3(String pregunta3) {
        this.pregunta3 = pregunta3;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getIntentos() {
        return intentos;
    }

    public void setIntentos(String intentos) {
        this.intentos = intentos;
    }

    public Date getUltimoIngresoPr() {
        return ultimoIngresoPr;
    }

    public void setUltimoIngresoPr(Date ultimoIngresoPr) {
        this.ultimoIngresoPr = ultimoIngresoPr;
    }
}
