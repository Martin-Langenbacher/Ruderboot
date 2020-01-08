import java.util.ArrayList;

public class Wettrennen {

	public static void main(String[] args) {
		
		int amountOfBoats = 5;
		int lengthOfRacingField = 60;
		int leistungForBoat;
		int amountOfRuderer = 4; // hier können 2 (Doppelzweier) oder 4 (Vierer) stehen
		
				
		
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
			case 2:
				boote.add(new Doppelzweier(i, leistungForBoat));
				break;
			case 4:
				boote.add(new Doppelzweier(i, leistungForBoat));
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
		
		//
		for (int i = 0; i < amountOfBoats; i++) {
			rennstrecke1.get(i).rennstreckeErstellen();
			
		}
		
		
		// Zeige Rennstrecke
		int k = 0;
		
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
			
		} while (k<1);
		
	
	
		
		
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
