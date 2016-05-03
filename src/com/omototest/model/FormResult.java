/**
 * 
 */
package com.omototest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Atrijit
 *
 */
/*
 * CREATE TABLE OMOTO_TEST 
 */
@Entity
@Table(name="OMOTO_TEST", uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class FormResult {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "OMOTORESPONSE")
	private String omotoresponse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOmotoresponse() {
		return omotoresponse;
	}

	public void setOmotoresponse(String omotoresponse) {
		this.omotoresponse = omotoresponse;
	}
	
	
}
