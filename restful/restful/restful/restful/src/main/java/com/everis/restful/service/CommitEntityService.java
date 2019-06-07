package com.everis.restful.service;

import org.springframework.data.repository.CrudRepository;

import com.everis.restful.model.entity.CommitEntity;

public interface CommitEntityService extends CrudRepository<CommitEntity, Long>{

}
