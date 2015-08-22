/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.Alerta;
import co.com.adminsol.entitys.ProyeccionPago;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class AlertaFacade extends GenericDAO<Alerta>{

    public AlertaFacade() {
        super(Alerta.class);
    }
    
    public Alerta findById(BigDecimal idAlerta){
        return find(idAlerta);
    }
    
    public void crearAlerta(ProyeccionPago proyeccionPago){
        Date fechaPago = proyeccionPago.getFechaPago();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaPago);
        for(int i = 0; i < 6; i ++){
            Alerta alerta = new Alerta();
            alerta.setProyeccion(proyeccionPago);
            alerta.setActiva("P");
            alerta.setFechaCreacion(calendar.getTime());
            save(alerta);
            calendar.add(Calendar.MONTH, 1);
        }
    }
    
    public void modificarAlerta(Alerta alerta){
        this.update(alerta);
    }
    
    public List<Alerta> listarAlerta(){
        return this.findAll();
    }
    
    public List<Alerta> listAlertaFindEstado(String estadoAlerta){
        Map parameters = new HashMap();
        parameters.put("activa", estadoAlerta);
        return executeQueryListResult("Alerta.findByActiva", parameters);
    }
    
    public void updateAlertasActivas(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -4);
        Map parameters = new HashMap();
        parameters.put("fechaIni", calendar.getTime());
        parameters.put("fechaFin", new Date());
        executeQueryUpdate("Alerta.updateAlertaActiva", parameters);
    }
    
    public List<Alerta> listAlertasActivas(){
        updateAlertasActivas();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -4);
        Map parameters = new HashMap();
        parameters.put("fechaC", calendar.getTime());
        parameters.put("activa", "S");
        return executeQueryListResult("Alerta.findByAlertaActivas", parameters);
    }
    
}
