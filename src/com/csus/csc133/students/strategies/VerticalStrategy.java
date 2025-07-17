package com.csus.csc133.students.strategies;

import com.csus.csc133.GameModel;
import com.csus.csc133.students.Student;

public class VerticalStrategy extends Strategy{

	@Override
	public void apply(Student student) {
		int newY = student.getX() + (int) (Math.sin(Math.toRadians(90 - student.getHead())) * student.getSpeed());
        if (newY < 0 || newY >= GameModel.WORLD_HEIGHT) {
            newY = Math.max(0, Math.min(newY, GameModel.WORLD_HEIGHT - 1));
        }
        student.setY(newY);
        student.sweat();
	}
	

}
