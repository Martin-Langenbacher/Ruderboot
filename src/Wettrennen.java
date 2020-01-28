import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Wettrennen {

	public static void main(String[] args) throws InterruptedException, IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int amountOfBoats = 0;
		int lengthOfRacingField = 100;
		int leistungForBoat;
		int amountOfRuderer = 1; // hier können 1er, 2er, 4er oder 8er stehen (neuere Version: Es wird
									// abgefragt)...
		int zaehler = 0;
		int bootNummerZaehler = 0;
		int k = 0; // auch ein Zähler
		int ausgleichsfaktor = 1; // damit das Programm nicht abstürzt!
		String eingabe;
		String bootName;
		double factorForSpeedOfBoat = 10.0;
		double laengsteDistanzImRennen = 0.0;

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
				System.out.println("Geben Sie die Zahl der Ruderer ein (1, 2, 4 oder 8):");
				eingabe = br.readLine();
				amountOfRuderer = Integer.parseInt(eingabe);
			}

			catch (NumberFormatException ausnahme) {
				System.out.println("Bitte eine Zahl eingeben!");
				continue;
			}
			zaehler++;
		}

		if ((amountOfRuderer != 1) && (amountOfRuderer != 2) && (amountOfRuderer != 4) && (amountOfRuderer != 8)) {
			amountOfRuderer = 4;
			System.out.println("Falsche Zahl eingegeben, darum ist die Anzahl der Ruderer auf " + amountOfRuderer
					+ " gesetzt worden.");
		}

		// erstelle Boote
		ArrayList<Boot> boote = new ArrayList<>();
		for (int i = 0; i < amountOfBoats; i++) {

			leistungForBoat = 0;
			// erstelle Leistung für das Boot, zufällig, pro Ruderer zwischen 400 und 500
			// Watt
			for (int j = 0; j < amountOfRuderer; j++) {

				int randomWatt = (int) (Math.random() * 100 + 400);
				leistungForBoat = leistungForBoat + randomWatt;
			}

			bootNummerZaehler = bootNummerZaehler + 1;

			switch (amountOfRuderer) {
			case 1:
				bootName = "Einer " + bootNummerZaehler;
				boote.add(new Einer(i, bootName, leistungForBoat));
				break;
			case 2:
				bootName = "Doppel " + bootNummerZaehler;
				boote.add(new Doppelzweier(i, bootName, leistungForBoat));
				break;
			case 4:
				bootName = "Vierer " + bootNummerZaehler;
				boote.add(new Vierer(i, bootName, leistungForBoat));
				break;
			case 8:
				bootName = "Achter " + bootNummerZaehler;
				boote.add(new Achter(i, bootName, leistungForBoat));
				break;

			default:
				System.out.println("Leider die falsche Anzahl an Ruderer im Programm!");
				break;
			}
		}

		// Werte zuordnen:
		for (int i = 0; i < amountOfBoats; i++) {

			int randomFehlstart = (int) (Math.random() * 2 + 1);
			if (randomFehlstart == 1) {
				boote.get(i).setFehlstart(true);
			}

			int randomLeistungsEinbruch = (int) (Math.random() * 2 + 1);
			if (randomLeistungsEinbruch == 1) {
				boote.get(i).setLeistungsEinbruch(true);
			}

			int randomZwischenspurt = (int) (Math.random() * 2 + 1);
			if (randomZwischenspurt == 1) {
				boote.get(i).setZwischenspurt(true);
			}

			int randomEndspurt = (int) (Math.random() * 2 + 1);
			if (randomEndspurt == 1 && randomLeistungsEinbruch == 2) {
				boote.get(i).setEndspurt(true);
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
			boote.get(i).setxPos(boote.get(i).getLengthOfBoot() + ausgleichsfaktor);
			boote.get(i).setBahnNummer(boote.get(i).getbahnNummer());

			// Boote in Rennstrecke einsetzen
			boote.get(i).bootEinsetzen(rennstrecke1.get(i));
		}

		
		factorForSpeedOfBoat = factorForSpeedOfBoat + 5 * amountOfRuderer; // damit alle Boote ungefähr gleich lange
																			// benötigen

		k = 6;
		// Start of the race
		do {
			k--;
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" Countdown: " + k);

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

			// slowing down time...
			Thread.sleep(1000, 0);

		} while (k > 0);

		
		
		// Zeige Rennstrecke
		k = 0;
		boolean ende = false;

		do {
			k++;
			String goString = ">";
			// System.out.println("k: " +k);
			System.out.println(" ");
			System.out.println(" ");
			if (k < 9) {
				System.out.println(" >" + goString.repeat(k / 2) + " GO! ");
				// System.out.println(" GO " +goString.repeat(k/2) +">");
			} else {
				System.out.println(" ");
			}

			// Print Bahn mit Boot
			for (int i = 0; i < amountOfBoats; i++) {
				if (i == 0) {
					System.out.println(rennstrecke1.get(i).getRandStringBahn());
				}
				System.out.println(rennstrecke1.get(i).getBackboardWater());

				// in der ersten Runde noch keine Position ausgeben (da vorher nicht mit
				// Set-Bestätigt...!
				if (k == 1) {
					System.out.println(rennstrecke1.get(i).getMiddleStringBoat());
				} else {
					System.out.println(
							rennstrecke1.get(i).getMiddleStringBoat() + " " + boote.get(i).getPosition() + ".");
				}

				System.out.println(rennstrecke1.get(i).getStarboardWater());
				if (i == amountOfBoats - 1) {
					System.out.println(rennstrecke1.get(i).getRandStringBahn());
				} else {
					System.out.println(rennstrecke1.get(i).getRandStringMiddle());
				}
			}
			// neue Position von Booten
			for (int j = 0; j < amountOfBoats; j++) {

				double leistungBoot = boote.get(j).getLeistungBoot();
				double sqrtTeilstrecke = Math.sqrt(leistungBoot) / factorForSpeedOfBoat; // Leistung umgerechnet in
																						 // Strecke (pro Schritt)
				double teilstreckeMitFaktor = sqrtTeilstrecke * boote.get(j).luckFaktor(lengthOfRacingField);
				//System.out.println(boote.get(j).luckFaktor(lengthOfRacingField) + ": Lucky-Faktor");

				

				// streckeGesamt muss am Anfang immer mindestens 1 sein!
				boote.get(j).setStreckeMade(teilstreckeMitFaktor + boote.get(j).getStreckeMade());
				int streckeGesamt = (int) boote.get(j).getStreckeMade() + ausgleichsfaktor;
				if (streckeGesamt <= 1) {
					streckeGesamt = 1;
				}

				// Abfrage START
				int varZwischen = streckeGesamt + boote.get(j).getLengthOfBoot();
				if (streckeGesamt + boote.get(j).getLengthOfBoot() >= lengthOfRacingField + ausgleichsfaktor) {
					streckeGesamt = lengthOfRacingField - boote.get(j).getLengthOfBoot() + ausgleichsfaktor;
				}

				// x-Position SET...
				boote.get(j).setxPos(boote.get(j).getxPos()
						+ (streckeGesamt - (boote.get(j).getxPos() - boote.get(j).getLengthOfBoot())));

				boote.get(j).bootEinsetzen(rennstrecke1.get(j));

				// Abfrage, falls rechter Rand...!
				if (boote.get(j).getStreckeMade() >= lengthOfRacingField - boote.get(j).getLengthOfBoot()) {
					boote.get(j).setWinner(true);
					if (laengsteDistanzImRennen < boote.get(j).getStreckeMade()) {
						laengsteDistanzImRennen = boote.get(j).getStreckeMade();
					}
					ende = true;
				}

				

				// Markus INPUT !!!!!!!!!!!!
				// AnonymeKlasse
				//
				// Position zuordnen (mit sortieren !!!)
				List<Boot> gerankteBoote = new ArrayList<Boot>(boote);
				Collections.sort(gerankteBoote, new Comparator<Boot>() {
					@Override
					public int compare(Boot boot1, Boot boot2) {
						return Double.valueOf(boot2.getStreckeMade()).compareTo(boot1.getStreckeMade());
					}
				});

				zaehler = 0;
				for (Boot temp : gerankteBoote) {
					++zaehler;
					temp.setPosition(zaehler);
				}

			}

			// slowing down time...
			Thread.sleep(400, 0);

		} while (!ende);

		// Who is the winner?
		for (int j = 0; j < amountOfBoats; j++) {
			if (boote.get(j).getStreckeMade() >= laengsteDistanzImRennen) {
				boote.get(j).setWinner(true);
			} else {
				boote.get(j).setWinner(false);
			}
		}

		// finischer Bild
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" THE END!");

		for (int i = 0; i < amountOfBoats; i++) {
			if (i == 0) {
				System.out.println(rennstrecke1.get(i).getRandStringBahn());
			}
			System.out.println(rennstrecke1.get(i).getBackboardWater());

			// boote.get(i).setWinner(true);
			if (boote.get(i).isWinner()) {
				System.out.println(
						rennstrecke1.get(i).getMiddleStringBoat() + boote.get(i).getStreckeMade() + "  --> Winner !!!");
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

	}

}
