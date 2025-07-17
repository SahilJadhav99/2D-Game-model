package com.csus.csc133;

import com.csus.csc133.students.Student;

public abstract class GameObject {
    protected int x;
    protected int y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
    	return x;
    }
    public int getY() {
    	return y;
    }
    
    public void setX(int x) {
    	this.x = x;
    }
    public void setY(int y) {
    	this.y = y;
    }
    
    public abstract void move();

    public abstract void handleCollide(Student s);
    public abstract String getGameInformation();
}