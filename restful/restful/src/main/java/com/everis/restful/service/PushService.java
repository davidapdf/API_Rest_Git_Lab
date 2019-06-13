package com.everis.restful.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.restful.model.Push;

public interface PushService extends JpaRepository<Push, Long>{

}
