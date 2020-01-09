import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Wettrennen {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int amountOfBoats = 0;
		int lengthOfRacingField = 100;
		int leistungForBoat;
		int amountOfRuderer = 1; // hier können 2 (Doppelzweier) oder 4 (Vierer) stehen
		int zaehler = 0;
		String eingabe;
		//int blz = 0;
		
		/*
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		
		int kontoNr = 0;
		int zaehler = 0;
		String laenderCode = "";
		String ergebnisIban;
		
		
		*/
		
		
		// Anzahl der Ruderboote.
		while (zaehler == 0) {

			try {
				System.out.println("Bitte geben Sie die Zahl der Ruderboote ein:\n");
				eingabe = br.readLine();
				amountOfBoats = Integer.parseInt(eingabe);
			}

			catch (NumberFormatException ausnahme) {
				System.out.println("Bitte eine Zahl eingeben!");
				continue;
			}
			zaehler++;

		}
		
		
		// Ruderer:
				while (zaehler == 1) {

					try {
						System.out.println("Geben Sie die Zahl der Ruderer ein (1, 2 oder 4):");
						eingabe = br.readLine();
						amountOfRuderer = Integer.parseInt(eingabe);
					}

					catch (NumberFormatException ausnahme) {
						System.out.println("Bitte eine Zahl eingeben!");
						continue;
					}
					zaehler++;
				}
				
				if (amountOfRuderer != 1 || amountOfRuderer != 2 || amountOfRuderer != 4) {
					amountOfRuderer = 4;
				}
		
		
		
		
		
				
		// erstelle Boote
		ArrayList<Boot> boote = new ArrayList<>();
		for (int i = 0; i < amountOfBoats; i++) {
			
			leistungForBoat = 0;
			//erstelle Leistung für das Boot, zufällig, pro Ruderer zwischen 400 und 500 Watt
			for (int j = 0; j < amountOfRuderer; j++) {
				
				int randomWatt = (int)(Math.random() * 100 + 400);
				//System.out.println(randomWatt);
				leistungForBoat = leistungForBoat + randomWatt;
			}
			//System.out.println("Summe: " +leistungForBoat);
			
			switch(amountOfRuderer) {
			case 1:
				boote.add(new Einer(i, leistungForBoat));
				break;
			case 2:
				boote.add(new Doppelzweier(i, leistungForBoat));
				break;
			case 4:
				boote.add(new Vierer(i, leistungForBoat));
				break;
			default:
				System.out.println("Leider die falsche Anzahl an Ruderer im Programm!");
				break;
			}
		}
		
		
		// erstelle Rennstrecke
		ArrayList<Rennstrecke> rennstrecke1 = new ArrayList<>();
		for (int i = 0; i < amountOfBoats; i++) {
			rennstrecke1.add(new Rennstrecke(amountOfBoats, lengthOfRacingField));
		}
		
		// erstelle RennstreckeString
		for (int i = 0; i < amountOfBoats; i++) {
			rennstrecke1.get(i).rennstreckeErstellen();
			
			// Startposition Boot:
			boote.get(i).setxPos(boote.get(i).getLengthOfBoot()+1);
			boote.get(i).setyPos(boote.get(i).getyPos());
			
			// Boote in Rennstrecke einsetzen
			boote.get(i).bootEinsetzen(rennstrecke1.get(i));
			
		}
			
		
		// Zeige Rennstrecke
		int k = 0;
		boolean ende = false;
		
		do {
			k++;
			System.out.println("k: " +k);
			System.out.println(" ");
			System.out.println(" ");
			
			for (int i = 0; i < amountOfBoats; i++) {
				if (i == 0) {
					System.out.println(rennstrecke1.get(i).getRandStringBahn());
				}
				System.out.println(rennstrecke1.get(i).getBackboardWater());
				System.out.println(rennstrecke1.get(i).getMiddleStringBoat());
				System.out.println(rennstrecke1.get(i).getStarboardWater());
				if (i == amountOfBoats - 1) {
					System.out.println(rennstrecke1.get(i).getRandStringBahn());
				} else {
					System.out.println(rennstrecke1.get(i).getRandStringMiddle());
				}	
			}
			// neue Position von Booten
			// x+1
			for (int j = 0; j < amountOfBoats; j++) {
				
				double leistungBoot = boote.get(j).getLeistungBoot();
				double sqrt = Math.sqrt(leistungBoot)/20; //Leistung umgerechnet in Strecke (pro Schritt)
				boote.get(j).setStreckeMade(sqrt+boote.get(j).getStreckeMade());
				int streckeGesamt = (int) boote.get(j).getStreckeMade();
				
				/*
				System.out.println(boote.get(j).getStreckeMade());
				System.out.println(boote.get(j).getLengthOfBoot() + " Länge des Bootes...");
				System.out.println(leistungBoot);
				System.out.println(sqrt);
				System.out.println(streckeGesamt);
				System.out.println("x-Pos: " + boote.get(j).getxPos());
				*/
				
				boote.get(j).setxPos(boote.get(j).getxPos()+(streckeGesamt - (boote.get(j).getxPos()-boote.get(j).getLengthOfBoot())));
				boote.get(j).bootEinsetzen(rennstrecke1.get(j));
				//System.out.println("x-Pos: " + boote.get(j).getxPos());
				//System.out.println("Länge Boot: " + boote.get(j).getLengthOfBoot());
				//boote.get(j).bootEinsetzen(rennstrecke1.get(j));
				
				if (boote.get(j).getxPos() == lengthOfRacingField+0) {
					boote.get(j).setWinner(true);
					ende = true;
				}				
			}
			
			//slowing down time...
			Thread.sleep(400, 0);
			
			
			
			
		} while (!ende);
		//} while (k<lengthOfRacingField-(boote.get(1).getLengthOfBoot()));
		
		
		
		//finischer Bild
		System.out.println("k: THE END!");
		System.out.println(" ");
		System.out.println(" ");
		for (int i = 0; i < amountOfBoats; i++) {
			if (i == 0) {
				System.out.println(rennstrecke1.get(i).getRandStringBahn());
			}
			System.out.println(rennstrecke1.get(i).getBackboardWater());
			
			//boote.get(i).setWinner(true);
			if (boote.get(i).isWinner()) {
				System.out.println(rennstrecke1.get(i).getMiddleStringBoat() + boote.get(i).getStreckeMade() + "  --> Winner !!!");
			} else {
				System.out.println(rennstrecke1.get(i).getMiddleStringBoat() + boote.get(i).getStreckeMade());
			}
			System.out.println(rennstrecke1.get(i).getStarboardWater());
			if (i == amountOfBoats - 1) {
				System.out.println(rennstrecke1.get(i).getRandStringBahn());
			} else {
				System.out.println(rennstrecke1.get(i).getRandStringMiddle());
			}	
		}
		
	
	
		
		
		/*
		// Zeige Aquarium:
				
				int k = 0;
				
				do {
					k++;
					//System.out.println("k: " +k);
					System.out.println(" ");
					System.out.println(" ");
					System.out.println(" ");
					
					//Zeige Aquarium --> Strings...
					for (int i = aquariumHeight; i >= 0; i--) {
						System.out.println(myFirstAquarium.get(i).getAquariumString());
					}
					
					
					//Hier baue ich.....
					for (int i = 0; i < numberOfFishes; i++) {
						
						//System.out.println(fische.get(i).getxPos());
						
						if (fische.get(i).getxPos() < aquariumLength - fische.get(i).getLengthOfFish() && fische.get(i).isDirectionRight()) {
							fische.get(i).setxPos(fische.get(i).getxPos()+1);
						} else if (fische.get(i).getxPos() > 1 && !(fische.get(i).isDirectionRight())){
							fische.get(i).setxPos(fische.get(i).getxPos()-1);
						} else {
							fische.get(i).setDirectionRight(!fische.get(i).isDirectionRight());
						}
					}
						
						
						for (int i = 0; i < numberOfFishes; i++) {
							fische.get(i).fillAquarium(myFirstAquarium.get(i+1));
						}
						
						
						//fische.get(i).setxPos(fische.get(i).getxPos()+1);
						//fische.get(i).setxPos(i);
						//System.out.println(fische.get(i).getxPos());
						//fische.get(i).fishSwim2(myFirstAquarium);
						//fische.get(i).setxPos(random_int);
						
						//fische.get(i).fishSwim(myFirstAquarium.get(i+1));
					
					
					
					
					
					//Hier ist das Ende von bauen...
					
					
					
					
					
					
					
					
					
					//workingFish.fishSwim(myFirstAquarium);
					
					// fish up or down ?
					//workingFish.fishUpOrDown(myFirstAquarium);
					
					
					
					
					//slowing down time...
					Thread.sleep(100, 0);
					
				} while (k < 1500);
				
				
		*/
		
		
	}

}
