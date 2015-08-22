/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.Cliente;
import co.com.adminsol.entitys.ClientePK;
import static co.com.adminsol.entitys.Prestamo_.cliente;
import static java.nio.file.Files.delete;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author MARA
 */
    @Stateless
@LocalBean
public class ClienteFacade extends GenericDAO<Cliente>{

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public Cliente findById( ClientePK clientePK ){
        return find(clientePK);
    }

    public void crear(Cliente cliente){
        save(cliente);
    }
    
    public void modificar(Cliente cliente){
        update(cliente);
    }
    
    public void eliminar(Cliente cliente){
        delete(cliente);
    }
    
    public List<Cliente> getAllList(){
        return findAll();
    }
}
