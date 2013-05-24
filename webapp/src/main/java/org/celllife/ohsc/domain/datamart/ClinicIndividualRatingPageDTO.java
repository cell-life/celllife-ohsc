package org.celllife.ohsc.domain.datamart;

import java.io.Serializable;

/**
 * DTO containing a page of individual clinic ratings, in DataTables format.
 * 
 * See more information here: http://www.datatables.net/usage/server-side
 * And http://datatables.net/development/server-side/jsp
 */
public class ClinicIndividualRatingPageDTO implements Serializable {

	private static final long serialVersionUID = 1227805378326624665L;

	private String sEcho;
	
	private Integer iTotalRecords;
	
	private Integer iTotalDisplayRecords;
	
	private Object[][] aaData;

    public ClinicIndividualRatingPageDTO() {
    }

    public ClinicIndividualRatingPageDTO(String sEcho, Integer iTotalRecords, Integer iTotalDisplayRecords, Object[][] aaData) {
    	this.sEcho = sEcho;
    	this.iTotalRecords = iTotalRecords;
    	this.iTotalDisplayRecords = iTotalDisplayRecords;
    	this.aaData = aaData;
    }

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public Integer getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public Object[][] getAaData() {
		return aaData;
	}

	public void setAaData(Object[][] aaData) {
		this.aaData = aaData;
	}
}
