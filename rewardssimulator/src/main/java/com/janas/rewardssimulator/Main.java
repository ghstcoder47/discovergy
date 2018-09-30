package com.janas.rewardssimulator;

import java.util.Scanner;

import com.janas.rewardssimulator.business.commands.boundary.CommandIdentifier;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("============= rewardssimulator ===============");
		System.out.println("REGISTER pId");
		System.out.println("REGISTER pId ppId");
		System.out.println("LOAD fileName.csv");
		System.out.println("REWARDS...");
		System.out.println("LEVEL...");
		System.out.println("SELL...");
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
