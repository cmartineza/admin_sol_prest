/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "BANCO", catalog = "", schema = "ADM_ARCHIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b"),
    @NamedQuery(name = "Banco.findByBancoId", query = "SELECT b FROM Banco b WHERE b.bancoId = :bancoId"),
    @NamedQuery(name = "Banco.findByNombreBanco", query = "SELECT b FROM Banco b WHERE b.nombreBanco = :nombreBanco"),
    @NamedQuery(name = "Banco.findLikeNombre", query = "SELECT b FROM Banco b WHERE b.nombreBanco LIKE :nombreBanco")
})
public class Banco implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BANCO_ID")
    @SequenceGenerator(name = "BancoSeq", sequenceName = "BANCO_SEQ",initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BancoSeq")
    private Short bancoId;
    @Size(max = 100)
    @Column(name = "NOMBRE_BANCO")
    private String nombreBanco;
    @OneToMany(mappedBy = "banco",fetch = FetchType.EAGER)
    private List<Prestamo> prestamoList;
    
    public Banco() {
    }

    public Banco(Short bancoId) {
        this.bancoId = bancoId;
    }

    public Short getBancoId() {
        return bancoId;
    }

    public void setBancoId(Short bancoId) {
        this.bancoId = bancoId;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bancoId != null ? bancoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.bancoId == null && other.bancoId != null) || (this.bancoId != null && !this.bancoId.equals(other.bancoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.adminsol.entitys.Banco[ bancoId=" + bancoId + " ]";
    }

    @XmlTransient
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }
    
}
