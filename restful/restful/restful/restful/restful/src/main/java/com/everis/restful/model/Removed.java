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

@Table(name = "TB_REMOVED")
@Entity
public class Removed{
	
	@JsonProperty("removed")
	private String removed;
	private Timestamp dtIncl;
	
	@Id//
	@Column(name = "removed_id")//
	@GeneratedValue(strategy = GenerationType.IDENTITY)//
	private Long removedId;    //
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commit_id",foreignKey =@ForeignKey(name ="FK_RemovedCommit"))
	private Commit commit;
	
	
	public Removed(){}


	public String getRemoved() {
		return removed;
	}


	public void setRemoved(String removed) {
		this.removed = removed;
	}


	public Long getRemovedId() {
		return removedId;
	}


	public void setRemovedId(Long removedId) {
		this.removedId = removedId;
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
