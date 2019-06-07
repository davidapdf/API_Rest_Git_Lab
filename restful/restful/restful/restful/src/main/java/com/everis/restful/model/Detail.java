package com.everis.restful.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;


@Table(name = "detail")
@Entity
@Embeddable
public class Detail {
	
	@Id//
	@Column(name = "commit_id")//
	@GeneratedValue(strategy = GenerationType.IDENTITY)//
	private Long detailId;    //
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alert_id")
	@JsonBackReference
	private Alert alert;
	
	@JsonProperty("description")
	private String description;
	
	
	public Detail() {}


	public Alert getAlert() {
		return alert;
	}


	public void setAlert(Alert alert) {
		this.alert = alert;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
