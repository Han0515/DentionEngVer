package com.pccu.detentionmtversion;

public class IntelligenceOfficer {

	private String officer_att 	= ""; 		// Monitor or Agent
	private String description 	= ""; 		// Informer Name, such as "Teacher In"
	
	public IntelligenceOfficer(String att, String desc) {
		// TODO Auto-generated constructor stub
		officer_att = att;
		description = desc;
	}
	
	public String getAttribute () {
		return officer_att;
	}

	public String getDescription () {
		return description;
	}
	
	public void sendEvent(Events e, IntelligenceCenter m) {
		m.inqueueEvent(e);
	}
	
}
