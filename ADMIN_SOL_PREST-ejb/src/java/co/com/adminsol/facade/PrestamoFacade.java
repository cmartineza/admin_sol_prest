/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.Cliente;
import co.com.adminsol.entitys.EstadoPrestamo;
import co.com.adminsol.entitys.Prestamo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
@Stateless
@LocalBean
public class PrestamoFacade extends GenericDAO<Prestamo>{

    public PrestamoFacade() {
        super(Prestamo.class);
    }

    public void crear(Prestamo prestamo){
        prestamo.setFechaCreacion(new Date());
        prestamo.setEstadoPrestamo(new EstadoPrestamo(Short.parseShort("1")));
        save(prestamo);
    }
    
    public Prestamo buscarPrestamo(BigDecimal idPrestamo){
        return find(idPrestamo);
    }
    
    public void modificar(Prestamo prestamo){
        update(prestamo);
    }
    
    public void eliminar(Prestamo prestamo){
        delete(prestamo);
    }
    
    public List<Prestamo> getAllList(){
        return findAll();
    }
    
    public List<Prestamo> getListCliente( Cliente cliente ){
        Map map = new HashMap();
        map.put("tpoId", cliente.getClientePK().getTipoIdentificacion());
        map.put("idCliente", cliente.getClientePK().getNumeroDocumento());
        return executeQueryListResult("Prestamo.findByCliente", map);
    }
    
    public List<Prestamo> listReporteTotal(Date fechaInicial, Date fechaFinal){
        Map map = new HashMap();
        map.put("fechaIni", fechaInicial);
        map.put("fechaFin", fechaFinal);
        map.put("idEstado", Short.parseShort("2"));
        return executeQueryListResult("Prestamo.reporteTotal", map);
    }
}
