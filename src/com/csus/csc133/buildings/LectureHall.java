package com.csus.csc133.buildings;

import com.csus.csc133.Lecture;
import com.csus.csc133.students.Student;
import com.csus.csc133.students.StudentPlayer;

public class LectureHall extends Building {
	private String name;
    private Lecture lecture;

    public LectureHall(int x, int y, String name) {
        super(x, y);
        this.name = name;
        lecture = new Lecture(60);
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    @Override
    public void handleCollide(Student s) {
        if (s instanceof StudentPlayer && lecture != null) {
            lecture.end();
        }
    }
    
    public String getName() {
    	return this.name;
    }
    
    public int getLectureRemainingTime() {
    	return lecture.getEndTime();
    }

    public String getGameInformation() {

        String className = getClass().getSimpleName();
        String position = "(" + x + ", " + y + ")";

        String tempStr = "";
        if(lecture != null){
            tempStr = ", "+ "Current Lecture: " + name + ", " + "Remaining " + lecture.getEndTime();
        }

        return className + "pos " + position + ", " + tempStr;
    }
}