
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



