package es.ramirez.venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ramirez.venta.model.entity.Entrada;

/**
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 20/08/2021
 */
@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer>{

}
