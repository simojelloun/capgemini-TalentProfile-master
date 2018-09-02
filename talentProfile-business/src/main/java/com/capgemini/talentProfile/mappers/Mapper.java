/**
 * 
 */
package com.capgemini.talentProfile.mappers;

import java.util.List;

/**
 * The Interface Mapper.
 *
 * @author douaaziz
 * @param <E> the Entity
 * @param <D> the Dto
 */
public interface Mapper<E, D> {
	
	/**
	 * From dto to entity.
	 *
	 * @param dto the dto
	 * @return the entity
	 */
	public E fromDtoToEntity(final D dto);
	
	/**
	 * From dto to entity.
	 *
	 * @param dtos the dtos
	 * @return the list
	 */
	public List<E> fromDtoToEntity(final List<D> dtos) ;
	
	/**
	 * From entity to dto.
	 *
	 * @param entity the entity
	 * @return the dto
	 */
	public D fromEntityToDto(final E entity);
	
	/**
	 * From entity to dto.
	 *
	 * @param entities the entities
	 * @return the list
	 */
	public List<D> fromEntityToDto(final List<E> entities);
	
}
