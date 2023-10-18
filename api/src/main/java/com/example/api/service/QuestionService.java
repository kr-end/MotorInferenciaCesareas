package com.example.api.service;

import com.example.api.service.dto.QuestionRequestDto;
import com.example.api.service.dto.QuestionResponseDto;
import com.example.api.service.model.Cesarea;
import com.example.api.service.model.MotivoCesarea;
import com.example.api.service.model.TipoCesarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private final List<QuestionResponseDto> questionResponseDtoList = new ArrayList<>() {{
        add(new QuestionResponseDto(1, "¿Es una cesarea de emergencia o planeada?",
                List.of("Cesarea de Emergencia", "Cesarea Planeada")));
        add(new QuestionResponseDto(2, "¿Cual es el motivo?", // Cesarea planeada
                List.of("El bebé está en posición podálica", "La futura madre padece gestosis",
                        "La futura madre padece diabetes gravídica", "La placenta está en posición previa-central",
                        "La madre tiene problemas de corazón", "La madre tiene problemas renales",
                        "La madre tiene graves infecciones en vías genitales")));
        add(new QuestionResponseDto(3, "¿Cual es el motivo", // Cesarea de emergencia
                List.of("La cabeza del niño es demasiado grande y no cabe por el canal del parto",
                        "La cabeza del niño no está encajada correctamente en el canal del parto",
                        "Existe sufrimiento fetal. Lo cual significa que el ritmo cardiaco del bebé ya no es regular o que empieza a expulsar mecónio",
                        "La placenta se desprende")));
    }};

    private final CesareaService cesareaService;
    private final CesareaMapService cesareaMapService;

    @Autowired
    public QuestionService(CesareaService cesareaService, CesareaMapService cesareaMapService) {
        this.cesareaService = cesareaService;
        this.cesareaMapService = cesareaMapService;
    }

    public QuestionResponseDto question1(QuestionRequestDto question) {
        if (question.getAnswer().equals("Cesarea de Emergencia")) {
            cesareaMapService.putValue(question.getPacientId(), new Cesarea(TipoCesarea.EMERGENCIA));
            return questionResponseDtoList.get(3 - 1);
        } else if (question.getAnswer().equals("Cesarea Planeada")) {
            cesareaMapService.putValue(question.getPacientId(), new Cesarea(TipoCesarea.PLANEADA));
            return questionResponseDtoList.get(2 - 1);
        }

        // bad request
        return null;
    }

    public Cesarea question2(QuestionRequestDto question) {
        try {
            Cesarea cesarea = cesareaMapService.getValue(question.getPacientId());

            switch (question.getAnswer()) {
                case "El bebé está en posición podálica" -> cesarea.setMotivo(MotivoCesarea.POSICION_PODALICA);
                case "La futura madre padece gestosis" -> cesarea.setMotivo(MotivoCesarea.GESTOSIS);
                case "La futura madre padece diabetes gravídica" -> cesarea.setMotivo(MotivoCesarea.DIABETES_GRADIVICA);
                case "La placenta está en posición previa-central" ->
                        cesarea.setMotivo(MotivoCesarea.PLACENTA_PREVIA_CENTRAL);
                case "La madre tiene problemas de corazón" -> cesarea.setMotivo(MotivoCesarea.PROBLEMAS_CORAZON);
                case "La madre tiene problemas renales" -> cesarea.setMotivo(MotivoCesarea.PROBLEMAS_RENALES);
                case "La madre tiene graves infecciones en vías genitales" ->
                        cesarea.setMotivo(MotivoCesarea.INFECCIONES_GENITALES);
                case "La cabeza del niño es demasiado grande y no cabe por el canal del parto" ->
                        cesarea.setMotivo(MotivoCesarea.CABEZA_GRANDE);
                case "La cabeza del niño no está encajada correctamente en el canal del parto" ->
                        cesarea.setMotivo(MotivoCesarea.CABEZA_NO_ENCAJADA);
                case "Existe sufrimiento fetal. Lo cual significa que el ritmo cardiaco del bebé ya no es regular o que empieza a expulsar mecónio" ->
                        cesarea.setMotivo(MotivoCesarea.SUFRIMIENTO_FETAL);
                case "La placenta se desprende" -> cesarea.setMotivo(MotivoCesarea.PLACENTA_DESPRENDE);
                default -> {
                    // bad request
                    return null;
                }
            }

            // Cesarea final, al crearse se verifica que el motivo sea válido para el tipo de cesarea
            // y se determina el tipo de incisión
            return new Cesarea(cesarea.getTipo(), cesarea.getMotivo());
        } catch (Exception e) {
            // bad request and log error
            System.out.println(e.getMessage());
            return null;
        }
    }

}
