package com.janas.rewardssimulator.business.partners.boundary;

public enum PartnerLevel {
	ANT(5), BEE(7), CAT(9), DOG(12), ELEPHANT(19);

	int reward;

	PartnerLevel(int reward) {
		this.reward = reward;
	}

	public int getReward() {
		return reward;
	}

	public static PartnerLevel computeLevel(long sales) {
		return sales < 10 ? ANT : sales < 50 ? BEE : sales < 200 ? CAT : sales < 1000 ? DOG : ELEPHANT;
	}
}