package com.domain.airline.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.airline.dto.UpdateAirLineRequestDto;
import com.domain.airline.entities.AirlineEntity;
import com.domain.airline.repositories.AirlineRepository;


@Service
public class AirlineService {
	
	@Autowired
	AirlineRepository airlineRepo;

	public void saveAirline(AirlineEntity airline) {
		airlineRepo.save(airline);
		
	}

	//fetching active  flights
	public List<AirlineEntity> fetchDetails() {
		
		List<AirlineEntity> airLineEntities  =  (List<AirlineEntity>) airlineRepo.findAll();
		List<AirlineEntity> activeAirLineEntities = airLineEntities.stream().filter(eachAirlineEntity -> eachAirlineEntity.getIsActive()==true).collect(Collectors.toList());
	    return activeAirLineEntities;
	}

	//fetching all active flights
	
	/*
	 * public List<AirlineEntity> activeFlightd() {
	 * 
	 * }
	 */
	

	
	  public void updateAirline(AirlineEntity airline) { 
		  airlineRepo.save(airline);
	  
	  }
	  

	public void updateAirLines(UpdateAirLineRequestDto updateAirLineReqDto,Long id) {
		AirlineEntity airlineEntity  = convertDtoToEntity(updateAirLineReqDto,id);
		airlineRepo.save(airlineEntity);
	}

	private AirlineEntity convertDtoToEntity(UpdateAirLineRequestDto updateAirLineReqDto,Long id) {
		AirlineEntity entity = airlineRepo.findById(id).get();
		switch(updateAirLineReqDto.getUpdateFieldName()) {
		case "status":
			entity.setIsActive(updateAirLineReqDto.isStatus());
			break;
		case "timings":
			entity.setFlightTime(updateAirLineReqDto.getTimings());
			break;
		case "flightName":
			entity.setFlightName(updateAirLineReqDto.getFlightName());
			break;
		}
        return entity;
	}
	 

	
	}
	
	
	
	
	
	


