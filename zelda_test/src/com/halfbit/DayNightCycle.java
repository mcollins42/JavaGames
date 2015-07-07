package com.halfbit;

public class DayNightCycle {
	
	Room room;
	long startTime;
	boolean isNight;

	public DayNightCycle(Room room) {
		this.room = room;
		startTime = System.currentTimeMillis();
		isNight = false;
	}
	
	public void tick() {
		if (System.currentTimeMillis() - startTime > 12000) {
			startTime = System.currentTimeMillis();
			isNight = !isNight;
			room.setIsDay(isNight);
		}
	}

	public boolean isNight() {
		return isNight;
	}
}
