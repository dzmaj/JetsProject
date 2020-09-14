package com.skilldistillery.jets;

import java.util.ArrayList;

public class Mission {
	private ArrayList<Jet> jets;
	private ArrayList<Target> targets;
	private int range;
	private ArrayList<Recon> reconJets;
	private ArrayList<Refueler> tankerJets;
	private ArrayList<Bomber> bomberJets;
	private ArrayList<Jet> needsRefuelJets;
	private ArrayList<Target> targetsToBomb;
	private int numTargetsBombed;
	private int numJetsRefueled;
	private int numTargetsIdentified;
	private int numTargetsTotal;
	
	
	Mission(int range, ArrayList<Jet> jets, ArrayList<Target> targets) {
		this.jets = jets;
		this.targets = targets;
		this.range = range;
		this.reconJets = new ArrayList<>();
		this.tankerJets = new ArrayList<>();
		this.bomberJets = new ArrayList<>();
		this.needsRefuelJets = new ArrayList<>();
		this.numTargetsTotal = targets.size();
		this.targetsToBomb = new ArrayList<>();
		for (Jet jet : jets) {
			if (jet instanceof Refueler) {
				tankerJets.add((Refueler)jet);
			} else if (jet instanceof Bomber) {
				bomberJets.add((Bomber) jet);
			} else if (jet instanceof Recon) {
				reconJets.add((Recon) jet);
			} else {}
		}
		// if half of jet's range is less than mission range, then requires refueling
		for (Jet jet : jets) {
			if (jet instanceof Refueler) {
				continue;
			}
			if ((jet.getRange() / 2) < range) {
				needsRefuelJets.add(jet);
			}
		}
	}
	
	public boolean run() {
		runRefuel();
		runRecon();
		runBombing();
		System.out.println("Mission Summary:");
		System.out.println("Number of jets refueled: " + numJetsRefueled);
		System.out.println("Number of targets identified: " + numTargetsIdentified);
		System.out.println("Number of targets bombed: " + numTargetsBombed);
		int remainingTargets = numTargetsTotal - numTargetsBombed;
		System.out.println("Remaining targets: " + remainingTargets);
		return remainingTargets == 0 ? true : false;
		
	}
	
	public void runRefuel() {
//		ArrayList<Jet> failedRefuelJets = new ArrayList<>();
		for (Jet jetToRefuel : needsRefuelJets) {
			boolean success = false;
			System.out.println( jetToRefuel.getModel() + " needs refueling...");
			// Try to refuel with each tanker until successful
			for (Refueler tanker : tankerJets) {
				// if successful, remove from needs refuel list
				if (tanker.missionRefuel(jetToRefuel)) {
					//needsRefuelJets.remove(jetToRefuel);
					numJetsRefueled++;
					success = true;
					break;
				}
			}
			
			if (!success) {
				// if unsucessful with all...
				System.out.println(jetToRefuel.getModel() + " was unable to air refuel. Returning to base.");
				// remove from recon/bomber list
				if (jetToRefuel instanceof Recon) {
					reconJets.remove(jetToRefuel);
				} else if (jetToRefuel instanceof Bomber) {
					reconJets.remove(jetToRefuel);
				} 
			}
		}
	}
	
	public void runRecon() {
		for (Recon reconJet : reconJets) {
			if (reconJet == null) {
				continue;
			}
			ArrayList<Target> remTargs = new ArrayList<>();
			for (Target target : targets) {
				if (target == null) {
					continue;
				}
				// if successful, add to target list
				if (reconJet.missionRecon(target)) {
					System.out.println("Adding target to target list!");
					targetsToBomb.add(target);
					// was getting checkForComodification exception when trying to simply remove
					remTargs.add(target);
//					targets.remove(target);
					numTargetsIdentified++;
				}
				
			}
			for (Target target : remTargs) {
				// remove any targets that need to be removed (remTargs) from main list (targets)
				targets.remove(target);
			}
			remTargs.clear();
		}
	}
	
	public void runBombing() {
		ArrayList<Target> remTargs = new ArrayList<>();
		for (Bomber bomber : bomberJets) {
			for (Target target : targetsToBomb) {
				if (target == null) {
					continue;
				}
				// if successful, remove from target list
				if (bomber.missionBomb(target)) {
					// ConcurrentModificationException
//					targetsToBomb.remove(target);
					remTargs.add(target);
					numTargetsBombed++;
				}
			}
			for (Target target : remTargs) {
				targetsToBomb.remove(target);
			}
			remTargs.clear();
		}
	}
	
	
	
}
