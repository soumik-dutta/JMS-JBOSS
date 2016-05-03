/**
 * 
 */
package com.omototest.jsonobjects;

import java.util.List;

/**
 * @author Atrijit
 *
 */
public class ReportJson {
private List datalist;
private List filters;
private List segments;

public List getDatalist() {
	return datalist;
}
public void setDatalist(List datalist) {
	this.datalist = datalist;
}
public List getFilters() {
	return filters;
}
public void setFilters(List filters) {
	this.filters = filters;
}
public List getSegments() {
	return segments;
}
public void setSegments(List segments) {
	this.segments = segments;
}

}
