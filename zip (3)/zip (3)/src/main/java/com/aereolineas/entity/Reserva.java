package com.aereolineas.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Reservas")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Reserva {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private UUID  codigoReserva;
    @ManyToOne
    @JoinColumn(name = "numVuelo")
    private Vuelo vuelo;
    @ManyToOne
    @JoinColumn(name = "pasajeroId")
    private Pasajero pasajero;
}
