package com.csus.csc133;

import com.codename1.components.SpanLabel;
import com.codename1.ui.*;
import com.codename1.ui.events.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.csus.csc133.gui.ViewMap;
import com.csus.csc133.gui.ViewMessage;
import com.csus.csc133.gui.ViewStatus;

public class SacRun extends Form{
	
	private GameModel gm;
	
	public SacRun(){
		gm = new GameModel();
		
//		A1();
		A2();
		gm.init();
		
	}
	
	//UI provided for A1 only, remove it in A2
	private void A1() {
		Label myLabel=new Label("Enter a Command:");
		TextField myTextField=new TextField();
		this.add(myLabel).add(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				String sCommand=myTextField.getText().toString();
				myTextField.clear();
				if(sCommand.isEmpty()) return;
				handleInput(sCommand.charAt(0));
			}
		});
	}
		
	private void A2() {
		ViewStatus viewStatus = new ViewStatus();
		ViewMap viewMap = new ViewMap();
		ViewMessage viewMessage = new ViewMessage();
		
		gm.addObserver(viewStatus);
		gm.addObserver(viewMap);
		gm.addObserver(viewMessage);
		
		setLayout(new BorderLayout());
		
		Command changeStrategiesCommand = new Command("Change Strategies") {
			@Override
			public void actionPerformed(ActionEvent evt) {
				gm.changeStrategy();
			}
		};
		
		Command moveCommand = new Command("Move") {
			@Override
			public void actionPerformed(ActionEvent evt) {
				gm.startMovingStudentPlayer();				
			}
		};
		Command stopCommand = new Command("Stop") {
			@Override
			public void actionPerformed(ActionEvent evt) {
				gm.stopMovingStudentPlayer();
			}
		};
		Command turnLeftCommand = new Command("Turn Left") {
			@Override
			public void actionPerformed(ActionEvent evt) {
				gm.turnLeftStudentPlayer();
			}
		};
		Command turnRightCommand = new Command("Turn Right") {
			@Override
			public void actionPerformed(ActionEvent evt) {
				gm.turnRightStudentPlayer();
			}
		};
		Command lectureHallCommand = new Command("Lecture Hall") {
			@Override
			public void actionPerformed(ActionEvent evt) {
				gm.collisionWithLectureHall();
			}
		};
		Command restroomCommand = new Command("Restroom") {
			@Override
			public void actionPerformed(ActionEvent evt) {
				gm.collisionWithRestroom();
			}
		};
		Command waterDispenserCommand = new Command("Water Dispenser") {
			@Override
			public void actionPerformed(ActionEvent evt) {
				gm.collisionWithWaterDispenser();
			}
		};
		Command studentCommand = new Command("Student") {
			@Override
			public void actionPerformed(ActionEvent evt) {
				gm.handleStudentCollision(getStudentIndexFromUser());
			}
		};
		Command nextFrameCommand = new Command("Next Frame") {
			@Override
			public void actionPerformed(ActionEvent evt) {
				gm.advanceToNextFrame();
			}
		};
		Command aboutCommand = new Command("About" ) {
			@Override
			public void actionPerformed(ActionEvent evt) {
				Dialog.show("A2 My Name", "This Semester", "Confirm", null);
			}
		};
		Command exitcommand = new Command("Exit") {
			@Override
			public void actionPerformed(ActionEvent evt) {
				CN.exitApplication();
			}
		};
		
		Toolbar toolbar = getToolbar();
        toolbar.addCommandToSideMenu(changeStrategiesCommand);
        toolbar.addCommandToSideMenu(aboutCommand);
        toolbar.addCommandToSideMenu(exitcommand);
        
        toolbar.addCommandToOverflowMenu(lectureHallCommand);
		toolbar.addCommandToOverflowMenu(aboutCommand);
        
		Container buttonsContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		
		buttonsContainer.add(makeStyledButton(moveCommand));
		buttonsContainer.add(makeStyledButton(stopCommand));
		buttonsContainer.add(makeStyledButton(turnLeftCommand));
		buttonsContainer.add(makeStyledButton(turnRightCommand));
		buttonsContainer.add(makeStyledButton(changeStrategiesCommand));
		buttonsContainer.add(makeStyledButton(lectureHallCommand));
		buttonsContainer.add(makeStyledButton(restroomCommand));
		buttonsContainer.add(makeStyledButton(waterDispenserCommand));
		buttonsContainer.add(makeStyledButton(studentCommand));
		buttonsContainer.add(makeStyledButton(nextFrameCommand));
		
		add(BorderLayout.CENTER, viewMap);
		add(BorderLayout.EAST, viewStatus);
		add(BorderLayout.WEST, buttonsContainer);
		add(BorderLayout.SOUTH, viewMessage);		
		show();
	}
	
	private Button makeStyledButton(Command cmd) {
		Button button = new Button(cmd);
		button.setOpaque(true);
		button.getAllStyles().setBgColor(0x0000FF);
		button.getAllStyles().setFgColor(0xffffff);
		return button;
	}
	
	private int getStudentIndexFromUser() {
		Dialog inputDialog=new Dialog("Enter student index for collision");
		Command submitCommand = new Command("Submit");
		Button submitButton=new Button(submitCommand);
		inputDialog.setLayout(BoxLayout.y());
		Container c=new Container(); 
		c.setLayout(BoxLayout.x());
		inputDialog.add(new SpanLabel("Enter sttudent index for collision", "DialogBody"));
		
		TextField inputField = new TextField();
		c.add(inputField).add(submitButton);
		inputDialog.add(c);
		inputDialog.setDisposeWhenPointerOutOfBounds(true);
		int i;
		if(inputDialog.showDialog() == submitCommand) {
			try {
				i = Integer.parseInt(inputField.getText().trim());
			} catch(NumberFormatException e) {
				Dialog.show("Invalid Input", "Received Invalid Input for Student Index.", "OK", null);
				return -1;
			}
		} else {
			Dialog.show("Invalid Input", "Received Invalid Input for Student Index.", "OK", null);
		    i = -1;
		}
		return i;
	}
	
	private void handleInput(char key) {
		switch (key) {
        case 'w':
            gm.startMovingStudentPlayer();
            break;
        case 's':
            gm.stopMovingStudentPlayer();
            break;
        case 'a':
            gm.turnLeftStudentPlayer();
            break;
        case 'd':
            gm.turnRightStudentPlayer();
            break;
        case '1':
            gm.collisionWithLectureHall();
            break;
        case '2':
            gm.collisionWithRestroom();
            break;
        case '3':
            gm.collisionWithWaterDispenser();
            break;
        case '4':
            gm.collisionWithRandomStudent();
            break;
        case 'f':
            gm.advanceToNextFrame();
            break;
        case 'm':
            gm.outputGameInformation();
            break;
        default:
            System.out.println("Invalid command. Please try again.");
            break;
    }
	}
		
}
