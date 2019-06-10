package com.everis.restful.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.restful.model.Commit;

public interface CommitService extends JpaRepository<Commit, Long>{

}
