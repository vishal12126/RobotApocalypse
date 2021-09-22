package com.survivor.response;

import java.util.*;

import com.survivor.entity.Robot;

public class StatsResponse {
	
	private long infected;
	private long uninfected;
	private double infectedPercentage;
	private double unfectedPercentage;
	private Map<String, List<Robot>> robots;
	public long getInfected() {
		return infected;
	}
	public void setInfected(Long infected2) {
		this.infected = infected2;
	}
	public long getUninfected() {
		return uninfected;
	}
	public void setUninfected(Long uninfected) {
		this.uninfected = uninfected;
	}
	public double getInfectedPercentage() {
		return infectedPercentage;
	}
	public void setInfectedPercentage(double infectedPercentage) {
		this.infectedPercentage = infectedPercentage;
	}
	public double getUnfectedPercentage() {
		return unfectedPercentage;
	}
	public void setUnfectedPercentage(double unfectedPercentage) {
		this.unfectedPercentage = unfectedPercentage;
	}
	public Map<String, List<Robot>> getRobots() {
		return robots;
	}
	public void setRobots(Map<String, List<Robot>> groupedByCategory) {
		this.robots = groupedByCategory;
	}
	
	public StatsResponse() {
		super();
	}
	public StatsResponse(long infected, long uninfected, double infectedPercentage, double unfectedPercentage,
			Map<String, List<Robot>> robots) {
		super();
		this.infected = infected;
		this.uninfected = uninfected;
		this.infectedPercentage = infectedPercentage;
		this.unfectedPercentage = unfectedPercentage;
		this.robots = robots;
	}
	@Override
	public String toString() {
		return "StatsResponse [infected=" + infected + ", uninfected=" + uninfected + ", infectedPercentage="
				+ infectedPercentage + ", unfectedPercentage=" + unfectedPercentage + "]";
	}
	
	
	
}
