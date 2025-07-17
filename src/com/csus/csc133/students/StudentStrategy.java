package com.csus.csc133.students;

import java.util.Random;

import com.csus.csc133.students.strategies.HorizontalStrategy;
import com.csus.csc133.students.strategies.RandomStrategy;
import com.csus.csc133.students.strategies.Strategy;
import com.csus.csc133.students.strategies.VerticalStrategy;

public class StudentStrategy extends Student{
	private Strategy currentStrategy;
	private final Strategy[] strategies = {new RandomStrategy(), new HorizontalStrategy(), new VerticalStrategy()};
	
	public StudentStrategy(int x, int y) {
		super(x, y);
		setCurrentStrategy(new RandomStrategy());
	}	
	
	public void setCurrentStrategy(Strategy strategy) {
		this.currentStrategy = strategy;
	}
	
	public Strategy getCurrentStrategy() {
		return currentStrategy;
	}
	
	public void move() {
		currentStrategy.apply(this);
	}
	
	public void changeStrategy() {
		Random rand = new Random();
		int randomIdx = (int)(rand.nextInt(strategies.length));
		Strategy newStrategy = strategies[randomIdx];
		this.currentStrategy = newStrategy;
	}
}
