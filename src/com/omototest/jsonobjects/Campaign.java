/**
 * 
 */
package com.omototest.jsonobjects;

/**
 * @author Atrijit
 *
 */
public class Campaign {
private Long campaignid;
private String campaignname;
private String campaigndescription;
private Long score;
private Long respondents;
private String type;


public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCampaigndescription() {
	return campaigndescription;
}
public void setCampaigndescription(String campaigndescription) {
	this.campaigndescription = campaigndescription;
}
public Long getCampaignid() {
	return campaignid;
}
public void setCampaignid(Long campaignid) {
	this.campaignid = campaignid;
}
public String getCampaignname() {
	return campaignname;
}
public void setCampaignname(String campaignname) {
	this.campaignname = campaignname;
}
public Long getRespondents() {
	return respondents;
}
public void setRespondents(Long respondents) {
	this.respondents = respondents;
}
public Long getScore() {
	return score;
}
public void setScore(Long score) {
	this.score = score;
}

}
