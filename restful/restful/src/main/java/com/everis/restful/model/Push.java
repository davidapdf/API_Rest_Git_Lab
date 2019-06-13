package com.everis.restful.model;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "Push")
@Table(name = "TB_PUSH")
public class Push {
     
	@Id//
	@Column(name = "push_id")//
	@GeneratedValue(strategy = GenerationType.IDENTITY)//
	private Long id;
	
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
	private Timestamp dtIncl;
	
	
	@JsonProperty("project")
	@Transient
	@JsonManagedReference 
	private Project project;
	
	@JsonProperty("repository")
	@Transient
	@JsonManagedReference 
	private Repository repository;
	
	
	@OneToMany(mappedBy = "push")
	@JsonManagedReference
    @JsonProperty("commits")
	private List<Commit> commits; 
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Commit> getCommits() {
		return commits;
	}

	public void setCommits(List<Commit> commits) {
		this.commits = commits;
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

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
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

	public Timestamp getDtIncl() {
		return dtIncl;
	}

	public void setDtIncl(Timestamp dtIncl) {
		this.dtIncl = dtIncl;
	}



	
}
