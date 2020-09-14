package com.skilldistillery.jets;

public class Target {
	private int difficulty;
	private boolean dangerous;
	public Target() {
		super();
		this.difficulty = (int)(Math.random() * 10);
		if (Math.random() > 0.8) {
			dangerous = true;
		} else { dangerous = false; }
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public boolean isDangerous() {
		return dangerous;
	}
	public void setDangerous(boolean dangerous) {
		this.dangerous = dangerous;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Target [difficulty=");
		builder.append(difficulty);
		builder.append(", dangerous=");
		builder.append(dangerous);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (dangerous ? 1231 : 1237);
		result = prime * result + difficulty;
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
		Target other = (Target) obj;
		if (dangerous != other.dangerous)
			return false;
		if (difficulty != other.difficulty)
			return false;
		return true;
	}
	
	
	
}
