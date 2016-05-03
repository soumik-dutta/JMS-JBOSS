/**
 * 
 */
package com.omototest.jsonobjects;

/**
 * @author Atrijit
 *
 */
public class GetFormResponse {
	private String clientid;
	private String formname;
	private Integer displaytype;
	private Integer formtype;
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public Integer getDisplaytype() {
		return displaytype;
	}
	public void setDisplaytype(Integer displaytype) {
		this.displaytype = displaytype;
	}
	public String getFormname() {
		return formname;
	}
	public void setFormname(String formname) {
		this.formname = formname;
	}
	public Integer getFormtype() {
		return formtype;
	}
	public void setFormtype(Integer formtype) {
		this.formtype = formtype;
	}
}
