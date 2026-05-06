package com.rpg.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "atributos")
@Data @NoArgsConstructor @AllArgsConstructor
public class Atributo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false)
    private Integer valor;
}