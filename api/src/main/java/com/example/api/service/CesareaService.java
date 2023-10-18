package com.example.api.service;

import com.example.api.persistance.entity.CesareaEntity;
import com.example.api.persistance.repository.CesareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CesareaService {
    private final CesareaRepository cesareaRepository;

    @Autowired
    public CesareaService(CesareaRepository cesareaRepository) {
        this.cesareaRepository = cesareaRepository;
    }

    public CesareaEntity save(CesareaEntity cesareaEntity) {
        return cesareaRepository.save(cesareaEntity);
    }

    public CesareaEntity getById(String id) {
        return cesareaRepository.findById(id).orElse(null);
    }

}
