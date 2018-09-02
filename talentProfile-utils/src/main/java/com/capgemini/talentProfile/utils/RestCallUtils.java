package com.capgemini.talentProfile.utils;

import org.springframework.web.client.RestTemplate;

/**
 * The Class ApiCallService.
 */
public class RestCallUtils {
	
	
	/** The rest template. */
	private static RestTemplate REST_TEMPLATE = new RestTemplate();
	
	/**
	 * Instantiates a new api call service.
	 */
	private RestCallUtils() {
		super();
	}
	
	
	/**
	 * Gets method.
	 *
	 * @param <T> the generic type
	 * @param url the url
	 * @param returnType the return type
	 * @return the t
	 */
	public static <T> T get(String url, Class<T> returnType) {
		return returnType.cast(REST_TEMPLATE.getForObject(url, returnType));
	}
	
	
	/**
	 * Post method.
	 *
	 * @param <T> the generic type
	 * @param url the url
	 * @param data the data
	 * @param returnType the return type
	 * @return the t
	 */
	public static <T> T post(String url, Class<T> data, Class<T> returnType) {
		return returnType.cast(REST_TEMPLATE.postForObject(url, data, returnType));
	}

}
