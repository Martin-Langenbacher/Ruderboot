import java.util.ArrayList;

public abstract class Boot implements Comparable<Boot> {

	// attributes
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
	private boolean fehlstart;
	private boolean zwischenspurt;
	private boolean endspurt;
	private boolean leistungsEinbruch;

	// constructor
	public Boot(int number, String bootName, int leistungBoot, String backBoardRuderVorn, String backBoardRuderHinten,
			String bootMitte, String steuerBoardRuderVorn, String steuerBoardRuderHinten) {
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
		this.fehlstart = false;
		this.zwischenspurt = false;
		this.endspurt = false;
		this.leistungsEinbruch = false;
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
	
	public boolean isFehlstart() {
		return fehlstart;
	}

	public void setFehlstart(boolean fehlstart) {
		this.fehlstart = fehlstart;
	}

	public boolean isZwischenspurt() {
		return zwischenspurt;
	}

	public void setZwischenspurt(boolean zwischenspurt) {
		this.zwischenspurt = zwischenspurt;
	}

	public boolean isEndspurt() {
		return endspurt;
	}

	public void setEndspurt(boolean endspurt) {
		this.endspurt = endspurt;
	}

	public boolean isLeistungsEinbruch() {
		return leistungsEinbruch;
	}

	public void setLeistungsEinbruch(boolean leistungsEinbruch) {
		this.leistungsEinbruch = leistungsEinbruch;
	}

	public int getBahnNummer() {
		return bahnNummer;
	}

	public void setBackBoardRuderVorn(String backBoardRuderVorn) {
		this.backBoardRuderVorn = backBoardRuderVorn;
	}

	public void setBackBoardRuderHinten(String backBoardRuderHinten) {
		this.backBoardRuderHinten = backBoardRuderHinten;
	}

	public void setBootMitte(String bootMitte) {
		this.bootMitte = bootMitte;
	}

	public void setSteuerBoardRuderVorn(String steuerBoardRuderVorn) {
		this.steuerBoardRuderVorn = steuerBoardRuderVorn;
	}

	public void setSteuerBoardRuderHinten(String steuerBoardRuderHinten) {
		this.steuerBoardRuderHinten = steuerBoardRuderHinten;
	}

	public void setLengthOfBoot(int lengthOfBoot) {
		this.lengthOfBoot = lengthOfBoot;
	}
	
	
	
	
	

	// =======================================================================
	public void bootEinsetzen(Rennstrecke rennstrecke) {
		String boatAndTrackStringB = "";
		String boatAndTrackStringM = "";
		String boatAndTrackStringS = "";
		String empty = " ";

		boatAndTrackStringM = " |" + empty.repeat((this.xPos - 1) - this.lengthOfBoot) + this.getBootMitte()
				+ empty.repeat(rennstrecke.getLengthRaceTrack() - (this.getxPos()) + 1) + "|";
		if (this.isRuderVorn()) {
			boatAndTrackStringB = " |" + empty.repeat((this.xPos - 1) - this.lengthOfBoot)
					+ this.getBackBoardRuderVorn()
					+ empty.repeat(rennstrecke.getLengthRaceTrack() - (this.getxPos()) + 1) + "|";
			boatAndTrackStringS = " |" + empty.repeat((this.xPos - 1) - this.lengthOfBoot)
					+ this.getSteuerBoardRuderVorn()
					+ empty.repeat(rennstrecke.getLengthRaceTrack() - (this.getxPos()) + 1) + "|";
		} else {
			boatAndTrackStringB = " |" + empty.repeat((this.xPos - 1) - this.lengthOfBoot)
					+ this.getBackBoardRuderHinten()
					+ empty.repeat(rennstrecke.getLengthRaceTrack() - (this.getxPos()) + 1) + "|";
			boatAndTrackStringS = " |" + empty.repeat((this.xPos - 1) - this.lengthOfBoot)
					+ this.getSteuerBoardRuderHinten()
					+ empty.repeat(rennstrecke.getLengthRaceTrack() - (this.getxPos()) + 1) + "|";
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

			// ascending order
			// return this.leistungBoot - compareQuantity;

			// descending order
			return comparePosition - this.leistungBoot;
		} else {

			int compareBahnen = ((Boot) compareBoot).getbahnNummer();

			// ascending order;-)");
			return this.bahnNummer - compareBahnen;

			// descending order
			// return comparePosition - this.leistungBoot;
		}

	}

//================================================================================
	public double luckFaktor(int lengthOfRacingField) {
		
		double variableFehlstart;
		double variableLeistungseinbruch;
		double variableZwischenspurt;
		double variableEndspurt;
		
		int x1 = (int) (0.30 * lengthOfRacingField);
		int x2 = (int) (0.75 * lengthOfRacingField);
		int x3 = (int) (0.80 * lengthOfRacingField);
		
		variableFehlstart = 1.0;
		variableLeistungseinbruch = 1.0;
		variableZwischenspurt = 1.0;
		variableEndspurt = 1.0;
			
		
		if (this.fehlstart && this.getxPos() <= this.getLengthOfBoot() + 2) {
			variableFehlstart = 0.5;
		}
		
		if (this.leistungsEinbruch && this.getxPos() > x2 && this.getxPos() < x3) {
			variableLeistungseinbruch = 0.8;
		}
		
		if (this.zwischenspurt && this.getxPos() > x1 && this.getxPos() < x2-1) {
			variableZwischenspurt = 1.1;
		}
		
		if (this.endspurt && this.getxPos() > x3 && this.getxPos() < lengthOfRacingField) {
			variableEndspurt = 1.2;
		}

		return variableFehlstart * variableLeistungseinbruch * variableZwischenspurt * variableEndspurt;
	}
	
	
	
}
