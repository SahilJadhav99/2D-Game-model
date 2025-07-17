package com.csus.csc133.students;

import java.util.Random;

public class StudentConfused extends Student {
    public StudentConfused(int x, int y) {
        super(x, y);
    }

    @Override
    public void move() {
    	Random rand = new Random();
        head += (int) ( rand.nextInt() * 20) - 10; // Add a random value to the head
        super.move();
    }
}