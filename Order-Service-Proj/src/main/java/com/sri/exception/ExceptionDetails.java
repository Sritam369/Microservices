package com.sri.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionDetails {

	private LocalDateTime timestamp;
	private String errorMsg;
}
