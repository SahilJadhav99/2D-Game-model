package com.csus.csc133.students;

public class StudentBiking extends Student {
    public StudentBiking(int x, int y) {
        super(x, y);
        speed = 3 * DEFAULT_SPEED;
        sweatingRate = 2 * sweatingRate;
    }
}