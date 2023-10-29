package com.EspindolaLuz.primeraApi.Models.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "automobiles")
public class AutomobileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(name = "marca", columnDefinition = "VARCHAR(100)")
    private String brand;

    @Column(name = "modelo", columnDefinition = "VARCHAR(100)")
    private String model;

    @Column(name = "patente", columnDefinition = "VARCHAR(100)")
    private String patent;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
