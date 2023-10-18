package com.example.api.service.model;

public enum TipoIncision {
    UMBILICO_PUBICA("Incisión Umbílico Púbica: Es vertical y se realiza en la línea media del abdomen, desde el ombligo hasta el pubis"),
    TRANSVERSAL_BAJA("Incisión Transversal Baja: Es ligeramente curva y se realiza en la parte baja del abdomen, justo encima del vello púbico"),
    JOEL_COELL("Incisión de Joel Coell: Es una incisión transversal recta y baja, y se realiza en la parte baja del abdomen, justo encima del vello púbico");

    private final String descripcion;

    TipoIncision(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
