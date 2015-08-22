/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MARA
 */
@Embeddable
public class ClientePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_IDENTIFICACION")
    private short tipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;

    public ClientePK() {
    }

    public ClientePK(short tipoIdentificacion, String numeroDocumento) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroDocumento = numeroDocumento;
    }

    public short getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(short tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tipoIdentificacion;
        hash += (numeroDocumento != null ? numeroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientePK)) {
            return false;
        }
        ClientePK other = (ClientePK) object;
        if (this.tipoIdentificacion != other.tipoIdentificacion) {
            return false;
        }
        if ((this.numeroDocumento == null && other.numeroDocumento != null) || (this.numeroDocumento != null && !this.numeroDocumento.equals(other.numeroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.ClientePK[ tipoIdentificacion=" + tipoIdentificacion + ", numeroDocumento=" + numeroDocumento + " ]";
    }
    
}
