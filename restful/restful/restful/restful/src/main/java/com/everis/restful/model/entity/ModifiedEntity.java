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

@Entity(name = "Modified")
@Table(name = "modified")
public class ModifiedEntity {
	@Id//
	@Column(name = "modified_id")//
	@GeneratedValue(strategy = GenerationType.IDENTITY)//
	private Long modifiedId; //
	private String modified;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commit_id")
	@JsonBackReference
	private CommitEntity commit;
	
	public ModifiedEntity(){}
	
	public Long getModifiedId() {
		return modifiedId;
	}
	public void setModifiedId(Long modifiedId) {
		this.modifiedId = modifiedId;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public CommitEntity getCommit() {
		return commit;
	}
	public void setCommit(CommitEntity commit) {
		this.commit = commit;
	}
	
	
	
	
	
}
