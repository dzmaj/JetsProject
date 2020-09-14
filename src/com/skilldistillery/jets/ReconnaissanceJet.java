package com.skilldistillery.jets;

public class ReconnaissanceJet extends Jet implements Recon {

	@Override
	public void doRecon() {
		System.out.println("Performing reconnaissance");
		
	}
	@Override
	public void doRecon(Bomber bomber) {
		System.out.println(this.getModel() + " is performing reconnaissance");
		System.out.println(this.getModel() + " is locating target");
		System.out.println(this.getModel() + " is passing target to " + ((BomberJet)bomber).getModel());
		bomber.bomb(this);
		
	}
	@Override
	public void doRecon(Refueler tanker, Bomber bomber) {
		//
	}

	public ReconnaissanceJet(String model, String role, int speed, int range, int price, boolean refuelable) {
		super(model, role, speed, range, price, refuelable);
	}
	public ReconnaissanceJet(String role) {
		super();
		super.setRole(role);
	}
	@Override
	public boolean missionRecon(Target target) {
		System.out.println(super.getModel() + " performing recon on target: " + target);
		int difficulty = target.getDifficulty();
		double roll = Math.random();
		if (roll < 0.75) {
			System.out.println("Recon successful!");
			target.setDifficulty((int)(difficulty * roll));
			return true;
		}
		System.out.println("Recon unsuccessful.");
		return false;
	}

}
