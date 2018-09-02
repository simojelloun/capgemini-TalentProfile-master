package com.capgemini.talentProfile.services.implementations.exceptions;

import java.io.Serializable;

/**
 * Abstract representation of a business error case.
 * An error case contains :
 * <ul>
 * <li>An error code (name) : The code can be used in client business logic in order to take decisions,</li>
 * <li>A message : The message provide comprehensive detail about the error case, for debug and analysis purpose only.
 * It is returned in Web services faults, but it <b>must not</b> be displayed to final users.
 * </ul>
 * Most of the time BusinessError are implemented as enum in BusinessExceptionWithError
 */
public interface Error extends Serializable {

	/**
	 * @return the error message
	 */
	String getMessage();

	/**
	 * @return trick : name() is needed in BusinessExceptionWithError, and is implemented by enum
	 */
	String name();
}
