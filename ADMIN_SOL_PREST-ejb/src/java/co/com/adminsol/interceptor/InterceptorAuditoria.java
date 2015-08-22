/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.interceptor;

import co.com.adminsol.modelo.DatosUsuario;
import co.com.adminsol.utilidades.Log;
import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.util.Date;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author MARA
 */
public class InterceptorAuditoria extends Log {

    @AroundInvoke
    public Object logAuditoria(InvocationContext context) {

        Object[] params = context.getParameters();
        DatosUsuario datosUsuario = (DatosUsuario) params[0];

        context.getMethod().getName();
        logger.info("Id Usuario : " + datosUsuario.getUsuario().getIdUsuario()
                + ". Ip Usuario : " + datosUsuario.getIp()
                + ". Clase : " + context.getClass().getName()
                + ". Metodo App : " + context.getMethod().getName()
                + ". Fecha : " + new Date());
        try {
            return context.proceed();
        } catch (Exception e) {
            logger.error("Error calling ctx.proceed in: " + e.getMessage());
            return null;
        }
    }
}
