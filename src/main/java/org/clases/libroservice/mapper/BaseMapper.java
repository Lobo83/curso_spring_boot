package org.clases.libroservice.mapper;

import java.util.List;

/**
 * The interface Base mapper.
 *
 * @param <VO> the type parameter
 * @param <E> the type parameter
 */
public interface BaseMapper <VO,E> {

  /**
   * Vo to entity e.
   *
   * @param vo the vo
   *
   * @return the e
   */
  E voToEntity(VO vo);

  /**
   * Entity to vo vo.
   *
   * @param entity the entity
   *
   * @return the vo
   */
  VO entityToVO(E entity);

  /**
   * Vos to entities list.
   *
   * @param vos the vos
   *
   * @return the list
   */
  List<E> vosToEntities(List<VO> vos);

  /**
   * Entities to v os list.
   *
   * @param entities the entities
   *
   * @return the list
   */
  List<VO> entitiesToVOs(List<E> entities);
}
