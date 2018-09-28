package com.janas.rewardssimulator.partners.entity;

enum ContractType {

	TORTOISE(100), RABBIT(300);

	int value;

	ContractType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}