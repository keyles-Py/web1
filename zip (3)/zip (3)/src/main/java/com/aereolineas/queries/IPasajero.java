package com.aereolineas.queries;

import com.aereolineas.entity.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPasajero extends JpaRepository<Pasajero,Long> {
    List<Pasajero> findByNombre(String nombre);
    List<Pasajero> findByNombreOrId(String nombre, String id);
    List<Pasajero> findByLastnameStartingWith(String name);
    List<Pasajero> findByFirstnameEndingWith(String name);
    List<Pasajero> findByNombreContaining(String nombre);

    @Query("SELECT p FROM Pasajero p")
    List<Pasajero> obtenerTodosLosPasajeros();


    @Query("SELECT p FROM Pasajero p WHERE p.nombre = :nombre")
    List<Pasajero> buscarPorNombre(@Param("nombre") String nombre);


    @Query("SELECT p FROM Pasajero p WHERE p.nombre LIKE %:nombre%")
    List<Pasajero> buscarPorNombreParcial(@Param("nombre") String nombre);


    @Query("SELECT p FROM Pasajero p WHERE p.id > :id")
    List<Pasajero> buscarPorIdMayorA(@Param("id") Long id);


    @Query("SELECT COUNT(p) FROM Pasajero p WHERE p.nombre = :nombre")
    Long contarPasajerosPorNombre(@Param("nombre") String nombre);
}
