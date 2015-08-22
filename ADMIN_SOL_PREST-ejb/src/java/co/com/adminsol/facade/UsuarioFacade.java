/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.UsuarioApl;
import co.com.adminsol.modelo.DatosUsuario;
import co.com.adminsol.utilidades.CryptoUtilidad;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class UsuarioFacade extends GenericDAO<UsuarioApl> {

    public UsuarioFacade() {
        super(UsuarioApl.class);
    }

    public UsuarioApl loginUsuario(DatosUsuario datos, String idUsuario, String password) {
        Map map = new HashMap();
        map.put("idUSuario", idUsuario);
        map.put("clave", password);
        return findOneResult("UsuarioApl.loginUser", map);
    }

    public String restauraContrasena(UsuarioApl apl) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String valorEncriptado;
        CryptoUtilidad cru = new CryptoUtilidad();

        String diaActual = sdf.format(new Date());
        String diaUltimoIngreso = null;
        if (apl.getUltimoIngresoPr() != null) {
            diaUltimoIngreso = sdf.format(apl.getUltimoIngresoPr());
        }
        if (diaActual.equalsIgnoreCase(diaUltimoIngreso)) {
            if (Integer.parseInt(apl.getIntentos()) == 4) {
                return "MaxIntentos";
            }
        } else {
            apl = find(apl.getIdUsuario());
            apl.setIntentos("0");
            apl.setUltimoIngresoPr(new Date());
            save(apl);
        }

        Map map = new HashMap();
        map.put("respuesta1", apl.getRespuesta1());
        map.put("respuesta2", apl.getRespuesta2());
        map.put("respuesta3", apl.getRespuesta3());
        UsuarioApl usuario = findOneResult("UsuarioApl.validaPreguntas", map);
        if (usuario == null) {
            usuario = find(apl.getIdUsuario());
            usuario.setIntentos(String.valueOf(Integer.parseInt(usuario.getIntentos()) + 1));
            save(usuario);
            return "failRta";
        } else {
            usuario = find(apl.getIdUsuario());
            usuario.setIntentos("0");
            save(usuario);
        }
        valorEncriptado = "generate=" + sdfTime.format(new Date()) + "$" + usuario.getIdUsuario();
        return cru.encriptar(valorEncriptado);
    }

    public UsuarioApl buscarUSuario(String idDocumento) {
        UsuarioApl usuario = find(idDocumento);
        return usuario;
    }

    public void modificarUsuario(UsuarioApl ua) {
        update(ua);
    }
}
