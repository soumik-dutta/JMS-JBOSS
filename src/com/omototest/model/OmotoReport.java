/**
 * 
 */
package com.omototest.model;

import java.util.Date;

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
@Entity
@Table(name="OMOTO_REPORT", uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class OmotoReport {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CLIENTNAME")
	private String clientname;
	
	@Column(name = "CLIENTID")
	private Long clientid;
	
	@Column(name = "NPSSCORE")
	private Long npsscore;
	
	//new-Region
	@Column(name = "REGION")
	private String region;
	
	@Column(name = "CITY")
	private String city;
	
	/*@Column(name = "UNIT")
	private String unit;*/
	
	//new-Sevice Centre Name
	@Column(name = "SCNAME")
	private String scname;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	//new-Segments
	@Column(name = "SEGMENTS")
	private String segments;
	
	//NPS Benchmarking Campaign
	@Column(name = "CAMPAIGN")
	private String campaign;
	
	@Column(name = "CAMPAIGNID")
	private Long campaignid;
	
	//May 1, 2015 to May 20, 2015 - none on weekends, mondays and tuesdays. Most on wed, then dip on thu and fri.
	@Column(name = "RESPONSEDATE")
	private Date responsedate;
	
	@Column(name = "RESPONSEDATESTR")
	private String responsedatestr;

	public String getCampaign() {
		return campaign;
	}

	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}

	public Long getCampaignid() {
		return campaignid;
	}

	public void setCampaignid(Long campaignid) {
		this.campaignid = campaignid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getClientid() {
		return clientid;
	}

	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNpsscore() {
		return npsscore;
	}

	public void setNpsscore(Long npsscore) {
		this.npsscore = npsscore;
	}

	public Date getResponsedate() {
		return responsedate;
	}

	public void setResponsedate(Date responsedate) {
		this.responsedate = responsedate;
	}


	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getScname() {
		return scname;
	}

	public void setScname(String scname) {
		this.scname = scname;
	}

	public String getSegments() {
		return segments;
	}

	public void setSegments(String segments) {
		this.segments = segments;
	}

	public String getResponsedatestr() {
		return responsedatestr;
	}

	public void setResponsedatestr(String responsedatestr) {
		this.responsedatestr = responsedatestr;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
