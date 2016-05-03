package com.omototest.jsonobjects;

import java.util.Map;

public class TabCampaignListJson {
	private Long campaignid;
	private String campaignname;
	private String campaigndescription;
	private Long score;
	private Long respondents;
	private String type;
	private Map scoreMap;
	private Map responses;
	
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
	public String getCampaigndescription() {
		return campaigndescription;
	}
	public void setCampaigndescription(String campaigndescription) {
		this.campaigndescription = campaigndescription;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public Long getRespondents() {
		return respondents;
	}
	public void setRespondents(Long respondents) {
		this.respondents = respondents;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Map getScoreMap() {
		return scoreMap;
	}
	public void setScoreMap(Map scoreMap) {
		this.scoreMap = scoreMap;
	}
	public Map getResponses() {
		return responses;
	}
	public void setResponses(Map responses) {
		this.responses = responses;
	}
}
