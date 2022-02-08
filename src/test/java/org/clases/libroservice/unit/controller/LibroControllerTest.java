package org.clases.libroservice.unit.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.clases.libroservice.controller.LibroController;
import org.clases.libroservice.exception.LibroNotFoundException;
import org.clases.libroservice.model.LibroVO;
import org.clases.libroservice.service.LibroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class LibroControllerTest {

  @Mock
  private LibroService libroService;
  @InjectMocks
  private LibroController libroController;

  @BeforeEach
  private void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void getLibro() {

    LibroVO libro = new LibroVO();
    libro.setId(1l);
    Mockito.when(libroService.findById(Mockito.eq(1l))).thenReturn(libro);
    LibroVO result = libroController.getLibro(1l);
    assertEquals(result.getId(), libro.getId());
  }

  @Test()
    //en junit 4 existe @Test(expected=LibroNotFoundException.class)
  void getLibroError() {

    Mockito.when(libroService.findById(Mockito.eq(2l)))
        .thenThrow(new LibroNotFoundException("libro no encontrado"));

    LibroNotFoundException exception = assertThrows(LibroNotFoundException.class, () -> {
      libroController.getLibro(2l);
    });
    assertEquals("libro no encontrado", exception.getMessage());


  }

  @Test
  void deleteLibro() {
  }

  @Test
  void saveLibro() {
  }
}