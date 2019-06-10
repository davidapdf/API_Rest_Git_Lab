package com.everis.restful.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "TB_MODIFIED")
@Entity
public class Modified{
	@JsonProperty("modified")
	private String modified;
	
	@Id//
	@Column(name = "modified_id")//
	@GeneratedValue(strategy = GenerationType.IDENTITY)//
	private Long modifiedId;    //
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commit_id",foreignKey =@ForeignKey(name ="FK_ModifiedCommit"))
	@JsonBackReference
	private Commit commit;
	private Timestamp dtIncl;
	
	public Modified(){}


	public String getModified() {
		return modified;
	}


	public void setModified(String modified) {
		this.modified = modified;
	}


	public Long getModifiedId() {
		return modifiedId;
	}


	public void setModifiedId(Long modifiedId) {
		this.modifiedId = modifiedId;
	}


	public Commit getCommit() {
		return commit;
	}


	public void setCommit(Commit commit) {
		this.commit = commit;
	}


	public Timestamp getDtIncl() {
		return dtIncl;
	}


	public void setDtIncl(Timestamp dtIncl) {
		this.dtIncl = dtIncl;
	}


	
}
