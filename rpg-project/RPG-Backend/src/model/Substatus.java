package com.rpg.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "substatus")
@Data @NoArgsConstructor @AllArgsConstructor
public class Substatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(nullable = false, length = 50)
    private String categoria;

    @Column(nullable = false)
    private Integer valor;
}