package com.everis.restful.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.restful.model.Repository;

public interface RepositorioService extends JpaRepository<Repository, Long>{

}
