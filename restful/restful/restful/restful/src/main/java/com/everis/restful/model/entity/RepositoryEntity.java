package com.everis.restful.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity(name = "Repository")
@Table(name = "repository")
@Component
public class RepositoryEntity {
    
	@Id
	private Long codigoRepositorio;
	private String repositoryName;
	private String repositoryUrl;
	private String repositoryDescription;
	private String repositoryHomepage;
	private String repositoryGitHttpUrl;
	private String repositoryGitSshUrl;
	private int repositoryVisibilityLevel;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
	private PushEntity push;

	public RepositoryEntity(){}
	
	public Long getCodigoRepositorio() {
		return codigoRepositorio;
	}

	public void setCodigoRepositorio(Long codigoRepositorio) {
		this.codigoRepositorio = codigoRepositorio;
	}

	public String getRepositoryName() {
		return repositoryName;
	}

	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}

	public String getRepositoryUrl() {
		return repositoryUrl;
	}

	public void setRepositoryUrl(String repositoryUrl) {
		this.repositoryUrl = repositoryUrl;
	}

	public String getRepositoryDescription() {
		return repositoryDescription;
	}

	public void setRepositoryDescription(String repositoryDescription) {
		this.repositoryDescription = repositoryDescription;
	}

	public String getRepositoryHomepage() {
		return repositoryHomepage;
	}

	public void setRepositoryHomepage(String repositoryHomepage) {
		this.repositoryHomepage = repositoryHomepage;
	}

	public String getRepositoryGitHttpUrl() {
		return repositoryGitHttpUrl;
	}

	public void setRepositoryGitHttpUrl(String repositoryGitHttpUrl) {
		this.repositoryGitHttpUrl = repositoryGitHttpUrl;
	}

	public String getRepositoryGitSshUrl() {
		return repositoryGitSshUrl;
	}

	public void setRepositoryGitSshUrl(String repositoryGitSshUrl) {
		this.repositoryGitSshUrl = repositoryGitSshUrl;
	}

	public int getRepositoryVisibilityLevel() {
		return repositoryVisibilityLevel;
	}

	public void setRepositoryVisibilityLevel(int repositoryVisibilityLevel) {
		this.repositoryVisibilityLevel = repositoryVisibilityLevel;
	}

	public PushEntity getPush() {
		return push;
	}

	public void setPush(PushEntity push) {
		this.push = push;
	}
	
	
}
