package org.clases.libroservice.mapper;

import org.clases.libroservice.model.LibroVO;
import org.clases.libroservice.persistence.model.Libro;
import org.mapstruct.Mapper;

/**
 * The interface Libro mapper.
 */
@Mapper(componentModel = "spring")
public interface LibroMapper extends BaseMapper<LibroVO, Libro> {

}
