package com.domain.airline.dto;

import java.time.LocalDateTime;


public class UpdateAirLineRequestDto {
	String updateFieldName;
	boolean status; //0 ,1 
	LocalDateTime timings; //null
	String flightName;
	
	
//	{
//		
//		"updateFieldName":"status",
//		"status":1,
//		"timings":null,
//		"flightName":null
//	}
	
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getUpdateFieldName() {
		return updateFieldName;
	}
	public void setUpdateFieldName(String updateFieldName) {
		this.updateFieldName = updateFieldName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public LocalDateTime getTimings() {
		return timings;
	}
	public void setTimings(LocalDateTime timings) {
		this.timings = timings;
	}
	
}
