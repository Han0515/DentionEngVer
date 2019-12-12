package com.pccu.detentionmtversion;

import java.util.ArrayList;
import java.util.Iterator;

public class IntelligenceCenter {

	Object lock = new Object();
	
	private static ArrayList<Events> 	events_list;
	private static Iterator<Events> 	it;
	
	public  IntelligenceCenter() {
		// TODO Auto-generated constructor stub
		
		events_list = new ArrayList<Events>();
	}

	public void dequeuEvent(IntelligenceOfficer officer) {
		
		if(officer.getAttribute().contains("Monitor")) {		
			synchronized (lock) {
				if (events_list.isEmpty() == false) {
					it = events_list.iterator();
					if(it.hasNext()) {
						Events e = it.next();
						System.out.println(	" Scene: " + e.SceneInstanceName + 
											" Events: " + e.EventDescription + 
											" Informer: " + e.Informer);
						it.remove();
					}
				}
			}
		} else {
			System.out.println("Permission Denied !");
		}
	}

	public void inqueueEvent(Events e) {
		// TODO Auto-generated method stub
		
		synchronized (lock) {
			events_list.add(e);
		}
	}
}
