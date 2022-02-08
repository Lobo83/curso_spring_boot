package org.clases.libroservice.persistence.repository;

import org.clases.libroservice.persistence.model.Libro;
import org.springframework.data.repository.RepositoryDefinition;
/**
 * The interface Libro repository.
 */
@RepositoryDefinition(domainClass = Libro.class,idClass = Long.class)
public interface LibroRepository {//extends Repository<Libro,Long> {

  /**
   * Find by id libro.
   *
   * @param id the id
   *
   * @return the libro
   */
  Libro findById(Long id);

  /**
   * Save libro.
   *
   * @param libro the libro
   */
  void save(Libro libro);

  /**
   * Delete libro.
   *
   * @param id the id
   */
  void deleteById(Long id);
}
