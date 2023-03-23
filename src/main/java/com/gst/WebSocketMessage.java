package com.gst;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebSocketMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("toWhom")
	public String toWhom;

	@JsonProperty("fromWho")
	public String fromWho;

	@JsonProperty("message")
	public String message;
	
	

	public WebSocketMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebSocketMessage(final String toWhom, final String fromWho, final String message) {
		this.toWhom = toWhom;
		this.fromWho = fromWho;
		this.message = message;
	}

	public String getToWhom() {
		return toWhom;
	}

	public String getFromWho() {
		return fromWho;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "WebSocketMessage [toWhom=" + toWhom + ", fromWho=" + fromWho + ", message=" + message + "]";
	}

	
	
}
