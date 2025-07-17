package com.csus.csc133.gui;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.csus.csc133.GameData;

public class ViewStatus extends Container implements Observer{
	Label label1, label2, label3, label4, label5, label6, label7;
	public ViewStatus() {
        // Set the layout for the custom container
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        // Create and add the labels to the container
        label1 = new Label("Lecture Hall : No class now");
        label2 = new Label("Lecture Time remain");
        label3 = new Label("Game Time");
        label4 = new Label("Absence");
        label5 = new Label("Hydration");
        label6 = new Label("WaterIntake");
        label7 = new Label("Hold");
        
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
    }

	@Override
	public void update(Observable observable, Object data) {
		GameData gameData = (GameData)data;
		
		label1.setText("Lecture Hall : " + gameData.lectureHallName);
		label2.setText("Lecture Time Remaining : " + gameData.lectureHallTime);
		label3.setText("Game Time : " + gameData.gameTime);
		label4.setText("Absence : " + gameData.numAbsences);
		label5.setText("Hydration : " + gameData.playerHydration);
		label6.setText("Water Intake : " + gameData.waterIntake);
		label7.setText("Hold : " + gameData.hold);
	}
}
