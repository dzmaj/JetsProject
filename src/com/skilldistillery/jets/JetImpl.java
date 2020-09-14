package com.skilldistillery.jets;

public class JetImpl extends Jet {

	public JetImpl(String model, String role, int speed, int range, int price, boolean refuelable) {
		super(model, role, speed, range, price, refuelable);
	}
	public JetImpl() {
		super();
	}
	public JetImpl(String role) {
		super();
		super.setRole(role);
	}

	
}
