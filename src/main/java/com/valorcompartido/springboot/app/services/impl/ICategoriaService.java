package com.valorcompartido.springboot.app.services.impl;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.core.exceptions.enums.LogRefServices;
import com.valorcompartido.springboot.app.core.exceptions.persistence.DataNotFoundPersistenceException;
import com.valorcompartido.springboot.app.core.util.Util;
import com.valorcompartido.springboot.app.daos.CategoriaDAO;
import com.valorcompartido.springboot.app.model.dto.CategoriaDTO;
import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.model.entity.CategoriaEntity;
import com.valorcompartido.springboot.app.services.CategoriaService;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ICategoriaService implements CategoriaService {

    private final CategoriaDAO categoriaDAO;
    private final Util util;

    public ICategoriaService(CategoriaDAO categoriaDAO, Util util) {
        this.categoriaDAO = categoriaDAO;
        this.util = util;
    }

    @Override
    public List<CategoriaEntity> listaCategoria() throws ServiceException {
            try{
                return Optional.of(categoriaDAO.findAll())
                        .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
            } catch (IllegalArgumentException | PersistenceException pe) {
                throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
            } catch (Exception e) {
                throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
            }
    }

    @Override
    public CategoriaDTO findCategoriaById(Integer id) throws ServiceException {
        try {
            return Optional.ofNullable(categoriaDAO.findCategoriaEntityBy(id)).map(this::mapperCategoriaEntityDTO)
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd por id"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el id" + id, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }

    }

    @Override
    public CategoriaEntity findCategoriaEntityById(Integer id) throws ServiceException {
        try {
            return Optional.ofNullable(categoriaDAO.findCategoriaEntityBy(id))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd por id"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el id" + id, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public CategoriaEntity create(CategoriaDTO categoriaDTO) throws ServiceException {
        try {
            return categoriaDAO.save(mapperCategoriaDTOEntity(categoriaDTO));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "eror al crear el usuario" + categoriaDTO , pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public CategoriaEntity update(CategoriaDTO categoriaDTO) throws ServiceException {
        try {
            CategoriaEntity categoriaActual = categoriaDAO.findCategoriaEntityBy(categoriaDTO.getIdCategoria());
            categoriaActual.setTitulo(categoriaDTO.getTitulo());
            return categoriaDAO.save(categoriaActual);
        }catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "eror al crear el usuario" , pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        try {
            categoriaDAO.deleteById(id);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public CategoriaEntity disable(CategoriaDTO categoriaDTO) throws ServiceException {
        try{
            CategoriaEntity categoriaActual = mapperCategoriaDTOEntity(findCategoriaById(categoriaDTO.getIdCategoria()));
            categoriaActual.setEstado(categoriaDTO.getEstado());
            return categoriaDAO.save(categoriaActual);
        }
        catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "error al actualizar el Quiz" , pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public List<CategoriaDTO> findByTitleLike(String titulo) throws ServiceException {
        try {
            return Optional.ofNullable(mapperListCategoriaEntityDTO(categoriaDAO.findByTitleLike(titulo.toUpperCase())))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el documento", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    /*
   Mappers
    */
    //De entity a DTO
    public CategoriaDTO mapperCategoriaEntityDTO(CategoriaEntity categoriaEntity){
        return CategoriaDTO.builder().
                titulo(categoriaEntity.getTitulo())
                .estado(categoriaEntity.getEstado())
                .fechaCreacion(categoriaEntity.getFechaCreacion())
                .build();
    }


    //De entity a DTO
    public List<CategoriaDTO> mapperListCategoriaEntityDTO(List<CategoriaEntity> categoriaEntity){
        List<CategoriaDTO> lista = new ArrayList<>();
        for (CategoriaEntity categoria :categoriaEntity){
            lista.add(CategoriaDTO.builder()
                    .titulo(categoria.getTitulo())
                    .estado(categoria.getEstado())
                    .fechaCreacion(categoria.getFechaCreacion())
                    .build());
        }
        return lista;
    }


    //De DTO a entidad
    public CategoriaEntity mapperCategoriaDTOEntity(CategoriaDTO categoriaDTO){
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setTitulo(categoriaDTO.getTitulo().toUpperCase());
        categoria.setFechaCreacion(util.fechaActual());
        categoria.setEstado(Estado.ACTIVO);
        return categoria;
    }
}
