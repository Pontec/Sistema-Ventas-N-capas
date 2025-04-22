package com.codigo.msventaspro.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rol")
@Getter
@Setter
@NoArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(nullable = false, unique = true)
    private String nombreRol;

    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
