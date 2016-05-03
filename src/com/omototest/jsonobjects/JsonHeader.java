/**
 * 
 */
package com.omototest.jsonobjects;

/**
 * @author Atrijit
 *
 */
public class JsonHeader {
private String deviceid;
private Long processid;

public Long getProcessid() {
	return processid;
}

public void setProcessid(Long processid) {
	this.processid = processid;
}

public String getDeviceid() {
	return deviceid;
}

public void setDeviceid(String deviceid) {
	this.deviceid = deviceid;
}

}
