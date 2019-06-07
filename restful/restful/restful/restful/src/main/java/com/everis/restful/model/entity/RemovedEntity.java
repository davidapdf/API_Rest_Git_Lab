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

@Entity(name = "Removed")
@Table(name = "removed")
public class RemovedEntity {
	
	@Id//
	@Column(name = "removed_id")//
	@GeneratedValue(strategy = GenerationType.IDENTITY)//
	private Long removedId; //
	private String removed;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commit_id")
	@JsonBackReference
	private CommitEntity commit;
	
	public RemovedEntity() {}

	public Long getRemovedId() {
		return removedId;
	}

	public void setRemovedId(Long removedId) {
		this.removedId = removedId;
	}

	public String getRemoved() {
		return removed;
	}

	public void setRemoved(String removed) {
		this.removed = removed;
	}

	public CommitEntity getCommit() {
		return commit;
	}

	public void setCommit(CommitEntity commit) {
		this.commit = commit;
	}
	
	
	
	
	
}
