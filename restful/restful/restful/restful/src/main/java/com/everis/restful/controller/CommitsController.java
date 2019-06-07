package com.everis.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.restful.model.Commit;
import com.everis.restful.model.entity.CommitEntity;
import com.everis.restful.service.CommitEntityService;

@RestController
public class CommitsController {
      
	@Autowired
	CommitEntityService commitEntityService;
	@Autowired
	CommitEntity commitEntity;
	
	@PostMapping("/commit")
	public CommitEntity readAndWriteCommit(@RequestBody Commit commit) {
		String email = commit.getAuthor().getEmail();
		String name = commit.getAuthor().getNome();
		String id = commit.getId();
		String message = commit.getMessage();
		String timestamp = commit.getTimestamp();
		String url = commit.getUrl();
		
		commitEntity.setEmail(email);
		commitEntity.setName(name);
		commitEntity.setId(id);
		commitEntity.setMessage(message);
		commitEntity.setTimestamp(timestamp);
		commitEntity.setUrl(url);
		
		return commitEntityService.save(commitEntity);
	}
	
	@PostMapping("/commit/test")
	public Commit readAndWriteCommitTest(@RequestBody Commit commit) {
		return commit;
	}
}
