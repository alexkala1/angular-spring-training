package com.example.demo.Services;

import com.example.demo.Config.Exceptions.ApiRequestException;
import com.example.demo.Config.Exceptions.RecordNotFoundException;
import com.example.demo.DTO.TypeDTO;
import com.example.demo.Entities.TypeEntity;
import com.example.demo.Mappers.TypeMapper;
import com.example.demo.Repositories.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TypeService {
    private final TypeRepository repository;
    private final TypeMapper typeMapper;

    public List<TypeDTO> getAllTypes() {
        List<TypeEntity> typeList = repository.findAll();

        if (typeList.size() > 0) {
            return typeMapper.types(typeList);
        } else {
            return new ArrayList<>();
        }
    }

    public TypeDTO getTypeById(Long id) throws ApiRequestException {
        Optional<TypeEntity> type = repository.findById(id);

        if (type.isPresent()) {
            return typeMapper.typeDTO(type.get());
        } else {
            throw new ApiRequestException("No type record exist for given id");
        }
    }

    public TypeEntity createOrUpdateType(TypeEntity entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<TypeEntity> type = repository.findById(entity.getId());

            TypeEntity newEntity = type.get();
            newEntity.setName(entity.getName());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteTypeById(Long id) throws RecordNotFoundException {
        Optional<TypeEntity> type = repository.findById(id);

        if (type.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No type record exist for given id");
        }
    }
}
