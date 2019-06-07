package com.everis.restful.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "Commit")
@Table(name = "commit")
@Component
public class CommitEntity {
    
	@Id//
	@Column(name = "commit_id")//
	@GeneratedValue(strategy = GenerationType.IDENTITY)//
	private Long commitId; //
	
	//@Id
	@Column(name = "id")
	private String id;
	@Column(name = "message")
    private String message;
	@Column(name = "timestamp")
    private String timestamp; 
	@Column(name = "url")
	private String url;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "push_id")
	@JsonBackReference
	private PushEntity push;
	
	@OneToMany(mappedBy = "commit")
	@JsonManagedReference
	private List<AddedEntity> addeds = new ArrayList<>();
	
	@OneToMany(mappedBy = "commit")
	@JsonManagedReference
	private List<ModifiedEntity> modifieds = new ArrayList<>();
	
	@OneToMany(mappedBy = "commit")
	@JsonManagedReference
	private List<RemovedEntity> removeds = new ArrayList<>();
	
	public CommitEntity(){
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PushEntity getPush() {
		return push;
	}

	public void setPush(PushEntity push) {
		this.push = push;
	}

	public Long getCommitId() {
		return commitId;
	}

	public void setCommitId(Long commitId) {
		this.commitId = commitId;
	}

	public List<AddedEntity> getAddeds() {
		return addeds;
	}

	public void setAddeds(List<AddedEntity> addeds) {
		this.addeds = addeds;
	}

	public List<ModifiedEntity> getModifieds() {
		return modifieds;
	}

	public void setModifieds(List<ModifiedEntity> modifieds) {
		this.modifieds = modifieds;
	}

	public List<RemovedEntity> getRemoveds() {
		return removeds;
	}

	public void setRemoveds(List<RemovedEntity> removeds) {
		this.removeds = removeds;
	}
	
}
