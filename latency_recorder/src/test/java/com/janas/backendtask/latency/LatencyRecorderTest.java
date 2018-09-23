package com.janas.backendtask.latency;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class LatencyRecorderTest {
	
	LatencyRecorder cut = LatencyRecorder.getInstance();
	final Integer MIN_LATENCY = 2;
	final Integer MAX_LATENCY = 57;
	
	@Before
	public void init() {
		
		cut.add(MAX_LATENCY);
		
		IntStream
			.range(MIN_LATENCY, MAX_LATENCY)
			.forEach(i -> cut.add(i));		
		
		cut.add(MIN_LATENCY);	
	}
	
	@Test
	public void testMinLatency() {
		
		assertThat(cut.getMin(), is(MIN_LATENCY));
	}
	
	@Test
	public void testMaxLatency() {
		
		assertThat(cut.getMax(), is(MAX_LATENCY));
	}
}
