package com.csus.csc133.students;

public class StudentNonstop extends Student {
    public StudentNonstop(int x, int y) {
        super(x, y);
    }

    @Override
    public void handleCollide(Student s) {
        // Do nothing, timeRemain cannot be changed
    }
}