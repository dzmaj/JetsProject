package com.skilldistillery.jets;

public class BomberJet extends Jet implements Bomber {

	@Override
	public void bomb() {
		System.out.println(this.getModel() + " is bombing target!");

	}

	public BomberJet(String model, String role, int speed, int range, int price, boolean refuelable) {
		super(model, role, speed, range, price, refuelable);
	}
	public BomberJet(String role) {
		super();
		super.setRole(role);
	}

	@Override
	public void bomb(Recon recon) {
		System.out.println(this.getModel() + " recieving target from " + ((ReconnaissanceJet) recon).getModel());
		System.out.println(this.getModel() + " is bombing target!");
	}

}
