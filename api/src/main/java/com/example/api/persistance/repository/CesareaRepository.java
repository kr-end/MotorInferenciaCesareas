package com.example.api.persistance.repository;

import com.example.api.persistance.entity.CesareaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface CesareaRepository extends CrudRepository<CesareaEntity, String> {
}
