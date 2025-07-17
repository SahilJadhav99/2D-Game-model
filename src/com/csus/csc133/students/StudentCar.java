package com.csus.csc133.students;

import java.util.Random;

import com.csus.csc133.GameModel;

public class StudentCar extends Student {
    public StudentCar(int x, int y) {
        super(x, y);
        speed = 5 * DEFAULT_SPEED;
        sweatingRate = 0;
        // Set the head to either 90 or 270
        Random rand = new Random();
        head = (rand.nextInt(100) < 50) ? 90 : 270;
    }

    @Override
    public void move() {
        // Move only horizontally
        int newX = x + (int) (Math.cos(Math.toRadians(90 - head)) * speed);
        if (newX < 0 || newX >= GameModel.WORLD_WIDTH) {
            newX = Math.max(0, Math.min(newX, GameModel.WORLD_WIDTH - 1));
        }
        x = newX;
        hydration -= sweatingRate;
    }
}