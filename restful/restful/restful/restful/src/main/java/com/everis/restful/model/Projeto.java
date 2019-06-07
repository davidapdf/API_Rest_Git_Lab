package com.everis.restful.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "projeto")
@Entity
@Embeddable
public class Projeto {
	@Id//
	@Column(name = "projeto_id")//
	private Long projetoId;    //
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
	private Alert alert;
	
	@JsonProperty("description")
	private String description;
}
