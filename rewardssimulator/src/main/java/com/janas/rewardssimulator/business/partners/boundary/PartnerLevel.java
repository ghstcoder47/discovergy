package com.janas.rewardssimulator.business.partners.boundary;

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
	
	public int getReward() {
		return reward;
	}
}