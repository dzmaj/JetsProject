package com.skilldistillery.jets;

public interface Bomber {
	void bomb();
	void bomb(Recon recon);
	boolean missionBomb(Target target);
}
