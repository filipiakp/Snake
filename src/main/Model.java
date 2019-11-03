package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Model {

	private Player player;
	private boolean isRunning;
	private int BOARD_SIZE;
	private int[][] board;
	private Point treat;
	private Canvas canvas;

	Model(int boardSize, Canvas canvas) {
		isRunning = true;
		BOARD_SIZE = boardSize;
		board = new int[BOARD_SIZE][BOARD_SIZE];
		treat = new Point(0, 0);
		player = new Player(BOARD_SIZE / 2, BOARD_SIZE / 2);
		this.canvas = canvas;

		player.addTile();
		addTreat();
	}

	private void addTreat() {
		Random random = new Random();
		int rndX, rndY;
		do {
			rndX = random.nextInt(BOARD_SIZE);
			rndY = random.nextInt(BOARD_SIZE);

			if (board[rndX][rndY] == 0) {
				treat.setLocation(rndX, rndY);
				board[rndX][rndY] = 2;
				break;
			}
		} while (true);

	}

	private boolean isCollisionDetected() {
		if (player.getHead().getX() == treat.getX() && player.getHead().getY() == treat.getY()) {
			board[(int) treat.getX()][(int) treat.getY()] = 1;
			player.addTile();
			addTreat();
		}
		ArrayList<Point> plTiles = player.getTiles();
		for (int i = 1; i < plTiles.size(); i++) {
			if (plTiles.get(i).getLocation().equals(plTiles.get(0).getLocation()))
				return true;
		}
		return false;
	}

	public void update() {
		//clear the board
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = 0;
			}
		}
		player.moveAll();

		double headX = player.getHead().getX(),
				headY = player.getHead().getY();

		switch (player.getDirection()) {
			case 0:
				player.getHead().setLocation(headX, headY <= 0 ? BOARD_SIZE - 1 : headY - 1);
				break;
			case 1:
				player.getHead().setLocation(headX == BOARD_SIZE - 1 ? 0 : headX + 1, headY);
				break;
			case 2:
				player.getHead().setLocation(headX, headY == BOARD_SIZE - 1 ? 0 : headY + 1);
				break;
			case 3:
				player.getHead().setLocation(headX <= 0 ? BOARD_SIZE - 1 : headX - 1, headY);
				break;
		}

		for (Point st : player.getTiles()) {
			board[(int) st.getX()][(int) st.getY()] = 1;

		}
		board[(int) treat.getX()][(int) treat.getY()] = 2;

		if (isCollisionDetected()) {
			JOptionPane.showMessageDialog(canvas, "Game over.\nYou earned " + getPointsEarned() + " points!");
			isRunning = false;
		}

		canvas.drawBoard(board);
	}

	public Player getPlayer() {
		return player;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public int getPointsEarned() {
		return player.getTiles().size() - 2;
	}
}
