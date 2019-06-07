package com.everis.restful.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity(name = "Push")
@Table(name = "push")
@Component
public class PushEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String objectKind;
	private String before;
	private String after;
	private String ref;
	private String checkoutSha;
	private int userId;
	private String userName;
	private String userUsername;
	private String userEmail;
	private String userAvatar;
	private int totalCommitsCount;
	
	@OneToMany(mappedBy = "push")
	@JsonManagedReference
	private List<CommitEntity> commits = new ArrayList<>();
	
	
    public PushEntity(){}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



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



	public List<CommitEntity> getCommits() {
		return commits;
	}



	public void setCommits(List<CommitEntity> commits) {
		this.commits = commits;
	}



	public int getTotalCommitsCount() {
		return totalCommitsCount;
	}



	public void setTotalCommitsCount(int totalCommitsCount) {
		this.totalCommitsCount = totalCommitsCount;
	}

	
    
}
