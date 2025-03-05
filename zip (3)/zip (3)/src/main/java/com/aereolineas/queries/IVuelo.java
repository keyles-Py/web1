package com.aereolineas.queries;

import com.aereolineas.entity.Aereolinea;
import com.aereolineas.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IVuelo extends JpaRepository<Vuelo,String> {
    List<Vuelo> findByOrigenAndDestino(String origen, String destino);

    List<Vuelo> findByDestinoAndAereolinea(String destino, Aereolinea aereolinea);

    List<Vuelo> findByNumeroVuelo(UUID uuid);

    List<Vuelo> findByDestinoLike(String destino);

    List<Vuelo> findByOrigenDistinct(String origen);

    @Query("SELECT v FROM Vuelo v JOIN v.aereolinea a " +
            "WHERE v.origen = :origen AND v.destino = :destino AND a.id = :aereolineaId")
    List<Vuelo> findByOrigenAndDestinoAndAereolinea(@Param("origen") String origen,
                                                    @Param("destino") String destino,
                                                    @Param("aereolineaId") Long aereolineaId);

    @Query("SELECT v FROM Vuelo v WHERE v.origen = :origen")
    List<Vuelo> findByOrigen(@Param("origen") String origen);

    @Query("SELECT SIZE(v.reservas) FROM Vuelo v WHERE v.id = :id")
    int countReservasByVueloId(@Param("id") Long id);

    @Query("SELECT v FROM Vuelo v JOIN v.aereolinea a WHERE a.id = :aereolineaId")
    List<Vuelo> findByAereolineaId(@Param("aereolineaId") Long aereolineaId);

    @Query("SELECT v FROM Vuelo v WHERE SIZE(v.reservas) = 0")
    List<Vuelo> findVuelosSinReservas();
}
