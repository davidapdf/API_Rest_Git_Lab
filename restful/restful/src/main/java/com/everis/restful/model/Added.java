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

@Table(name = "TB_ADDED")
@Entity
public class Added{
    
	@JsonProperty("added")
	private String added;
	
	@Id//
	@Column(name = "added_id")//
	@GeneratedValue(strategy = GenerationType.IDENTITY)//
	private Long addedId;    //
	private Timestamp dtIncl;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commit_id",foreignKey =@ForeignKey(name ="FK_CommitAdded"))
	private Commit commit;
	
	
	public Added(){}


	public String getAdded() {
		return added;
	}


	public void setAdded(String added) {
		this.added = added;
	}


	public Long getAddedId() {
		return addedId;
	}


	public void setAddedId(Long addedId) {
		this.addedId = addedId;
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
