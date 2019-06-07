package com.everis.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.restful.model.Commit;
import com.everis.restful.model.Push;
import com.everis.restful.model.entity.AddedEntity;
import com.everis.restful.model.entity.CommitEntity;
import com.everis.restful.model.entity.ModifiedEntity;
import com.everis.restful.model.entity.ProjectEntity;
import com.everis.restful.model.entity.PushEntity;
import com.everis.restful.model.entity.RemovedEntity;
import com.everis.restful.model.entity.RepositoryEntity;
import com.everis.restful.service.AddedEntityService;
import com.everis.restful.service.CommitEntityService;
import com.everis.restful.service.ModifiedEntityService;
import com.everis.restful.service.ProjectEntityService;
import com.everis.restful.service.PushEntityService;
import com.everis.restful.service.RemovedEntityService;
import com.everis.restful.service.RepositoryEntityService;

@RestController
public class PushesController {
     
    // inicialização via injeção de dependencia Spring dos serviços para as entidades
	@Autowired private PushEntityService pushEntityService;
	@Autowired private ProjectEntityService projectEntityService;
	@Autowired private RepositoryEntityService repositoryEntityService;
	@Autowired private CommitEntityService commitEntityService;
	@Autowired private AddedEntityService addedEntityService;
	@Autowired private ModifiedEntityService modifiedEntityService;
	@Autowired private RemovedEntityService removedEntityService;
	
	// inicialização via injeção de dependencia Spring das classes das entidades
	@Autowired private PushEntity pushEntity;
	@Autowired private ProjectEntity projectEntity;
	@Autowired private RepositoryEntity repositoryEntity;
	
	
	@PostMapping("/push/test")
	public Push readAndSendPushTest(@RequestBody Push push) {
		return push;
	}
	
	
	@PostMapping("/event/push")
	public ResponseEntity<PushEntity> readAndSendPush(@RequestBody Push push) {
        // popular objeto PushEntity antes de persistí-lo via Service
		setInfoPushEntity(pushEntity,push);
		// popular objeto ProjectEntity antes de persistí-lo via Service
		setInfoProjectEntity(projectEntity,pushEntity,push);
		// popular objeto RepositoryEntity antes de persistí-lo via Service
		setInfoRepositoryEntity(repositoryEntity,pushEntity,push);
        // persistir a tupla do evento push
        pushEntityService.save(pushEntity);
        // persistir a tupla do projeto
        projectEntityService.save(projectEntity);
        // persistir a tupla do repositorio
        repositoryEntityService.save(repositoryEntity);
        
        // persistir tuplas commits
        for(Commit commit : push.getCommits()) {
        	CommitEntity commitEntity = new CommitEntity();
        	commitEntity.setPush(pushEntity);
        	commitEntity.setEmail(commit.getAuthor().getEmail());
        	commitEntity.setName(commit.getAuthor().getNome());
        	commitEntity.setId(commit.getId());
        	commitEntity.setMessage(commit.getMessage());
        	commitEntity.setTimestamp(commit.getTimestamp());
        	commitEntity.setUrl(commit.getUrl());
        	
        	pushEntity.getCommits().add(commitEntity);
        	// persistir tupla commit
        	commitEntityService.save(commitEntity);
        	
        	// persistir tuplas addeds
        	for(String added : commit.getAdded()){
        		AddedEntity addedEntity = new AddedEntity();
        		addedEntity.setCommit(commitEntity);
        		addedEntity.setAdded(added);
        		commitEntity.getAddeds().add(addedEntity);
        		addedEntityService.save(addedEntity);
        	}
        	
        	// persistir tuplas modifieds
        	for(String modified : commit.getModified()){
        		ModifiedEntity modifiedEntity = new ModifiedEntity();
        		modifiedEntity.setCommit(commitEntity);
        		modifiedEntity.setModified(modified);
        		commitEntity.getModifieds().add(modifiedEntity);
        		modifiedEntityService.save(modifiedEntity);
        	}
        	
        	// persistir tuplas removeds
        	for(String removed : commit.getRemoved()){
        		RemovedEntity removedEntity = new RemovedEntity();
        		removedEntity.setCommit(commitEntity);
        		removedEntity.setRemoved(removed);
        		commitEntity.getRemoveds().add(removedEntity);
        		removedEntityService.save(removedEntity);
        	}
        }
		return new ResponseEntity<PushEntity>(pushEntity,HttpStatus.OK);
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void setInfoPushEntity(PushEntity pushEntity, Push push){
		pushEntity.setObjectKind(push.getObjectKind());
		pushEntity.setBefore(push.getBefore());
		pushEntity.setAfter(push.getAfter());
		pushEntity.setRef(push.getRef());
		pushEntity.setCheckoutSha(push.getCheckoutSha());
		pushEntity.setUserId(push.getUserId());
		pushEntity.setUserName(push.getUserName());
		pushEntity.setUserUsername(push.getUserUsername());
		pushEntity.setUserEmail(push.getUserEmail());
		pushEntity.setUserAvatar(push.getUserAvatar());
		pushEntity.setTotalCommitsCount(push.getTotalCommitsCount());
	}

	private void setInfoProjectEntity(ProjectEntity projectEntity, PushEntity pushEntity, Push push){
		projectEntity.setPush(pushEntity);
		projectEntity.setProjectAvatarUrl(push.getProject().getProjectAvatarUrl());
		projectEntity.setProjectDefaultBranch(push.getProject().getProjectDefaultBranch());
		projectEntity.setProjectDescription(push.getProject().getProjectDescription());
		projectEntity.setProjectGitHttpUrl(push.getProject().getProjectGitHttpUrl());
		projectEntity.setProjectGitSshUrl(push.getProject().getProjectGitSshUrl());
		projectEntity.setProjectHomepage(push.getProject().getProjectHomepage());
		projectEntity.setProjectHttpUrl(push.getProject().getProjectHttpUrl());
		projectEntity.setProjectId(push.getProject().getProjectId());
		projectEntity.setProjectName(push.getProject().getProjectName());
		projectEntity.setProjectNamespace(push.getProject().getProjectNamespace());
    	projectEntity.setProjectPathWithNamespace(push.getProject().getProjectPathWithNamespace());
    	projectEntity.setProjectSshUrl(push.getProject().getProjectSshUrl());
    	projectEntity.setProjectUrl(push.getProject().getProjectUrl());
    	projectEntity.setProjectVisibilityLevel(push.getProject().getProjectVisibilityLevel());
    	projectEntity.setProjectWebUrl(push.getProject().getProjectWebUrl());
	}

	private void setInfoRepositoryEntity(RepositoryEntity repositoryEntity, PushEntity pushEntity, Push push){
		repositoryEntity.setPush(pushEntity);
		repositoryEntity.setRepositoryName(push.getRepository().getRepositoryName());
		repositoryEntity.setRepositoryUrl(push.getRepository().getRepositoryUrl());
		repositoryEntity.setRepositoryDescription(push.getRepository().getRepositoryDescription());
		repositoryEntity.setRepositoryHomepage(push.getRepository().getRepositoryHomepage());
		repositoryEntity.setRepositoryGitHttpUrl(push.getRepository().getRepositoryGitHttpUrl());
		repositoryEntity.setRepositoryGitSshUrl(push.getRepository().getRepositoryGitSshUrl());
		repositoryEntity.setRepositoryVisibilityLevel(push.getRepository().getRepositoryVisibilityLevel());
	}


}
