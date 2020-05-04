package com.valorcompartido.springboot.app.services.impl;

import com.valorcompartido.springboot.app.core.exceptions.base.ServiceException;
import com.valorcompartido.springboot.app.core.exceptions.enums.LogRefServices;
import com.valorcompartido.springboot.app.core.exceptions.persistence.DataNotFoundPersistenceException;
import com.valorcompartido.springboot.app.core.util.Util;
import com.valorcompartido.springboot.app.daos.SubCategoriaDAO;
import com.valorcompartido.springboot.app.model.dto.CategoriaDTO;
import com.valorcompartido.springboot.app.model.dto.SubCateogiraDTO;
import com.valorcompartido.springboot.app.model.emuns.Estado;
import com.valorcompartido.springboot.app.model.entity.CategoriaEntity;
import com.valorcompartido.springboot.app.model.entity.SubCategoriaEntity;
import com.valorcompartido.springboot.app.services.CategoriaService;
import com.valorcompartido.springboot.app.services.SubcategoriaService;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ISubcategoriaService implements SubcategoriaService {

    private final SubCategoriaDAO subcategoriaDAO;
    private final CategoriaService categoriaService;
    private final Util util;

    public ISubcategoriaService(SubCategoriaDAO subcategoriaDAO, CategoriaService categoriaService, Util util) {
        this.subcategoriaDAO = subcategoriaDAO;
        this.categoriaService = categoriaService;
        this.util = util;
    }


    @Override
    public List<SubCateogiraDTO> listaSubCategoria() throws ServiceException {
        try {
            List<SubCategoriaEntity> listSub = Optional.of(subcategoriaDAO.findAll())
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));
            return listSub.stream().map(this::mapperSubcategoriaEntityDTO).collect(Collectors.toList());
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public SubCateogiraDTO findSubCategoriaById(Integer id) throws ServiceException {
        try {
            return Optional.ofNullable(subcategoriaDAO.findSubCategoriaEntityBy(id)).map(this::mapperSubcategoriaEntityDTO)
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd por id"));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el id" + id, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public SubCateogiraDTO create(SubCateogiraDTO subCategoriaDTO) throws ServiceException {
        try {
            return mapperSubcategoriaEntityDTO(subcategoriaDAO.save(mapperSubcategoriaDTOEntity(subCategoriaDTO)));
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "eror al crear el usuario" + subCategoriaDTO, pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public SubCategoriaEntity update(SubCateogiraDTO subCategoriaDTO) throws ServiceException {
        try {
            SubCategoriaEntity categoriaActual = subcategoriaDAO.findSubCategoriaEntityBy(subCategoriaDTO.getIdSubCategoria());
            categoriaActual.setTitulo(subCategoriaDTO.getTitulo());
            return subcategoriaDAO.save(categoriaActual);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "eror al crear la subcategoria", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        try {
            subcategoriaDAO.deleteById(id);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public SubCategoriaEntity disable(SubCateogiraDTO subCategoriaDTO) throws ServiceException {
        try {
            SubCategoriaEntity subcategoriaActual = mapperSubcategoriaDTOEntity(findSubCategoriaById(subCategoriaDTO.getIdSubCategoria()));
            subcategoriaActual.setEstado(subCategoriaDTO.getEstado());
            return subcategoriaDAO.save(subcategoriaActual);
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "error al actualizar el Quiz", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    @Override
    public List<SubCateogiraDTO> findByTitleLike(String titulo) throws ServiceException {
        try {
            List<SubCategoriaEntity> listSub = Optional.of(subcategoriaDAO.findByTitleLike(titulo.toUpperCase()))
                    .orElseThrow(() -> new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "No existen registros en la bd"));

            return listSub.stream().map(this::mapperSubcategoriaEntityDTO).collect(Collectors.toList());
        } catch (IllegalArgumentException | PersistenceException pe) {
            throw new DataNotFoundPersistenceException(LogRefServices.ERROR_DATO_NO_ENCONTRADO, "Dato no encontrado por el documento", pe);
        } catch (Exception e) {
            throw new ServiceException(LogRefServices.ERROR_GENERAL_SERVICIO, "Error general del servicio", e);
        }
    }

    /*
    Mappers
     */
    public SubCategoriaEntity mapperSubcategoriaDTOEntity(SubCateogiraDTO subcategoriaDTO) throws ServiceException {
        SubCategoriaEntity subcategoria = new SubCategoriaEntity();
        CategoriaEntity categoria = categoriaService.findCategoriaEntityById(subcategoriaDTO.getCategoriaIdCategoria().getIdCategoria());
        subcategoria.setTitulo(subcategoriaDTO.getTitulo().toUpperCase());
        subcategoria.setEstado(Estado.ACTIVO);
        subcategoria.setFechaCreacion(util.fechaActual());
        subcategoria.setCategoriaByCategoriaIdCategoria(categoria);
        return subcategoria;
    }

    public SubCateogiraDTO mapperSubcategoriaEntityDTO(SubCategoriaEntity subcategoria) {
        return SubCateogiraDTO.builder()
                .titulo(subcategoria.getTitulo().toUpperCase())
                .estado(subcategoria.getEstado())
                .fechaCreacion(subcategoria.getFechaCreacion())
                .categoriaIdCategoria(new CategoriaDTO(
                        subcategoria.getCategoriaByCategoriaIdCategoria().getIdCategoria(),
                        subcategoria.getCategoriaByCategoriaIdCategoria().getTitulo(),
                        subcategoria.getCategoriaByCategoriaIdCategoria().getFechaCreacion())
                )
                .build();

    }
}
