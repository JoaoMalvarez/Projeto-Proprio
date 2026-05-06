package com.rpg.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "acessorios")
@Data @NoArgsConstructor @AllArgsConstructor
public class Acessorio {

    @Id
    @Column(length = 60)
    private String nome;

    @Column(nullable = false)
    private Integer bonus;

    @Column(nullable = false)
    private Boolean equipado;
}