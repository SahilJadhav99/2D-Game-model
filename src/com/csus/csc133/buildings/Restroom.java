package com.csus.csc133.buildings;

import com.csus.csc133.students.Student;

public class Restroom extends Building {
    public Restroom(int x, int y) {
        super(x, y);
    }

    @Override
    public void handleCollide(Student s) {
        s.clearWaterIntake();
    }
}