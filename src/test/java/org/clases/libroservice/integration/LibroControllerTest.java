package org.clases.libroservice.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.clases.libroservice.controller.error.ErrorMessage;
import org.clases.libroservice.model.LibroVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@Sql("/import_data.sql")
class LibroControllerTest {

  @Autowired
  private MockMvc mockMvc;


  @Test
  void getLibro() throws Exception {

    LibroVO libro = new LibroVO();
    libro.setId(1l);
    libro.setISBN("1234abc");
    libro.setNombre("Dresden Files, Storm Front");
    String serilizedLibroVO = new ObjectMapper().writeValueAsString(libro);
    mockMvc.perform(get("/libros/1").header("authorization","Basic alice:1234").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string(serilizedLibroVO));
  }

  @Test
  void saveLibro() throws Exception {

    LibroVO libro = new LibroVO();
    libro.setISBN("1234abc");
    libro.setNombre("Dresden Files, Storm Front");
    String serilizedLibroVO = new ObjectMapper().writeValueAsString(libro);
    mockMvc.perform(post("/libros/").header("authorization","Basic alice:1234").contentType(MediaType.APPLICATION_JSON).content(serilizedLibroVO)).andExpect(status().isOk());
  }

  @Test
  void getLibroError() throws Exception {

    ErrorMessage errorMessage = new ErrorMessage("Libro no encontrado","Libro no encontrado");
    String serilizederrorMessage = new ObjectMapper().writeValueAsString(errorMessage);
    mockMvc.perform(get("/libros/3").header("authorization","Basic alice:1234").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound()).andExpect(content().string(serilizederrorMessage));
  }



}