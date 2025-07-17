package com.csus.csc133;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.csus.csc133.buildings.LectureHall;
import com.csus.csc133.buildings.Restroom;
import com.csus.csc133.buildings.WaterDispenser;
import com.csus.csc133.students.Student;
import com.csus.csc133.students.StudentAngry;
import com.csus.csc133.students.StudentBiking;
import com.csus.csc133.students.StudentCar;
import com.csus.csc133.students.StudentFriendly;
import com.csus.csc133.students.StudentHappy;
import com.csus.csc133.students.StudentPlayer;
import com.csus.csc133.students.StudentRunning;
import com.csus.csc133.students.StudentStrategy;

public class GameModel extends Observable{
    public static final int WORLD_WIDTH = 1024;
    public static final int WORLD_HEIGHT = 768;

    private int gameTime;
    private int worldWidth;
    private int worldHeight;
    Student student=new Student(40,40);

    private GameObjectCollection gameObjects;
    
    private StudentPlayer studentPlayer;
    private StudentAngry studentAngry;
    private StudentCar studentCar;
    private StudentBiking studentBiking;
    private StudentFriendly studentFriendly;
    private StudentHappy studentHappy ;
    private StudentRunning studentRunning;
    private StudentStrategy studentStrategy1, studentStrategy2;
    
    private Restroom restroom;
    private WaterDispenser waterDispenser;
    private LectureHall lectureHall;

    private List<Observer> observers;
    
    private String status;
    
    public void init(){
    	observers = new ArrayList<>();
    	gameTime = 0;
        worldWidth = WORLD_WIDTH;
        worldHeight = WORLD_HEIGHT;
        gameObjects = new GameObjectCollection();

        studentPlayer = StudentPlayer.getInstance();
        gameObjects.add(studentPlayer);

        studentAngry = new StudentAngry(30,40);
        gameObjects.add(studentAngry);

        studentBiking = new StudentBiking(50,40);
        gameObjects.add(studentBiking);

        studentCar = new StudentCar(50,50);
        gameObjects.add(studentCar);

        studentFriendly = new StudentFriendly(60,60);
        gameObjects.add(studentFriendly);

        studentHappy = new StudentHappy(60,50);
        gameObjects.add(studentHappy);

        studentRunning = new StudentRunning(50,70);
        gameObjects.add(studentRunning);
        
        studentStrategy1= new StudentStrategy(90, 30);
        gameObjects.add(studentStrategy2);
        
        studentStrategy2 = new StudentStrategy(50,60);
        gameObjects.add(studentStrategy2);

        lectureHall = new LectureHall(55,75,"OBAMA");
        gameObjects.add(lectureHall);

        restroom = new Restroom(45,75);
        gameObjects.add(restroom);

        waterDispenser = new WaterDispenser(75,45);
        gameObjects.add(waterDispenser);
        status = "Game started!";
        setChanged();
        notifyObsersevers();
	}

    public GameModel() {
        
    }

    public void updateGame() {
        gameTime++;

        for (GameObject gameObject : gameObjects) {
            gameObject.move();
        }
    }

    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    // Getters and setters

    public int getGameTime() {
        return gameTime;
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public GameObjectCollection getGameObjects() {
        return gameObjects;
    }

    public void startMovingStudentPlayer() {
        studentPlayer.startMoving();
        status = "Player Started Moving";
        System.out.println(status);
        setChanged();
        notifyObsersevers();
    }

    public void stopMovingStudentPlayer() {
        studentPlayer.stopMoving();
        status = "Player Stopped Moving";
        System.out.println(status);
        setChanged();
        notifyObsersevers();
    }

    public void turnLeftStudentPlayer() {
        studentPlayer.turnLeft();
        status = "Player Turned Left";
        System.out.println(status);
        setChanged();
        notifyObsersevers();
    }

    public void turnRightStudentPlayer() {
        studentPlayer.turnRight();
        status = "Player Turned Right";
        System.out.println(status);
        setChanged();
        notifyObsersevers();
    }

    public void collisionWithLectureHall() {
        lectureHall.handleCollide(studentPlayer);
        status = "Player Collided With Lecture Hall";
        System.out.println(status);
        setChanged();
        notifyObsersevers();
    }

    public void collisionWithRestroom() {
        restroom.handleCollide(studentPlayer);
        status = "Player Collided With Rest Room";
        System.out.println(status);
        setChanged();
    }

    public void collisionWithWaterDispenser() {
        waterDispenser.handleCollide(studentPlayer);
        status = "Player Collided With Water Dispenser";
        System.out.println(status);
        setChanged();
        notifyObsersevers();
    }

    public void collisionWithRandomStudent() {
        student.handleCollide(studentPlayer);
        status = "Player Collided With Another Student";
        System.out.println(status);
        setChanged();
        notifyObsersevers();
    }

    public void advanceToNextFrame() {
        // Implement the logic to advance to the next frame of the game
        // Perform necessary game updates and calculations
    	status = "Player Switched To NEXT Frame";
        System.out.println(status);
        gameTime++;
        setChanged();
        checkGameStatus(); // Check game status after each frame update
        
    }
    public void checkGameStatus() {
        if (studentPlayer.getAbsenceTime() >= 5 || studentPlayer.getWaterIntake() >= 10 || studentPlayer.getHydration() <= 0) {
            // Perform any additional game over actions or cleanup if needed
            System.exit(0); // Terminate the game
        }
    }
    public void outputGameInformation() {
        System.out.println("Current Time: " + gameTime);
        for (GameObject gameObject : gameObjects) {
            if(gameObject != null) {
            	String gameInfo = gameObject.getGameInformation();
                System.out.println(gameInfo);
            }
        }
    }

	public void handleStudentCollision(int i) {
		if(i == -1) {
			return;
		}
		gameObjects.get(i).handleCollide(studentPlayer);
		status = "Player collided with student #" + i;
		System.out.println(status);
		setChanged();
		notifyObsersevers();
	}
	
	public void notifyObsersevers() {
		String lName = lectureHall.getName();
		int lTime = lectureHall.getLectureRemainingTime();
		int nAbs = studentPlayer.getAbsenceTime();
		int hyd = studentPlayer.getHydration();
		int wat = studentPlayer.getWaterIntake();
		int hold = 0; // I couldn't understand this field from the given picture
		GameData gameData = new GameData(lName, lTime, gameTime, nAbs, hyd, wat, hold, status);
		super.notifyObservers(gameData);
	}

	public void changeStrategy() {

		
	}
}