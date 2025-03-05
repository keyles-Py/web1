package com.aereolineas.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "pasaportes")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pasaporte {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @OneToOne(optional = false)
    @JoinColumn(name = "pasaporteId", referencedColumnName = "id")
    private Pasajero pasajero;
}
