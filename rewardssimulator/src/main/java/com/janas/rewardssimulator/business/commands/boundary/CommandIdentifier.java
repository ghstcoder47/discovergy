package com.janas.rewardssimulator.business.commands.boundary;

import java.util.StringTokenizer;

import com.janas.rewardssimulator.business.commands.control.CallCommand;

public class CommandIdentifier {

	public static void identify(String inputString) {
		
		StringTokenizer stringTokenizer = new StringTokenizer(inputString, " ");
		String method = stringTokenizer.nextToken();	
		
		try {			
			CallCommand command = CallCommand.valueOf(method);
			if (stringTokenizer.hasMoreTokens()) {
				command.perform(stringTokenizer);
			}
		} catch (IllegalArgumentException e) {
			System.out.println("die Eingabe entspricht keinen gültigen befel:" + e.getMessage());
		}
		
	}

}
