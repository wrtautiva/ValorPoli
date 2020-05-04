package com.valorcompartido.springboot.app.services.impl;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.core.exceptions.enums.LogRefServices;
import com.valorcompartido.springboot.app.core.exceptions.persistence.DataNotFoundPersistenceException;
import com.valorcompartido.springboot.app.daos.ModuloDAO;
import com.valorcompartido.springboot.app.model.entity.ModuloEntity;
import com.valorcompartido.springboot.app.services.ModuloService;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.Optional;

@Service
public class IModuloService implements ModuloService {

    private final ModuloDAO moduloDAO;

    public IModuloService(ModuloDAO moduloDAO) {
        this.moduloDAO = moduloDAO;
    }

    @Override
    public ModuloEntity findModuloEntityById(Integer id) throws ServiceException {
        try {
            return Optional.ofNullable(moduloDAO.findModuloEntityBy(id))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd por id"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el id" + id, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }


}
