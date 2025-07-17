package com.csus.csc133.students;

public class StudentPlayer extends Student {
	private static StudentPlayer player;
	
	private StudentPlayer(int x, int y) {
        super(x, y);
    }
	
	public static StudentPlayer getInstance() {
		if(player == null)
			player = new StudentPlayer(20, 20);
		return player;
	}

    public void startMoving() {
        speed = DEFAULT_SPEED;
        super.move();
    }

    public void stopMoving() {
        speed = 0;
    }
    public int getAbsenceTime() {
        return absenceTime;
    }

    public int getWaterIntake() {
        return waterIntake;
    }

    public int getHydration() {
        return hydration;
    }
    public void turnLeft() {
        head -= 5;
        super.move();
    }

    public void turnRight() {
        head += 5;
        super.move();
    }
}