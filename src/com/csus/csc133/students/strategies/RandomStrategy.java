package com.csus.csc133.students.strategies;

import java.util.Random;

import com.csus.csc133.students.Student;

public class RandomStrategy extends Strategy{

	@Override
	public void apply(Student student) {
		Random rand = new Random();
        student.setHead(student.getHead() + (int) ( rand.nextInt() * 20) - 10); // Add a random value to the head
        student.move();
	}

}
