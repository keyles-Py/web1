package com.aereolineas.queries;

import com.aereolineas.entity.Aereolinea;
import com.aereolineas.entity.Pasajero;
import com.aereolineas.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAereolinea extends JpaRepository<Aereolinea,Long> {
    List<Aereolinea> findByNombreLike(String nombre);

    List<Aereolinea> findByVuelosDestino(String destino);

    List<Aereolinea> findByVuelosGreaterThan(int numero);

    List<Aereolinea> findByNombreContaining(String nombre);

    List<Aereolinea> findByPasajeroId(Long id);

    @Query("SELECT DISTINCT a.nombre FROM Aereolinea a WHERE SIZE(a.vuelos) > 0")
    List<String> findAereolineasConVuelos();

    @Query("SELECT a FROM Aereolinea a JOIN a.vuelos v WHERE v.destino LIKE %:destino%")
    List<Aereolinea> findByDestinoLike(@Param("destino") String destino);

    @Query("SELECT SIZE(a.vuelos) FROM Aereolinea a WHERE a.id = :id")
    int countVuelosByAereolineaId(@Param("id") Long id);

    @Query("SELECT a FROM Aereolinea a WHERE SIZE(a.vuelos) = 0")
    List<Aereolinea> findAereolineasSinVuelos();

    @Query("SELECT a FROM Aereolinea a JOIN a.vuelos v WHERE v.origen = :origen")
    List<Aereolinea> findByOrigenVuelo(@Param("origen") String origen);
}
