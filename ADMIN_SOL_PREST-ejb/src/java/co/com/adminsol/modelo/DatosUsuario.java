/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.modelo;

import co.com.adminsol.entitys.UsuarioApl;

/**
 *
 * @author MARA
 */
public class DatosUsuario {
     private UsuarioApl usuario;
    private String ip;

    public UsuarioApl getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioApl usuario) {
        this.usuario = usuario;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
