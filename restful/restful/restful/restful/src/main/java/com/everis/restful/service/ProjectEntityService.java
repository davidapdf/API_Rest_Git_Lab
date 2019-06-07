package com.everis.restful.service;

import org.springframework.data.repository.CrudRepository;

import com.everis.restful.model.entity.ProjectEntity;

public interface ProjectEntityService extends CrudRepository<ProjectEntity, Long>{

}
