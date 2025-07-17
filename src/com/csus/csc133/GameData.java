package com.csus.csc133;

public class GameData {
	public GameData(String lectureHallName, int lectureHallTime, int gameTime, int numAbsences, int playerHydration,
			int waterIntake, int hold, String status) {
		this.lectureHallName = lectureHallName;
		this.lectureHallTime = lectureHallTime;
		this.gameTime = gameTime;
		this.numAbsences = numAbsences;
		this.playerHydration = playerHydration;
		this.waterIntake = waterIntake;
		this.hold = hold;
		this.status = status;
	}
	public final String lectureHallName;
    public final int lectureHallTime;   
    public final int gameTime;
    public final int numAbsences;
    public final int playerHydration;
    public final int waterIntake;
    public final int hold;
    public final String status;
}
