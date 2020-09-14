package com.skilldistillery.jets;

public abstract class Jet {

	private String model;
	private String role;
	private int speed;
	private int range;
	private int price;
	private boolean refuelable;
//	private String tailNumber;
	
	public double getFlightTime() {
		return (((double)range) / speed);
	}
	
	public void fly() {
		System.out.println(this + " is flying and can fly for " + getFlightTime() + " hours");
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
		builder.append(", Price: $");
		builder.append(price);
		builder.append(", Air Refuelable: ");
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + price;
		result = prime * result + range;
		result = prime * result + (refuelable ? 1231 : 1237);
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + speed;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price != other.price)
			return false;
		if (range != other.range)
			return false;
		if (refuelable != other.refuelable)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (speed != other.speed)
			return false;
		return true;
	}
	
	
}
