package com.janas.backendtask.latency.original;

import java.util.ArrayList;
import java.util.Collections;

public class LatencyRecorder {
	
	// 1)welche bedeutung hat hier "lt"? schlechte lesbarkeit, man könnte weiter im Code den Kontext verlieren
	// 2) Grundsätzlich solte die Referenz immer vom Typ des Interfaces nicht der Implementierung sein
	// zb List statt ArrayList
	private static ArrayList<Integer> lt = new ArrayList<>();
	
	//welchen sinn hat die Konstante? kaum Aussage
	// einmal wird sie als Index zugriff benutzt, 
	// ein weiteres mal ist es ein Rückgabewert!?
	private static final int ZERO = 0;

	// reset und clear kann uniformiert werden
	public static void reset() {
		lt.clear();
	}

	// schlechte namensgebung für parameter
	//tim = latency ?
	public static void putLatency(Integer tim) {
		lt.add(tim);
	}

	// verstoß gegen namensconvention getMax get_max
	public static Integer get_max() {
		Collections.sort(lt);
		
		//bug arrayOutOfBound da letztes Element im array den Index = list.size-1 hat
		return lt.get(lt.size());
	}

	// namenskonvention  getSmallest wär besser
	static int smallest() {
		Collections.sort(lt);
		return lt.get(ZERO);
	}

	/*
	 * was ist der Parameter z ?
	 */
	public static long getLatencyProcent(double z) {
		Collections.sort(lt);
		/*
		 *  1) ist die liste leer hat man hier eine Division durch 0 !!!!
		 *  2) For Schleife und if Anweisung immer mit {} klammern. Da sonst Bug Potential
		 *  3) inkrementiert j = lt.size und Findet Zugriff lt.get(j) statt, ist das eine indexOutOfBounds Exception
		 *  4) Code Wiederhollung -> Collections.sort(lt). kann auch als private Methode ausgelagert werden.
		 *  wird hier in mehreren Methoden verwendet
		 *  - Da nicht ganz klar ist was diese Methode tun soll, wurde sie in meiner Lösung ausgelassen
		 */
		for (int j = 0; j <= lt.size(); j++)
			if ((double) (j / lt.size() * 100) > z)
				return lt.get(j);
		return ZERO;
	}
}
