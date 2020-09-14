package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.List;

public class AirField {

	private ArrayList<Jet> jets;
	// Not really used... had plans but didnt finish
	private int capacity;

	public AirField(int capacity) {
		this.capacity = capacity;
		this.jets = new ArrayList<>();
	}

	public ArrayList getJets() {
		return jets;
	}

	public void setJets(ArrayList jets) {
		this.jets = jets;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void addJet(Jet jet) {
		jets.add(jet);
	}

	public void displayJets() {
		for (Jet jet : jets) {
			if (jet != null) {
				System.out.println(jet);
			}
		}
	}

	public void displayFastestJet() {
		int topSpeed = 0;
		int speed = 0;
		boolean topSpeedTied = false;
		for (int i = 0; i < jets.size(); i++) {
			if (jets.get(i) == null) {
				continue;
			}
			speed = jets.get(i).getSpeed();
			if (speed > topSpeed) {
				topSpeed = jets.get(i).getSpeed();
				topSpeedTied = false;
			} else if (speed == topSpeed) {
				topSpeedTied = true;
			} else {
				continue;
			}
		}
		if (topSpeedTied) {
			System.out.println("The fastest jets are: ");
		} else {
			System.out.println("The fastest jet is: ");
		}
		for (Jet jet : jets) {
			if (jet == null) {
				continue;
			}
			if (jet.getSpeed() >= topSpeed) {
				System.out.println(jet);
			}
		}
	}

	public void displayLongestRangeJet() {
		int topRange = 0;
		int range = 0;
		boolean topRangeTied = false;
		for (int i = 0; i < jets.size(); i++) {
			if (jets.get(i) == null) {
				continue;
			}
			range = jets.get(i).getRange();
			if (range > topRange) {
				topRange = jets.get(i).getRange();
				topRangeTied = false;
			} else if (range == topRange) {
				topRangeTied = true;
			} else {
				continue;
			}
		}
		if (topRangeTied) {
			System.out.println("The jets with the longest range are: ");
		} else {
			System.out.println("The jet with the longest range is: ");
		}
		for (Jet jet : jets) {
			if (jet == null) {
				continue;
			}
			if (jet.getRange() >= topRange) {
				System.out.println(jet);
			}
		}
	}

	public void flyAllJets() {
		System.out.println("Flying all jets!");
		for (Jet jet : jets) {
			jet.fly();
		}
	}

	public void removeJet(int index) {
		jets.remove(index);
	}

	public void performRefuelMissions() {
		for (Jet jet : jets) {
			if (jet instanceof RefuelerJet) {
				((RefuelerJet) jet).refuel(getRandomRefuelableJet());
			}
		}
	}
	public void performReconMissions() {
		for (Jet jet : jets) {
			if (jet instanceof Recon) {
				((Recon) jet).doRecon((Bomber)getRandomBomberJet());
			}
		}
	}
	public void performBombingMissions() {
		for (Jet jet : jets) {
			if (jet instanceof Bomber) {
				((Bomber) jet).bomb();
			}
		}
		
	}

	public Jet getRandomRefuelableJet() {
		ArrayList<Jet> refuelableJets = new ArrayList<>();
		int num = 0;
		for (Jet jet : jets) {
			if (jet.isRefuelable()) {
				refuelableJets.add(jet);
			}
		}
		num = refuelableJets.size();
		int index = (int)(Math.random() * num);
		return refuelableJets.get(index);
		
	}
	public Jet getRandomBomberJet() {
		ArrayList<Jet> bomberJets = new ArrayList<>();
		int num = 0;
		for (Jet jet : jets) {
			if (jet instanceof BomberJet) {
				bomberJets.add(jet);
			}
		}
		num = bomberJets.size();
		int index = (int)(Math.random() * num);
		return bomberJets.get(index);
	}
}
