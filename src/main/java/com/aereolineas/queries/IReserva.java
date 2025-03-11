package com.aereolineas.queries;

import com.aereolineas.entity.Pasajero;
import com.aereolineas.entity.Reserva;
import com.aereolineas.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IReserva extends JpaRepository<Reserva,Long> {
    List<Reserva> findByCodigoReserva(UUID codigoReserva);


    List<Reserva> findByPasajero(Pasajero pasajero);

    List<Reserva> findByVuelo(Vuelo vuelo);


    List<Reserva> findByPasajeroAndVuelo(Pasajero pasajero, Vuelo vuelo);

    Long countByPasajero(Pasajero pasajero);

    @Query("SELECT r FROM Reserva r")
    List<Reserva> findAllReservas();


    @Query("SELECT r FROM Reserva r WHERE r.pasajero.id = :pasajeroId")
    List<Reserva> findReservasByPasajeroId(@Param("pasajeroId") Long pasajeroId);


    @Query("SELECT r FROM Reserva r WHERE r.vuelo.id = :vueloId")
    List<Reserva> findReservasByVueloId(@Param("vueloId") Long vueloId);
}
