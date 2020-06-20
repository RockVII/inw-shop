package com.inwshop.DTO;

import java.util.ArrayList;
import java.util.List;

public class ErrorDTO{

	private Integer status;
	private String message;
	private List<FieldErrorDTO> errors = new ArrayList<>();

	public ErrorDTO(){

	}

	public ErrorDTO(Integer status, String message) {
		this.status = status;
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public List<FieldErrorDTO> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldErrorDTO> errors) {
		this.errors = errors;
	}
	public void addFieldError(FieldErrorDTO fieldError){
		if(!errors.contains(fieldError))
			errors.add(fieldError);
	}
	public void clearFieldErrors(){
		errors.clear();
	}


}
