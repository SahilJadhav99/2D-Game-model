package com.csus.csc133.gui;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.csus.csc133.GameData;

public class ViewMessage extends Container implements Observer{
	private Label messageLabel;
	public ViewMessage() {
		messageLabel = new Label("Message Label");
		add(messageLabel);
	}

	@Override
	public void update(Observable observable, Object data) {
		GameData gameData = (GameData)data;
		messageLabel.setText(gameData.status);
	}
}