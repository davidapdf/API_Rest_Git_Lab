package com.everis.restful.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "Alert")
@Table(name = "alert")
public class Alert {
       
	   @Id//
	   @Column(name = "alert_id")//
	   @GeneratedValue(strategy = GenerationType.IDENTITY)//
	   private Long id;
	   
	   private String nome;

	   @OneToMany(mappedBy = "alert")
	   @JsonManagedReference
	   @JsonProperty("Detail")
	   @Embedded
	   private List<Detail> details = new ArrayList<>();
	   
	   public Alert() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}
	   
	   
}
