package com.pk.productservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ProductNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;

	public ProductNotFoundException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}
