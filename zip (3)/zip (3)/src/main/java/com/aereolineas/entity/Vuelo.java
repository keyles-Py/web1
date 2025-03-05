package com.aereolineas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SqlFragmentAlias;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Vuelos")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Vuelo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private UUID numeroVuelo;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private  String destino;

    @OneToMany(mappedBy = "vuelo")
    private Set<Reserva> reservas;

    @ManyToMany(mappedBy = "vuelos")
    private Set<Aereolinea> aereolinea;
}
