/**
 * 
 */
package com.omototest.jsonobjects;

/**
 * @author Atrijit
 *
 */
public class IncomingCampaignRequest {
private String type;
private int[] campaignids;



public int[] getCampaignids() {
	return campaignids;
}

public void setCampaignids(int[] campaignids) {
	this.campaignids = campaignids;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}
}
