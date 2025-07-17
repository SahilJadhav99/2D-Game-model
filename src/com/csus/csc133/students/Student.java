package com.csus.csc133.students;

import java.util.Random;

import com.csus.csc133.GameModel;
import com.csus.csc133.GameObject;

public class Student extends GameObject {
	 protected static final int DEFAULT_SPEED = 20;
	    protected static final int DEFAULT_TALKING_TIME = 2;

	    protected int head;
	    protected int speed;
	    protected int talkingTime;
	    protected int timeRemain;
	    protected int hydration;
	    protected int waterIntake;
	    protected int sweatingRate;
	    protected int absenceTime;

	    public Student(int x, int y) {
	        super(x, y);
	        Random rand = new Random();
	        head = rand.nextInt(360);
	        speed = DEFAULT_SPEED;
	        talkingTime = DEFAULT_TALKING_TIME;
	        timeRemain = 0;
	        hydration = 100;
	        waterIntake = 0;
	        sweatingRate = 1;
	        absenceTime = 0;
	    }

	    @Override
	    public void move() {
	        if (timeRemain > 0) {
	            timeRemain--;
	        } else {
	            int newX = x + (int) (Math.cos(Math.toRadians(90 - head)) * speed);
	            int newY = y + (int) (Math.sin(Math.toRadians(90 - head)) * speed);
	            checkGameBoundary(newX,newY);
	            x = newX;
	            y = newY;
	            hydration -= sweatingRate;
	        }
	    }

	    public void checkGameBoundary(int newX, int newY){
	// Check if the new position is within the world boundaries
	        if (newX < 0 || newX >= GameModel.WORLD_WIDTH || newY < 0 || newY >= GameModel.WORLD_HEIGHT) {
	            newX = Math.max(0, Math.min(newX, GameModel.WORLD_WIDTH - 1));
	            newY = Math.max(0, Math.min(newY, GameModel.WORLD_HEIGHT - 1));
	            head = (head + 180) % 360; // Change direction when hitting the boundary
	        }
	    }

	    @Override
	    public void handleCollide(Student s) {
	        int maxTalkingTime = Math.max(this.talkingTime, s.talkingTime);
	        this.timeRemain = maxTalkingTime;
	        s.timeRemain = maxTalkingTime;
	    }

	    public void drinkWater() {
	        int hydrationChange = 100 - hydration;
	        hydration = 100;
	        waterIntake += hydrationChange;
	    }

	    public void clearWaterIntake() {
	        waterIntake = 0;
	    }

	    public String getGameInformation() {

	        String className = getClass().getSimpleName();
	        String position = "(" + x + ", " + y + ")";

	        String headStr = format(head);
	        String speedStr = format(speed);
	        String hydrationStr = format(hydration);
	        String timeRemainStr = format(timeRemain);

	        String tempStr = "";
	        if(this instanceof StudentPlayer) {
	            String absenceTimeStr = format(absenceTime);
	            String waterIntakeStr = format(waterIntake);
	            tempStr = ", "+ "Absence:"  + absenceTimeStr + ", "+ "waterIntake:"  + waterIntakeStr;
	        }

	        return className + ", " + "pos " + position + ", " + "head:" + headStr + ", " + "speed:" + speedStr + ", "+ "hydration:"  + hydrationStr +
	                ", "+ "timeRemain:"  + timeRemainStr + tempStr;
	    }
	    
	    public void setHead(int head) {
	    	this.head = head;
	    }
	    
	    public int getHead() {
	    	return head;
	    }
	    
	    public int getSpeed() {
	    	return this.speed;
	    }
	    
	    public void sweat() {
	    	hydration -= sweatingRate;
	    }
	    
    private String format(double d) {
    	return String.valueOf(d).substring(0, String.valueOf(d).indexOf(".") +2);
    }
    

}