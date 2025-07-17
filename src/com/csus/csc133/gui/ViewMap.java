package com.csus.csc133.gui;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.csus.csc133.GameModel;

public class ViewMap extends Container implements Observer{
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(0xFF0000);
        g.drawRect(getX(), getY(), getWidth() - 1, getHeight() - 1);
    }

	@Override
	public void update(Observable observable, Object data) {
		GameModel game = (GameModel)observable;
		game.outputGameInformation();
	}
}
