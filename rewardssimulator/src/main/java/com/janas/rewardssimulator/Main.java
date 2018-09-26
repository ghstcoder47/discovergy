package com.janas.rewardssimulator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum ContractType {
	
	TORTOISE(100),
	RABBIT(300);
	
	int value;
	
	ContractType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}

enum PartnerLevel {
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

class Partner {
	long partnerId;
	long parentPartnerId;
	PartnerLevel level;
	
	public void sellContract() {
		//sell partnerid amount+
	}
}

class Sale {
	
	public enum Action {
		BEGIN,
		END;
	};
	
	long partnerId;
	long contractId;
	ContractType contractType;
	Date date;
	String action;
	
	private Sale(long partnerId, long contractId, ContractType contractType, Date date, Action action) {
		this.partnerId = partnerId;
		this.contractId = contractId;
		this.contractType = contractType;
		this.date = date;
		this.action = action.toString();
	}
	
	public Sale sell() {
		return new Sale(1, 1, ContractType.RABBIT, new Date(), Sale.Action.BEGIN);
	}
	
	public List<Sale> load(String file) {
		
		List<Sale> sales = new ArrayList<>();
		sales.add(new Sale(1, 1, ContractType.RABBIT, new Date(), Sale.Action.BEGIN));
		
		return sales;
	}
}

class CSVProvider {
	static List<Sale> readFile(String file) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		List<Sale> sales = new ArrayList<>();
		
		Constructor<Sale> constructor;
		constructor = Sale.class.getDeclaredConstructor(Long.class, Long.class, ContractType.class, Date.class, Sale.Action.class);
		constructor.setAccessible(true);
		Sale sale = constructor.newInstance(1, 1, ContractType.RABBIT, new Date(), Sale.Action.BEGIN);
		
		sales.add(sale);
		
		return sales;
	}
}

public class Main {
	
	
	
	
	public static void main(String[] args) {
		
	}

}
