package org.clases.libroservice.service;

import org.clases.libroservice.model.LibroVO;

/**
 * The interface Libro service.
 */
public interface LibroService {

  /**
   * Find by id libro vo.
   *
   * @param id the id
   *
   * @return the libro vo
   */
  LibroVO findById(Long id);

  /**
   * Save libro.
   *
   * @param libroVO the libro vo
   */
  void saveLibro(LibroVO libroVO);

  /**
   * Delete libro.
   *
   * @param id the id
   */
  void deleteLibro(Long id);
}
