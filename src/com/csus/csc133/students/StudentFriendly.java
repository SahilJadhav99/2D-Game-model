package com.csus.csc133.students;

public class StudentFriendly extends Student {
    public StudentFriendly(int x, int y) {
        super(x, y);
        talkingTime = DEFAULT_TALKING_TIME / 2;
    }
}