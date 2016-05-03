/**
 * 
 */
package com.omototest.jsonobjects;

import java.util.List;
import java.util.Map;

/**
 * @author Atrijit
 *
 */
public class CampaignListJson {
private String devicename;
private Map scoreMap;
private Map responses;
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
public String getDevicename() {
	return devicename;
}
public void setDevicename(String devicename) {
	this.devicename = devicename;
}

public List getCampaignlist() {
	return campaignlist;
}
public void setCampaignlist(List campaignlist) {
	this.campaignlist = campaignlist;
}

private List campaignlist;
}
