package com.everis.restful.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.restful.model.Alert;

public interface AlertService extends JpaRepository<Alert, Long>{

}
