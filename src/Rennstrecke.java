
public class Rennstrecke {
	
	//attributes
	private int bahnen;
	private int lengthRaceTrack;
	private String randStringMiddle;
	private String backboardWater;
	private String middleStringBoat;
	private String starboardWater;
	private String randStringBahn;
	
	
	//constructor
		public Rennstrecke(int bahnen, int lengthRaceTrack) {
			this.bahnen = bahnen;
			this.lengthRaceTrack = lengthRaceTrack;
			this.randStringMiddle = " ";
			this.backboardWater = " ";
			this.middleStringBoat = " ";
			this.starboardWater = " ";
			this.randStringBahn = " ";
		}
		
		
		
		//getters and setters
		public int getBahnen() {
			return bahnen;
		}

		public void setBahnen(int bahnen) {
			this.bahnen = bahnen;
		}

		public int getLengthRaceTrack() {
			return lengthRaceTrack;
		}

		public void setLengthRaceTrack(int lengthRaceTrack) {
			this.lengthRaceTrack = lengthRaceTrack;
		}

		public String getRandStringMiddle() {
			return randStringMiddle;
		}

		public void setRandStringMiddle(String randStringMiddle) {
			this.randStringMiddle = randStringMiddle;
		}

		public String getBackboardWater() {
			return backboardWater;
		}

		public void setBackboardWater(String backboardWater) {
			this.backboardWater = backboardWater;
		}

		public String getMiddleStringBoat() {
			return middleStringBoat;
		}

		public void setMiddleStringBoat(String middleStringBoat) {
			this.middleStringBoat = middleStringBoat;
		}

		public String getStarboardWater() {
			return starboardWater;
		}

		public void setStarboardWater(String starboardWater) {
			this.starboardWater = starboardWater;
		}

		public String getRandStringBahn() {
			return randStringBahn;
		}

		public void setRandStringBahn(String randStringBahn) {
			this.randStringBahn = randStringBahn;
		}

		
//=================================================================================0
		//Methode: Erstellen der Rennstrecke ==> die Strings
		void rennstreckeErstellen() {
			String randDoppel = "=";
			String begrenzungPlus = "+";
			String randEinfach = "-";
			String vornUndHinten = "|";
			String empty = " ";
			
			setRandStringBahn(randDoppel + begrenzungPlus + randDoppel.repeat(this.getLengthRaceTrack()) + begrenzungPlus + randDoppel);
			setBackboardWater(empty + vornUndHinten + empty.repeat(this.getLengthRaceTrack()) + vornUndHinten + empty);
			setMiddleStringBoat(empty + vornUndHinten + empty.repeat(this.getLengthRaceTrack()) + vornUndHinten + empty);
			setStarboardWater(empty + vornUndHinten + empty.repeat(this.getLengthRaceTrack()) + vornUndHinten + empty);
			setRandStringMiddle(randEinfach + begrenzungPlus + randEinfach.repeat(this.getLengthRaceTrack()) + begrenzungPlus + randEinfach);
			
			/*
			0:===+=====================================+====
			1:   |   \                                 |
			2:   |<--o-->                              |
			3:   |   /                                 |
			4:  -+-------------------------------------+--
			5:   |   \                                 |
			6:   |<--o-->                              |
			7:   |   /                                 |
			8:  -+-------------------------------------+--
			9:   |   \                                 |
			10   |<--o-->                              |
			11   |   /                                 |
			12===+=====================================+====
			*/
			
		}
	
		
}





/*
	

	
	//Methode: Zeige Aquarium:
	void zeigeAquarium() {
		System.out.println("Test: Hier bin ich in der Methode Zeige Aquarium! ");
		
		int m = getHeight();
		System.out.println(getHeight());
		do {
			m--;

			System.out.println(this.nWalls);
			
		} while (m>0);
		System.out.println(this.oneBottom);
				
	  }
	
	
	
	
	
	
	
	//Methode erstellen: --> Zeige Aquarium
			void showAquarium(ArrayList<Fisch> fische) {
				String zeile = "";
				String corner = "+";
				String bottom = "-";
				String wall = "|";
				String empty = " ";
				int fishPosX;
				int fishPosY;
				String beforeFish;
				String afterFish;
				String stringFish;
				
				int m = getHeight();
				do {
					m--;

					fishPosX = fische.get(m).getxPos();
					fishPosY = fische.get(m).getyPos();
					/*System.out.println("X: " + fishPosX);
					System.out.println(">>> Start:========================================");
					System.out.println(m + "(m): fishPosY: " + fishPosY);
					//System.out.println("Fisch 3: " + fische.get(3).getName());
					System.out.println("Y0: " + fische.get(0).getyPos());
					System.out.println("Y1: " + fische.get(1).getyPos());
					System.out.println("Y2: " + fische.get(2).getyPos());
					System.out.println("Y3: " + fische.get(3).getyPos());
					System.out.println("Y4: " + fische.get(4).getyPos());
					System.out.println("Y5: " + fische.get(5).getyPos());
					System.out.println("Y6: " + fische.get(6).getyPos());
					System.out.println("Y7: " + fische.get(7).getyPos());
					
					
					
					/*
					System.out.println("Zähler m3: " + 3);
					System.out.println("========================================");
					
					System.out.println(fische.get(m).getName());
					System.out.println("Y: " + fishPosY);
					System.out.println("Zähler m: " + m);
					System.out.println("========================================Ende"); 
					
					beforeFish = empty.repeat(fishPosX);
						if (fische.get(m).isDirectionRight()) {
							stringFish = fische.get(m).getFishR();
						} else {
							stringFish = fische.get(m).getFishL();
						}
					afterFish = empty.repeat(this.getLength()-fische.get(m).getLengthOfFish()-fishPosX);
					
					zeile = wall + beforeFish + stringFish + afterFish + wall;
					
					System.out.println(zeile);
					
				} while (m>0);
				
				zeile = corner + bottom.repeat(this.getLength()) + corner;
				System.out.println(zeile);
				
				
				*/
			  



