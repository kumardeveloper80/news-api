package com.news.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author lapto
 *
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WsResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Object data;

	private String message;

	private String errorCode;

	private String errorMessage;

	private Integer status;

	private Object errorInfo;


}
