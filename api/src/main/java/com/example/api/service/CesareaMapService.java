package com.example.api.service;

import com.example.api.service.model.Cesarea;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CesareaMapService {
    private final Map<String, Cesarea> cesareaMap = new HashMap<>();

    public Cesarea getValue(String id) {
        return cesareaMap.get(id);
    }

    public void putValue(String id, Cesarea value) {
        cesareaMap.put(id, value);
    }

    public int getSize() {
        return cesareaMap.size();
    }
}
