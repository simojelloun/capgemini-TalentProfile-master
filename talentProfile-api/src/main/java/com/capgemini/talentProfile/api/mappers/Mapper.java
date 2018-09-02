/**
 * 
 */
package com.capgemini.talentProfile.api.mappers;

import java.util.List;

/**
 * The Interface Mapper.
 * @author douaaziz
 *
 * @param <A> Api
 * @param <D> Dto
 */
public interface Mapper<A, D> {
	

	/**
	 * From api to dto.
	 *
	 * @param apiModel the api model
	 * @return the d
	 */
	public D fromApiToDto(final A apiModel);
	

	/**
	 * From api model to dto.
	 *
	 * @param apiModels the api models
	 * @return the list
	 */
	public List<D> fromApiModelToDto(final List<A> apiModels) ;
	

	/**
	 * From dto to api model.
	 *
	 * @param dto the dto
	 * @return the a
	 */
	public A fromDtoToApiModel(final D dto);
	

	/**
	 * From dto to api model.
	 *
	 * @param dtos the dtos
	 * @return the list
	 */
	public List<A> fromDtoToApiModel(final List<D> dtos);
	
}
