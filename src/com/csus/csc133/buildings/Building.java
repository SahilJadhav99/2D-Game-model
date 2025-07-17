package com.csus.csc133.buildings;

import com.csus.csc133.GameObject;

public abstract class Building extends GameObject {
    public Building(int x, int y) {
        super(x, y);
    }

    @Override
    public void move() {
        // Buildings do not move, so this method is empty
    }

    public String getGameInformation() {

        String className = getClass().getSimpleName();
        String position = "(" + x + ", " + y + ")";
        return className + ", " + "pos " + position ;
    }
    
   
}