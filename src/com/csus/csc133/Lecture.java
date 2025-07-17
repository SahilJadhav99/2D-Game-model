package com.csus.csc133;

public class Lecture {
    private int endTime;

    public Lecture(int endTime) {
        this.endTime = endTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void end() {
        this.endTime = 0;
    }
}