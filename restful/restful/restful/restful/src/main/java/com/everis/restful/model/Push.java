package com.everis.restful.model;

import java.util.ArrayList;
import javax.persistence.Embedded;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Entity
public class Push {
     
	@JsonProperty("object_kind")
	private String objectKind;
	@JsonProperty("before")
	private String before;
	@JsonProperty("after")
	private String after;
	@JsonProperty("ref")
	private String ref;
	@JsonProperty("checkout_sha")
	private String checkoutSha;
	@JsonProperty("user_id")
	private int userId;
	@JsonProperty("user_name")
	private String userName;
	@JsonProperty("user_username")
	private String userUsername;
	@JsonProperty("user_email")
	private String userEmail;
	@JsonProperty("user_avatar")
	private String userAvatar;
	@JsonProperty("project_id")
	private String projectId; 
	@JsonProperty("project")
	@Embedded
	private Project project;
	@JsonProperty("commits")
	@Embedded
	private ArrayList<Commit> commits;
	@JsonProperty("repository")
	@Embedded
	private Repository repository;
	@JsonProperty("total_commits_count")
	private int totalCommitsCount;
		
	
	public Push(){}


	public String getObjectKind() {
		return objectKind;
	}

	public void setObjectKind(String objectKind) {
		this.objectKind = objectKind;
	}

	public String getBefore() {
		return before;
	}



	public void setBefore(String before) {
		this.before = before;
	}



	public String getAfter() {
		return after;
	}



	public void setAfter(String after) {
		this.after = after;
	}



	public String getRef() {
		return ref;
	}



	public void setRef(String ref) {
		this.ref = ref;
	}



	public String getCheckoutSha() {
		return checkoutSha;
	}



	public void setCheckoutSha(String checkoutSha) {
		this.checkoutSha = checkoutSha;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserUsername() {
		return userUsername;
	}



	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getUserAvatar() {
		return userAvatar;
	}



	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}



	public Project getProject() {
		return project;
	}



	public void setProject(Project project) {
		this.project = project;
	}



	public Repository getRepository() {
		return repository;
	}



	public void setRepository(Repository repository) {
		this.repository = repository;
	}


	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public ArrayList<Commit> getCommits() {
		return commits;
	}


	public void setCommits(ArrayList<Commit> commits) {
		this.commits = commits;
	}


	public int getTotalCommitsCount() {
		return totalCommitsCount;
	}


	public void setTotalCommitsCount(int totalCommitsCount) {
		this.totalCommitsCount = totalCommitsCount;
	}
	
	
	
}
