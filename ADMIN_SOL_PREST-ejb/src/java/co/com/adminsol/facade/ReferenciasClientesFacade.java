/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.ReferenciasClientes;
import java.math.BigDecimal;
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
public class ReferenciasClientesFacade extends GenericDAO<ReferenciasClientes>{

    public ReferenciasClientesFacade() {
        super(ReferenciasClientes.class);
    }
    
    public ReferenciasClientes buscarPorId(BigDecimal idReferencia){
        return find(idReferencia);
    }
    
    public void crear(ReferenciasClientes referenciasClientes){
        save(referenciasClientes);
    }
    
    public void modificar(ReferenciasClientes referenciasClientes){
        update(referenciasClientes);
    }
    
    public void eliminar(ReferenciasClientes referenciasClientes){
        delete(referenciasClientes);
    }
    
    public List<ReferenciasClientes> getAllList(){
        return findAll();
    }
    
    public List<ReferenciasClientes> buscarPorCliente(Short tipoId, String identificacion){
        Map parameters = new HashMap();
        parameters.put("tpoId", tipoId);
        parameters.put("docId", identificacion);
        return executeQueryListResult("ReferenciasClientes.findByCliente", parameters);
    }
}
