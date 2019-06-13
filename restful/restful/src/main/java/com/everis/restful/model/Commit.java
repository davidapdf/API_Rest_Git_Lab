package com.everis.restful.model;




import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "TB_COMMIT")
@Entity(name = "Commit")
@Embeddable
public class Commit {

	@JsonProperty("id")
	private String id;
	@JsonProperty("message")
    private String message;
	@JsonProperty("timestamp")
    private String timestamp; // "timestamp": "2011-12-12T14:27:31+02:00",
	@JsonProperty("url")
	private String url;       //"url": "http://example.com/mike/diaspora/commit/b6568db1bc1dcd7f8b4d5a946b0b91f9dacd7327",
	@Embedded
	@JsonProperty("author")
    private Author author;
	private Timestamp dtIncl;

	
	@Id
	@Column(name = "commit_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commitId;    
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "push_id",foreignKey =@ForeignKey(name ="FK_PushCommit"))
	@JsonBackReference
	private Push push;
    
	
	
	//@OneToMany(mappedBy = "commit")
	//@JsonManagedReference
    @JsonProperty("added")
	@Embedded
	private List<String> addeds = new ArrayList<String>();
	
    @OneToMany(mappedBy = "commit")
    @JsonIgnore
    private List<Added> added = new ArrayList<Added>(); 
    
    
    
    @JsonProperty("modified")
	@Embedded
	private List<String> modifieds = new ArrayList<String>();
	
    @OneToMany(mappedBy = "commit")
    @JsonIgnore
    private List<Modified> modified = new ArrayList<Modified>(); 
    
    
    
    @JsonProperty("removed")
	@Embedded
	private List<String> removeds = new ArrayList<String>();
	
    @OneToMany(mappedBy = "commit")
    @JsonIgnore
    private List<Removed> removed = new ArrayList<Removed>(); 
	
	public Commit() {}
	
	
	
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

	/*public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}*/
	
	public Long getCommitId() {
		return commitId;
	}
	
	public void setCommitId(Long commitId) {
		this.commitId = commitId;
	}
	
	public Push getPush() {
		return push;
	}
	
	public void setPush(Push push) {
		this.push = push;
	}



	public Author getAuthor() {
		return author;
	}



	public void setAuthor(Author author) {
		this.author = author;
	}



	public List<String> getAddeds() {
		return addeds;
	}



	public void setAddeds(List<String> addeds) {
		this.addeds = addeds;
	}



	public List<Added> getAdded() {
		return added;
	}



	public void setAdded(List<Added> added) {
		this.added = added;
	}



	public List<String> getModifieds() {
		return modifieds;
	}



	public void setModifieds(List<String> modifieds) {
		this.modifieds = modifieds;
	}



	public List<Modified> getModified() {
		return modified;
	}



	public void setModified(List<Modified> modified) {
		this.modified = modified;
	}



	public List<String> getRemoveds() {
		return removeds;
	}



	public void setRemoveds(List<String> removeds) {
		this.removeds = removeds;
	}



	public List<Removed> getRemoved() {
		return removed;
	}



	public void setRemoved(List<Removed> removed) {
		this.removed = removed;
	}



	public Timestamp getDtIncl() {
		return dtIncl;
	}



	public void setDtIncl(Timestamp dtIncl) {
		this.dtIncl = dtIncl;
	}






}
