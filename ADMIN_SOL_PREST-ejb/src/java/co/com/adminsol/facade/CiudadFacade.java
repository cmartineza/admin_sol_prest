/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.adminsol.facade;

import co.com.adminsol.dao.GenericDAO;
import co.com.adminsol.entitys.Ciudad;
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
public class CiudadFacade extends GenericDAO<Ciudad> {

    public CiudadFacade() {
        super(Ciudad.class);
    }

    public void crear(Ciudad ciudad) {
        save(ciudad);
    }

    public void modificar(Ciudad ciudad) {
        update(ciudad);
    }

    public void eliminar(Ciudad ciudad) {
        delete(ciudad);
    }

    public List<Ciudad> getAllList() {
        return findAll();
    }
}
