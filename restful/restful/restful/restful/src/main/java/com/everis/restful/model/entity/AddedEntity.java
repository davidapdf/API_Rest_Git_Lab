package com.everis.restful.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "Added")
@Table(name = "added")
public class AddedEntity {

	@Id//
	@Column(name = "added_id")//
	@GeneratedValue(strategy = GenerationType.IDENTITY)//
	private Long addedId; //
	private String added;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commit_id")
	@JsonBackReference
	private CommitEntity commit;
	
	public AddedEntity(){}

	public Long getAddedId() {
		return addedId;
	}

	public void setAddedId(Long addedId) {
		this.addedId = addedId;
	}

	public String getAdded() {
		return added;
	}

	public void setAdded(String added) {
		this.added = added;
	}

	public CommitEntity getCommit() {
		return commit;
	}

	public void setCommit(CommitEntity commit) {
		this.commit = commit;
	}
	
	
	
}
