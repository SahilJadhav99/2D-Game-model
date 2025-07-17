package com.csus.csc133;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameObjectCollection implements Iterable<GameObject>{
	private ArrayList<GameObject> gameObjects;
	public GameObjectCollection() {
		gameObjects = new ArrayList<>();
	}
	
	public void add(GameObject gameObject) {
		gameObjects.add(gameObject);
	}

	public void remove(GameObject gameObject) {
		gameObjects.remove(gameObject);
	}
	
	public GameObject get(int i) {
		return gameObjects.get(i);
	}
	
	@Override
    public Iterator<GameObject> iterator() {
        return new GameObjectIterator();
    }
	
	class GameObjectIterator implements Iterator<GameObject> {
		private int index;
		@Override
		public GameObject next() { 
			return gameObjects.get(index++);
		}

		@Override
		public void remove() {
			gameObjects.remove(index--);
		}

		@Override
		public boolean hasNext() {
			return index < gameObjects.size();
		}
	}
}
