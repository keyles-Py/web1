package com.aereolineas.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Aereolineas")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Aereolinea {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "VuelosAereolineas",
            joinColumns = @JoinColumn(name = "aereolineaId",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "vueloId",referencedColumnName = "id")
    )
    private List<Vuelo> vuelos = new ArrayList<>();

    public void addVuelo(Vuelo vuelo){
        this.vuelos.add(vuelo);
    }
}
