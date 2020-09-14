package com.skilldistillery.jets;

public class BomberJet extends Jet implements Bomber {

	private double bombAbility = 10;
	
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

	@Override
	public boolean missionBomb(Target target) {
		System.out.println(this.getModel() + " is attempting to bomb " + target);
		double roll = Math.random();
		int difficulty = target.getDifficulty();
		if (bombAbility * roll >= difficulty) {
			System.out.println(this.getModel() + " successfully bombed target!");
			return true;
		}
		System.out.println(this.getModel() + " failed to bomb target.");
		return false;
	}

}
