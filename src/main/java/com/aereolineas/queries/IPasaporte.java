package com.aereolineas.queries;

import com.aereolineas.entity.Pasaporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPasaporte extends JpaRepository<Pasaporte,Long> {
    List<Pasaporte> findByNumero(String numero);

    List<Pasaporte> findByPasajeroId(Long pasajeroId);


    boolean existsByNumero(String numero);


    void deleteByNumero(String numero);


    int countByPasajeroId(Long pasajeroId);


    @Query("SELECT COUNT(r) FROM Reserva r")
    Long countTotalReservas();

    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.pasajero.id = :pasajeroId")
    Long countReservasByPasajeroId(@Param("pasajeroId") Long pasajeroId);


    @Query("SELECT p FROM Pasaporte p WHERE p.numero = :numero")
    Pasaporte findPasaporteByNumero(@Param("numero") String numero);


    @Query("SELECT p FROM Pasaporte p WHERE p.pasajero.id = :pasajeroId")
    List<Pasaporte> findPasaportesByPasajeroId(@Param("pasajeroId") Long pasajeroId);


    @Query("SELECT p FROM Pasaporte p WHERE p.numero LIKE :%")
    List<Pasaporte> findPasaportesByNumeroStartingWith(@Param("cadena") String cadena);
}
