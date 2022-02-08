package org.clases.libroservice.controller;

import org.clases.libroservice.model.LibroVO;
import org.clases.libroservice.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Libro con code managament controller.
 */
@RestController
@RequestMapping(value = "/libros2")
public class LibroConCodeManagamentController {
  @Autowired
  private LibroService libroService;

  /**
   * Get libro libro vo.
   *
   * @param id the id
   *
   * @return the libro vo
   */
  @GetMapping(value = "/{id}")
  public LibroVO getLibro(@PathVariable("id") Long id){
    return libroService.findById(id);
  }

  /**
   * Delete libro response entity.
   *
   * @param id the id
   *
   * @return the response entity
   */
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deleteLibro(@PathVariable("id") Long id){
    libroService.deleteLibro(id);
    return ResponseEntity.accepted().build();
  }

  /**
   * Save libro.
   *
   * @param libroVO the libro vo
   */
  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public void saveLibro(@RequestBody LibroVO libroVO){
    this.libroService.saveLibro(libroVO);
  }
}
