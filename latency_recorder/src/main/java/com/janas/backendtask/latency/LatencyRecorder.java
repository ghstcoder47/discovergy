package com.janas.backendtask.latency;

import java.util.ArrayList;
import java.util.List;

public class LatencyRecorder {
	
	private static class LatencyRecorderHolder {
		public static final LatencyRecorder instance = new LatencyRecorder();
	}
	
	private List<Integer> latencies = new ArrayList<>();
	
	private LatencyRecorder() {}
	
		
	public void clear() {
		this.latencies.clear();
	}

	public void add(Integer latency) {
		this.latencies.add(latency);
	}

	public Integer getMax() {
		
		return this.latencies.stream()
					.mapToInt(Integer::intValue)
					.max()
					.getAsInt();
	}

	public Integer getMin() {
		return this.latencies.stream()
					.mapToInt(Integer::intValue)
					.min()
					.getAsInt();
	}
	
	public static LatencyRecorder getInstance() {
		return LatencyRecorderHolder.instance;
	}
}