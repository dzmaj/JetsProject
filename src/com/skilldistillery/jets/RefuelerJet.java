package com.skilldistillery.jets;

public class RefuelerJet extends Jet implements Refueler {

	@Override
	public void refuel(Jet jet) {
		System.out.println(super.getModel() + " is refueling " + jet.getModel());

	}

	public RefuelerJet(String model, String role, int speed, int range, int price, boolean refuelable) {
		super(model, role, speed, range, price, refuelable);
	}
	public RefuelerJet(String role) {
		super();
		super.setRole(role);
	}

	@Override
	public boolean missionRefuel(Jet jet) {
		if (!jet.isRefuelable()) {
			System.out.println(jet.getModel() + " is not air refuelable!");
			return false;
		}
		refuel(jet);
		if (Math.random() > 0.25) {
			System.out.println("Refueling successful!");
			return true;
		}
		else {
			System.out.println("Refueling failed!");
			return false;
		}
	}

}
