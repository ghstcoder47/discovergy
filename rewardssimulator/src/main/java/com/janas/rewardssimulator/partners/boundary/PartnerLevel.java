package com.janas.rewardssimulator.partners.boundary;

public enum PartnerLevel {
	ANT(5),
	BEE(7),
	CAT(9),
	DOG(12),
	ELEPHANT(19);
	
	int reward;
	
	PartnerLevel(int reward) {
		this.reward = reward;
	}
}