package com.pccu.detentionmtversion;

public class GameStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IntelligenceCenter infoCenterA = new IntelligenceCenter();
		
		Scene sceneA = new Scene() {
			@Override
			public Events getEvent(int cnt) {
				// TODO Auto-generated method stub
				int event_types = 3; 
				Events e = new Events();
				switch (cnt % event_types) { 
					case 0:
						e.EventDescription = "喝茶";
						break;
					case 1:
						e.EventDescription = "吃飯";
						break;
					case 2:
						e.EventDescription = "看報紙";
						break;
				}
				return e;
			}
		};
		
		IntelligenceOfficer informerA 	= new IntelligenceOfficer("Agent", "抓耙子 A");
		SceneInstance sceneInstanceA 	= new SceneInstance("工友室", sceneA, informerA, infoCenterA);
		Thread seceneInstanceAThread 	= new Thread (sceneInstanceA);
		seceneInstanceAThread.start();
		
		
		Scene sceneB = new Scene() {
			@Override
			public Events getEvent(int cnt) {
				// TODO Auto-generated method stub
				int event_types = 3; 
				Events e = new Events();
				switch (cnt % event_types) { 
					case 0:
						e.EventDescription = "打情";
						break;
					case 1:
						e.EventDescription = "罵俏";
						break;
					case 2:
						e.EventDescription = "談戀愛";
						break;
				}
				return e;
			}
		};
		
		IntelligenceOfficer informerB 	= new IntelligenceOfficer("Agent", "抓耙子 B");
		SceneInstance sceneInstanceB 	= new SceneInstance("社團辦公室", sceneB, informerB, infoCenterA);
		Thread seceneInstanceBThread 	= new Thread (sceneInstanceB);
		seceneInstanceBThread.start();
		
		IntelligenceOfficer monitorA = new IntelligenceOfficer("Monitor", "教官");
		while (true) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			infoCenterA.dequeuEvent(monitorA);
		}
	
	}
}
