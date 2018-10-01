package com.janas.rewardssimulator;

import java.util.Scanner;

import com.janas.rewardssimulator.business.interaction.boundary.CommandIdentifier;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("============= rewardssimulator ===============");
		System.out.println("REGISTER pId 		 	-> register Partner");
		System.out.println("REGISTER pId ppId  		-> register Partner with Parent Partner");
		System.out.println("LOAD fileName.csv 		-> load report File by its name");
		System.out.println("REWARDS pid year quarter   	-> print Rewards for Partner for the given year and quarter");
		System.out.println("REWARDS pid   			-> print all Rewards for Partner");
		System.out.println("LEVEL pid year quarter  	-> print partners level for given year and quarter");
		System.out.println("SELL pid cid cType  		-> sell new Contract");
		System.out.println("quit");
		System.out.println("============= ================ ===============");

		String inputString;

		try(Scanner scanIn = new Scanner(System.in);) {
			
			while(true) {
				inputString = scanIn.nextLine();
							
				if (inputString.equals("quit")) {
					break;
				}
				
				if (inputString.length() > 0) {		
					CommandIdentifier.identify(inputString);
				}
			}
			
		}
		
	}
}
