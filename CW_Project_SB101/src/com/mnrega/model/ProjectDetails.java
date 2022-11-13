package com.mnrega.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectDetails {
	
	private int projId;
	private String pname ;
	private String startingDate;
	private String completionDate;
	private int gmpId;
	
	public ProjectDetails(int projId, String pname, String startingDate, String completionDate) {
		super();
		this.projId = projId;
		this.pname = pname;
		this.startingDate = startingDate;
		this.completionDate = completionDate;
		
//		l1.add("projId=\" + projId + \", pname=\" + pname + \", startingDate=\" + startingDate\r\n"
//				+ "				+ \", completionDate=\" + completionDate + \", gmpId=\" + gmpId + \"");
	}

	public ProjectDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProjectDetails [projId=" + projId + ", pname=" + pname + ", startingDate=" + startingDate
				+ ", completionDate=" + completionDate + ", gmpId=" + gmpId + "]";
	}
	
	

}
