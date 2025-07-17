package com.csus.csc133.students;

public class StudentAngry extends Student {
    public StudentAngry(int x, int y) {
        super(x, y);
        talkingTime = 2 * DEFAULT_TALKING_TIME;
    }

}