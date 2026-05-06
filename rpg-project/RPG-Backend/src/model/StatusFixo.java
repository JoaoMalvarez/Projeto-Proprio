package com.rpg.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "status_fixos")
@Data @NoArgsConstructor @AllArgsConstructor
public class StatusFixo {

    @Id
    @Column(length = 50)
    private String chave;

    @Column(nullable = false)
    private Integer valor;
}