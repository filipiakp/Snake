package main;

import java.awt.*;
import java.util.ArrayList;

public class Player {

	private int direction = 0;//0-up 1-right 2-down 3-left
	private ArrayList<Point> tiles;
	private int tilesAdded = 0;

	public Player(int x, int y) {
		tiles = new ArrayList<Point>();
		tiles.add(new Point(x, y));
	}

	public void addTile() {
		Point last = tiles.get(tiles.size() - 1);
		tiles.add(new Point((int) last.getX(), (int) last.getY()));
		tilesAdded++;
	}

	public Point getHead() {
		return tiles.get(0);
	}

	public void moveAll() {
		int size = tiles.size() - tilesAdded;
		if (tilesAdded > 0)
			tilesAdded--;
		for (int i = size - 1; i > 0; i--) {
			Point prev = tiles.get(i - 1);
			tiles.get(i).setLocation(prev.getX(), prev.getY());
		}

	}

	public ArrayList<Point> getTiles() {
		return tiles;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
