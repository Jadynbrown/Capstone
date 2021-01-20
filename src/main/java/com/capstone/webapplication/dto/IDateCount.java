package com.capstone.webapplication.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public interface IDateCount {
	
	Date getApplicationDate();
	Integer getCountOfApplication();
	
	

}
