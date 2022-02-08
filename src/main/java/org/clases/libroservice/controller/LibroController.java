package org.clases.libroservice.controller;


import org.clases.libroservice.model.LibroVO;
import org.clases.libroservice.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Libro controller.
 */
@RestController
@RequestMapping(value = "/libros")
public class LibroController {

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

  @DeleteMapping(value = "/{id}")
  public void deleteLibro(@PathVariable("id") Long id){
    libroService.deleteLibro(id);
    //return ResponseEntity.ok("Entity deleted");
  }

  @PostMapping("/")
  public void saveLibro(@RequestBody LibroVO libroVO){
    this.libroService.saveLibro(libroVO);
  }

}
