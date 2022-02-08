package org.clases.libroservice.service.impl;

import org.clases.libroservice.exception.LibroNotFoundException;
import org.clases.libroservice.mapper.LibroMapper;
import org.clases.libroservice.model.LibroVO;
import org.clases.libroservice.persistence.model.Libro;
import org.clases.libroservice.persistence.repository.LibroRepository;
import org.clases.libroservice.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl implements LibroService {

  @Autowired
  private LibroMapper libroMapper;
  @Autowired
  private LibroRepository libroRepository;

  @Override
  public LibroVO findById(Long id) {
    Libro libro = libroRepository.findById(id);
    if(libro == null){
      throw new LibroNotFoundException("Libro no encontrado");
    }
    return libroMapper.entityToVO(libro);
  }

  @Override
  public void saveLibro(LibroVO libroVO) {
    libroRepository.save(libroMapper.voToEntity(libroVO));
  }

  @Override
  public void deleteLibro(Long id) {
    libroRepository.deleteById(id);
  }
}
