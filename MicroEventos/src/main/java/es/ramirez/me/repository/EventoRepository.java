package es.ramirez.me.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.ramirez.me.model.entities.Evento;

/**
 * EventoRepository.java interfaz que hereda todas las operaciones de
 * persistencia de un evento en MongoRepository
 * 
 * @author Leyanis Ramírez
 * @version 1.0, 10/08/2021
 */
public interface EventoRepository extends MongoRepository<Evento, Integer> {

}
