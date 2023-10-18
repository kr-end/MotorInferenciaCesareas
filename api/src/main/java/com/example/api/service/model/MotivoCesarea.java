package com.example.api.service.model;

import lombok.Getter;

@Getter
public enum MotivoCesarea {
    // Motivos de cesárea prevista de antemano
    POSICION_PODALICA("El bebé está en posición podálica"),
    GESTOSIS("La futura madre padece gestosis"),
    DIABETES_GRADIVICA("La futura madre padece diabetes gravídica"),
    PLACENTA_PREVIA_CENTRAL("La placenta está en posición previa-central"),
    PROBLEMAS_CORAZON("La madre tiene problemas de corazón"),
    PROBLEMAS_RENALES("La madre tiene problemas renales"),
    INFECCIONES_GENITALES("La madre tiene graves infecciones en vías genitales"),

    // Motivos de cesárea improvisada durante el parto
    CABEZA_GRANDE("La cabeza del niño es demasiado grande y no cabe por el canal del parto"),
    CABEZA_NO_ENCAJADA("La cabeza del niño no está encajada correctamente en el canal del parto"),
    SUFRIMIENTO_FETAL("Existe sufrimiento fetal. Lo cual significa que el ritmo cardiaco del bebé ya no es regular o que empieza a expulsar mecónio"),
    PLACENTA_DESPRENDE("La placenta se desprende");

    private final String descripcion;

    MotivoCesarea(String descripcion) {
        this.descripcion = descripcion;
    }

}
