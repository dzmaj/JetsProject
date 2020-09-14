package com.skilldistillery.jets;

public interface Recon {
	void doRecon();
	void doRecon(Bomber bomber);
	void doRecon(Refueler tanker, Bomber bomber);
	boolean missionRecon(Target target);
}
