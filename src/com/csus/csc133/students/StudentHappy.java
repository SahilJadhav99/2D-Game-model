package com.csus.csc133.students;

import java.util.Random;

public class StudentHappy extends Student {
    public StudentHappy(int x, int y) {
        super(x, y);
    }

    @Override
    public void move() {
        // With some probability, increase the speed temporarily
    	Random rand = new Random();
        if (rand.nextInt() < 10) {
            speed *= 2;
        }
        super.move();
        // Set the speed back to normal
        speed = DEFAULT_SPEED;
    }
}