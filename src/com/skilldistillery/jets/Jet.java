package com.skilldistillery.jets;

public abstract class Jet {

	private String model;
	private String role;
	private int speed;
	private int range;
	private int price;
	private boolean refuelable;
//	private String tail;
	
	public double getFlightTime() {
		// max flight time = range / speed
		return ((double)range) / speed;
	}
	
	public void fly() {
		System.out.println(this + "can fly for " + getFlightTime() + " hours");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Jet(String model, String role, int speed, int range, int price, boolean refuelable) {
		super();
		this.model = model;
		this.role = role;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.refuelable = refuelable;
	}
	public Jet() {}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("");
		builder.append(model);
		builder.append(" (Role: ");
		builder.append(role);
		builder.append(", Speed: ");
		builder.append(speed);
		builder.append(", Range: ");
		builder.append(range);
		builder.append(", Price: ");
		builder.append(price);
		builder.append(", Refuelable: ");
		builder.append(refuelable);
		builder.append(")");
		return builder.toString();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isRefuelable() {
		return refuelable;
	}

	public void setRefuelable(boolean refuelable) {
		this.refuelable = refuelable;
	}
	
	
}
