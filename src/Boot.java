
public abstract class Boot implements Comparable<Boot>{
	
	//attributes
	private int number;
	private String bootName;
	private int xPos;
	private int bahnNummer;
	private String backBoardRuderVorn;
	private String backBoardRuderHinten;
	private String bootMitte;
	private String steuerBoardRuderVorn;
	private String steuerBoardRuderHinten;
	private int lengthOfBoot;
	private int leistungBoot;
	private boolean ruderVorn;
	private boolean winner;
	private double streckeMade;
	private int position;
	private boolean sortierSchalter;

	
	
	
	
	// constructor
	public Boot(int number, String bootName, int leistungBoot,
			String backBoardRuderVorn,
			String backBoardRuderHinten,
			String bootMitte,
			String steuerBoardRuderVorn,
			String steuerBoardRuderHinten) {
		this.number = number;
		this.bootName = bootName;
		this.leistungBoot = leistungBoot;
		this.backBoardRuderVorn = backBoardRuderVorn;
		this.backBoardRuderHinten = backBoardRuderHinten;
		this.bootMitte = bootMitte;
		this.steuerBoardRuderVorn = steuerBoardRuderVorn;
		this.steuerBoardRuderHinten = steuerBoardRuderHinten;
		this.lengthOfBoot = bootMitte.length();
		this.ruderVorn = true;
		this.winner = false;
		this.streckeMade = 0.0;
		this.position = 0;
		this.bahnNummer = number + 1;
		this.sortierSchalter = false;
	}
	
	
	
	
	// getter and setter

	public int getNumber() {
		return number;
	}




	public void setNumber(int number) {
		this.number = number;
	}

	

	public String getBootName() {
		return bootName;
	}




	public void setBootName(String bootName) {
		this.bootName = bootName;
	}




	public int getxPos() {
		return xPos;
	}




	public void setxPos(int xPos) {
		this.xPos = xPos;
	}




	public int getbahnNummer() {
		return bahnNummer;
	}
	
	
	public void setBahnNummer(int bahnNummer) {
		this.bahnNummer = bahnNummer;
	}




	public String getBackBoardRuderVorn() {
		return backBoardRuderVorn;
	}




	public String getBackBoardRuderHinten() {
		return backBoardRuderHinten;
	}




	public String getBootMitte() {
		return bootMitte;
	}




	public String getSteuerBoardRuderVorn() {
		return steuerBoardRuderVorn;
	}




	public String getSteuerBoardRuderHinten() {
		return steuerBoardRuderHinten;
	}




	public int getLengthOfBoot() {
		return lengthOfBoot;
	}




	public int getLeistungBoot() {
		return leistungBoot;
	}




	public void setLeistungBoot(int leistungBoot) {
		this.leistungBoot = leistungBoot;
	}
	
	public boolean isRuderVorn() {
		return ruderVorn;
	}

	public void setRuderVorn(boolean ruderVorn) {
		this.ruderVorn = ruderVorn;
	}
	
	

	public boolean isWinner() {
		return winner;
	}



	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
	
	
	public double getStreckeMade() {
		return streckeMade;
	}


	public void setStreckeMade(double streckeMade) {
		this.streckeMade = streckeMade;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}


public boolean isSortierSchalter() {
		return sortierSchalter;
	}




	public void setSortierSchalter(boolean sortierSchalter) {
		this.sortierSchalter = sortierSchalter;
	}




	//=======================================================================
	public void bootEinsetzen(Rennstrecke rennstrecke) {
		String boatAndTrackStringB = "";
		String boatAndTrackStringM = "";
		String boatAndTrackStringS = "";
		String empty = " ";
		
		boatAndTrackStringM = " |" + empty.repeat((this.xPos-1) - this.lengthOfBoot) + this.getBootMitte() + empty.repeat(rennstrecke.getLengthRaceTrack() - (this.getxPos())+1) +"|";
		if (this.isRuderVorn()) {
			boatAndTrackStringB = " |" + empty.repeat((this.xPos-1) - this.lengthOfBoot) + this.getBackBoardRuderVorn() + empty.repeat(rennstrecke.getLengthRaceTrack() - (this.getxPos())+1) +"|";
			boatAndTrackStringS = " |" + empty.repeat((this.xPos-1) - this.lengthOfBoot) + this.getSteuerBoardRuderVorn() + empty.repeat(rennstrecke.getLengthRaceTrack() - (this.getxPos())+1) +"|";
		} else {
			boatAndTrackStringB = " |" + empty.repeat((this.xPos-1) - this.lengthOfBoot) + this.getBackBoardRuderHinten() + empty.repeat(rennstrecke.getLengthRaceTrack() - (this.getxPos())+1) +"|";
			boatAndTrackStringS = " |" + empty.repeat((this.xPos-1) - this.lengthOfBoot) + this.getSteuerBoardRuderHinten() + empty.repeat(rennstrecke.getLengthRaceTrack() - (this.getxPos())+1) +"|";
		}
		
				
		rennstrecke.setBackboardWater(boatAndTrackStringB);
		rennstrecke.setMiddleStringBoat(boatAndTrackStringM);
		rennstrecke.setStarboardWater(boatAndTrackStringS);
		
		setRuderVorn(!isRuderVorn());
				 
	}

	

//=======================================================================
	public int compareTo(Boot compareBoot) {
		
		if (this.sortierSchalter == false) {
			
			int comparePosition = ((Boot) compareBoot).getLeistungBoot();
			
			//ascending order
			//return this.leistungBoot - compareQuantity;
			
			//descending order
			return comparePosition - this.leistungBoot;
		} else {
			
			int compareBahnen = ((Boot) compareBoot).getbahnNummer();
			
			//ascending order;-)");
			return this.bahnNummer - compareBahnen;
			
			//descending order
			//return comparePosition - this.leistungBoot;
		}
		
	}



//================================================================================
	public double luckFaktor() {
	
		return 1.0;
		
	};
	

	
		
		
	
	
	
	

}


