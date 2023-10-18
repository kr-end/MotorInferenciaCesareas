package com.example.api.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cesarea")
@Getter
@Setter
@NoArgsConstructor
public class CesareaEntity {
    @Id
    @Column(name = "id_cesarea", nullable = false, length = 15)
    private String idCesarea;

    @Column(length = 30)
    private String tipo;

    @Column(length = 30)
    private String motivo;

    @Column(name = "tipo_incision", length = 30)
    private String tipoIncision;
}
