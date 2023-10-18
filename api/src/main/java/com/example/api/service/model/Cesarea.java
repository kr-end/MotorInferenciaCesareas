package com.example.api.service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cesarea {
    private TipoCesarea tipo;
    private MotivoCesarea motivo;
    private TipoIncision tipoIncision;
    private String descripcion;

    public Cesarea(TipoCesarea tipo) {
        this.tipo = tipo;
    }

    public Cesarea(MotivoCesarea motivo) {
        this.motivo = motivo;
    }

    // Constructor que recibe el tipo de cesárea y el motivo, y determina el tipo de incisión
    public Cesarea(TipoCesarea tipo, MotivoCesarea motivo) {
        // Verificar si el motivo es válido para el tipo de cesárea
        if (tipo == TipoCesarea.EMERGENCIA) {
            if (!esMotivoCesareaDeEmergencia(motivo)) {
                throw new IllegalArgumentException("Motivo no válido para una cesárea de emergencia");
            }
        } else if (tipo == TipoCesarea.PLANEADA) {
            if (!esMotivoCesareaPlaneada(motivo)) {
                throw new IllegalArgumentException("Motivo no válido para una cesárea planeada");
            }
        }

        this.tipo = tipo;
        this.motivo = motivo;

        // Determinar el tipo de incisión
        if (tipo == TipoCesarea.EMERGENCIA && motivo == MotivoCesarea.PLACENTA_DESPRENDE) {
            this.tipoIncision = TipoIncision.UMBILICO_PUBICA;
        } else {
            // En el resto de los casos se realiza una cesárea del tipo transversal baja o de Joel Coell
            this.tipoIncision = determinarTipoIncisionAleatorio();
        }
        setDescripcion();
    }

    // Función para verificar si un motivo es válido para una cesárea de emergencia
    private boolean esMotivoCesareaDeEmergencia(MotivoCesarea motivo) {
        return motivo == MotivoCesarea.CABEZA_GRANDE || motivo == MotivoCesarea.CABEZA_NO_ENCAJADA
                || motivo == MotivoCesarea.SUFRIMIENTO_FETAL || motivo == MotivoCesarea.PLACENTA_DESPRENDE;
    }

    // Función para verificar si un motivo es válido para una cesárea prevista
    private boolean esMotivoCesareaPlaneada(MotivoCesarea motivo) {
        return motivo == MotivoCesarea.POSICION_PODALICA || motivo == MotivoCesarea.GESTOSIS
                || motivo == MotivoCesarea.DIABETES_GRADIVICA || motivo == MotivoCesarea.PLACENTA_PREVIA_CENTRAL
                || motivo == MotivoCesarea.PROBLEMAS_CORAZON || motivo == MotivoCesarea.PROBLEMAS_RENALES
                || motivo == MotivoCesarea.INFECCIONES_GENITALES;
    }

    // Función para determinar aleatoriamente el tipo de incisión
    private TipoIncision determinarTipoIncisionAleatorio() {
        return Math.random() < 0.5 ? TipoIncision.TRANSVERSAL_BAJA : TipoIncision.JOEL_COELL;
    }

    private void setDescripcion() {
        this.descripcion = "Se recomienda una cesárea " + tipo + "\n" + motivo.getDescripcion() + "\n" + tipoIncision.getDescripcion() + ".";
    }
}
