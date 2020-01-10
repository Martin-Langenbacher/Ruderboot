
public abstract class Boot {
	
	//attributes
	private int number;
	private int xPos;
	private int yPos;
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

	
	
	
	
	// constructor
	public Boot(int number, int leistungBoot,
			String backBoardRuderVorn,
			String backBoardRuderHinten,
			String bootMitte,
			String steuerBoardRuderVorn,
			String steuerBoardRuderHinten) {
		this.number = number;
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
	}
	
	
	
	
	// getter and setter

	public int getNumber() {
		return number;
	}




	public void setNumber(int number) {
		this.number = number;
	}




	public int getxPos() {
		return xPos;
	}




	public void setxPos(int xPos) {
		this.xPos = xPos;
	}




	public int getyPos() {
		return yPos;
	}




	public void setyPos(int yPos) {
		this.yPos = yPos;
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





	
	
	
	

}


