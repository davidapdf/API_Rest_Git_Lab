package com.everis.restful.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.restful.model.Detail;

public interface DetailService extends JpaRepository<Detail, Long> {

}
