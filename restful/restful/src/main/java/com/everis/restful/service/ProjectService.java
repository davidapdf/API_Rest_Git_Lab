package com.everis.restful.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.restful.model.Project;

public interface ProjectService extends JpaRepository<Project, Long> {

}
