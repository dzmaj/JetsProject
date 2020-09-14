package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {

	private AirField airField;
	private Scanner sc;
	private int airFieldCap = 10;

	public static void main(String[] args) {
		JetsApplication jApp = new JetsApplication();
		jApp.run();
	}

	public void run() {
		jetsCreator();
		getMenuInput();
	}

	public JetsApplication() {
		sc = new Scanner(System.in);
		airField = new AirField(airFieldCap);
	}

	private void jetsCreator() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			Jet jet;
			String[] fields;
			while ((line = bufIn.readLine()) != null) {
				fields = line.split(",");
				if (fields[1].equals("Refueling")) {
					jet = new RefuelerJet(fields[1]);
				} else if (fields[1].equals("Reconnaissance")) {
					jet = new ReconnaissanceJet(fields[1]);
				} else if (fields[1].equals("Bomber")) {
					jet = new BomberJet(fields[1]);
				} else {
					jet = new JetImpl(fields[1]);
				}
				jet.setModel(fields[0]);
				jet.setSpeed(Integer.parseInt(fields[2]));
				jet.setRange(Integer.parseInt(fields[3]));
				jet.setPrice(Integer.parseInt(fields[4]));
				jet.setRefuelable(Boolean.parseBoolean(fields[5]));
				airField.addJet(jet);

			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private void printMenu() {
		System.out.println("Please Select an option:");
		System.out.println("1. List fleet                   2. Fly all jets");
		System.out.println("3. View fastest jet             4. View jet with longest range");
		System.out.println("5. Perform refueling mission    6. Perform reconnaissance mission");
		System.out.println("7. Perform bombing mission      8. Add/remove a jet");
		System.out.println("9. Exit");
		System.out.println();
	}

	private void getMenuInput() {
		String input;
		boolean keepGoing = true;
		while (keepGoing) {
			printMenu();
			input = sc.nextLine();
			switch (input) {
			case "1":
				airField.displayJets();
				break;
			case "2":
				airField.flyAllJets();
				break;
			case "3":
				airField.displayFastestJet();
				break;
			case "4":
				airField.displayLongestRangeJet();
				break;
			case "5":
				// refuel
				airField.performRefuelMissions();
				break;
			case "6":
				// recon
				airField.performReconMissions();
				break;
			case "7":
				// bombing
				airField.performBombingMissions();
				break;
			case "8":
				// add/remove
				addRemoveJet();
				break;
			case "9":
				keepGoing = false;
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}

	private void addRemoveJet() {
		System.out.println("Would you like to (1)add a jet, (2)remove a jet, or (3) go back?");
		String input;
		input = sc.nextLine();
		boolean keepGoing = true;
		while (keepGoing) {
			if (input.contentEquals("1")) {
				createJet();
				return;
			} else if (input.contentEquals("2")) {
				deleteJet();
				return;
			} else if (input.contentEquals("3")) {
				keepGoing = false;
			} else {
				System.out.println("Invalid input");
			}
		}
	}

	private void createJet() {
		Jet jet;
		String input;
		String model;
		String role;
		int speed = 0;
		int range = 0;
		int price = 0;
		boolean refuelable = false;
		System.out.println("Model: ");
		model = sc.nextLine();
		System.out.println("Role: ");
		role = sc.nextLine();
		boolean invalid = true;
		while (invalid) {
			try {
				System.out.println("Speed(mph): ");
				speed = sc.nextInt();
				sc.nextLine();
				invalid = false;
			} catch (Exception e) {
				e.getMessage();
			}
		}
		invalid = true;
		while (invalid) {
			try {
				System.out.println("Range(mi): ");
				range = sc.nextInt();
				sc.nextLine();
				invalid = false;
			} catch (Exception e) {
				e.getMessage();
			}
		}
		invalid = true;
		while (invalid) {
			try {
				System.out.println("Price($): ");
				price = sc.nextInt();
				sc.nextLine();
				invalid = false;
			} catch (Exception e) {
				e.getMessage();
			}
		}
		invalid = true;
		String yesNo;
		while (invalid) {

			System.out.println("Air Refuelable(y/n): ");
			yesNo = sc.nextLine();
			if (yesNo.toLowerCase().contentEquals("y")) {
				refuelable = true;
				invalid = false;
				System.out.println(refuelable);
			} else if (yesNo.toLowerCase().contentEquals("n")) {
				refuelable = false;
				invalid = false;
			} else {
			invalid = false;
			}

		}
		if (role.toLowerCase().contentEquals("refueling")) {
			jet = new RefuelerJet("Refueling");
		} else if (role.toLowerCase().contentEquals("reconnaissance")) {
			jet = new ReconnaissanceJet("Reconnaissance");
		} else if (role.toLowerCase().contentEquals("bomber")) {
			jet = new BomberJet("Bomber");
		} else {
			jet = new JetImpl();
			jet.setRole(role);
		}
		jet.setModel(model);
		jet.setSpeed(speed);
		jet.setRange(range);
		jet.setPrice(price);
		jet.setRefuelable(refuelable);
		System.out.println("You created this jet: ");
		System.out.println(jet);
		System.out.println("Would you like to add it? (y/n)");
		while (true) {
			input = sc.nextLine();
			if (input.toLowerCase().contentEquals("y")) {
				airField.addJet(jet);
				return;
			} else if (input.toLowerCase().contentEquals("n")) {
				return;
			} else {
				System.out.println("Invalid input. type 'y' or 'n'");
			}
		}
	}

	private void deleteJet() {
		List<Jet> jets = airField.getJets();
		for (int i = 0; i < jets.size(); i++) {
			System.out.println(i + ") " + jets.get(i));
		}
		int input;
		try {
			System.out.println("Please select the number of the jet you would like to remove:");
			airField.removeJet(sc.nextInt());
			return;
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Returning to menu");
			return;
		}

	}

}
