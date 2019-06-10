package com.everis.restful.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.restful.model.Modified;

public interface ModifiedService extends JpaRepository<Modified, Long>{

}
