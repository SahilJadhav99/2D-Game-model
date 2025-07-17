package com.csus.csc133.students.strategies;

import com.csus.csc133.GameModel;
import com.csus.csc133.students.Student;

public class HorizontalStrategy extends Strategy{

	@Override
	public void apply(Student student) {
		int newX = student.getX() + (int) (Math.cos(Math.toRadians(90 - student.getHead())) * student.getSpeed());
        if (newX < 0 || newX >= GameModel.WORLD_WIDTH) {
            newX = Math.max(0, Math.min(newX, GameModel.WORLD_WIDTH - 1));
        }
        student.setX(newX);
        student.sweat();
	}
}
