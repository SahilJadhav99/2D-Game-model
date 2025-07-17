package com.csus.csc133.students;

public class StudentRunning extends Student {
    public StudentRunning(int x, int y) {
        super(x, y);
        sweatingRate = 2 * sweatingRate;
    }
}