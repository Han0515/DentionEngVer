package com.pccu.detentionmtversion;

public class SceneInstance implements Runnable {
	private String SceneInstanceName = "";
	private Scene scene;
	private IntelligenceOfficer informer;
	private IntelligenceCenter  monitor;  
	int events_cnt = 0;
	
	public SceneInstance(String n, Scene s, IntelligenceOfficer i, IntelligenceCenter m) {
		// TODO Auto-generated constructor stub
		SceneInstanceName = n;
		scene = s;
		informer = i;
		monitor = m;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			Events e = scene.getEvent(events_cnt++);
			e.SceneInstanceName = this.SceneInstanceName;
			e.Informer = this.informer.getDescription();
			informer.sendEvent(e, monitor);			
		}
	}	
}
