package com.everis.restful.model;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class Repository {


	@JsonProperty("name")
	private String repositoryName;
	@JsonProperty("url")
	private String repositoryUrl;
	@JsonProperty("description")
	private String repositoryDescription;
	@JsonProperty("homepage")
	private String repositoryHomepage;
	@JsonProperty("git_http_url")
	private String repositoryGitHttpUrl;
	@JsonProperty("git_ssh_url")
	private String repositoryGitSshUrl;
	@JsonProperty("visibility_level")
	private int repositoryVisibilityLevel;
	
	
	public Repository(){}


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

    
	
	
	
	
	
}
