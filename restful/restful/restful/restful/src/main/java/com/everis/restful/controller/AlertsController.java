package com.everis.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.restful.model.Alert;
import com.everis.restful.model.Detail;
import com.everis.restful.service.AlertService;
import com.everis.restful.service.DetailService;

@RestController
public class AlertsController {
    
	@Autowired private AlertService alertService; 
	@Autowired private DetailService detailService; 
	
	@PostMapping("/event/alert")
	public ResponseEntity<String> readAndWriteAlert(@RequestBody Alert alert) {
		//Long alertId = alertService.saveAndFlush(alert).getId();
		alertService.save(alert);
		for(Detail detail : alert.getDetails()) {
			detailService.save(detail);
		}
		return new ResponseEntity<String>("Sucesso", HttpStatus.OK);
	}
	
}
