package com.csus.csc133.buildings;

import com.csus.csc133.students.Student;

public class WaterDispenser extends Building {
    public WaterDispenser(int x, int y) {
        super(x, y);
    }

    @Override
    public void handleCollide(Student s) {
        s.drinkWater();
    }
}