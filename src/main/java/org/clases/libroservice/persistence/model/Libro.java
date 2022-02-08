package org.clases.libroservice.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * The type Libro.
 */
@Data
@Entity
@Table(name="LIBRO")
public class Libro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID")
  private Long id;
  @Column(name="NOMBRE")
  private String nombre;
  @Column(name="ISBN")
  private String ISBN;

}
