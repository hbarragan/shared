package com.formacion.marca.services.impl;

import com.formacion.marca.mapper.MarcaMapper;
import com.formacion.marca.model.entity.Marca;
import com.formacion.marca.model.json.MarcaFiltersJson;
import com.formacion.marca.model.json.MarcaJson;
import com.formacion.marca.repository.MarcaRepository;
import com.formacion.marca.repository.MarcaRepositoryCustom;
import com.formacion.marca.services.MarcaService;
import com.formacion.util.EntityValidatorHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository repository;

    @Autowired
    private MarcaRepositoryCustom repositoryCustom;

    @Override
    public MarcaJson getById(Long id) {
        return MarcaMapper.INSTANCE.convertByEntity((Marca) EntityValidatorHelper.validateIfExists(repository, id));
    }

    @Override
    public Page<MarcaJson> getAll(MarcaFiltersJson filter, Pageable pageable) {
        return repositoryCustom.findAllByFilter(filter, pageable);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MarcaJson create(MarcaJson marcaJson) {
        return MarcaMapper.INSTANCE
                .convertByEntity(repository.saveAndFlush(MarcaMapper.INSTANCE.convertByJson(marcaJson)));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MarcaJson update(MarcaJson marcaJson) {
        EntityValidatorHelper.validateExistsAndLastModified(repository, marcaJson.getId(),
                marcaJson.getDataModificacio());
        // TODO: comentarios de validacion de negocio ::
        // validateEquipament(equipamentJson);
        return MarcaMapper.INSTANCE
                .convertByEntity(repository.saveAndFlush(MarcaMapper.INSTANCE.convertByJson(marcaJson)));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void remove(Long id) {
        EntityValidatorHelper.validateIfExists(repository, id);
        repository.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        for (Long id : ids) {
            try {
                remove(id);
            } catch (Exception ex) {
                new EntityNotFoundException();
            }
        }
    }
}
