package com.everis.restful.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "TB_REPOSITORY")
@Entity
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
	private Timestamp dtIncl;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "push_id",foreignKey =@ForeignKey(name ="FK_RepositoryPush"))
	@JsonBackReference
	private Push push;
    
    @Id
    private Long id;
	
	
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


	public Push getPush() {
		return push;
	}


	public void setPush(Push push) {
		this.push = push;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Timestamp getDtIncl() {
		return dtIncl;
	}


	public void setDtIncl(Timestamp dtIncl) {
		this.dtIncl = dtIncl;
	}



	
	
	
	
	
}
