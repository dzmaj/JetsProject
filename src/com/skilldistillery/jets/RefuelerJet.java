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

}
