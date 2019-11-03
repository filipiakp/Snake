package main;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class Canvas extends JPanel {

	private int width, tileWidth;
	private int[][] board;

	public Canvas(int width, int tileWidth, int boardSize) {
		super();
		this.width = width;
		this.tileWidth = tileWidth;
		setSize(width, width);
		board = new int[boardSize][boardSize];
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, width);
	}

	public void drawBoard(int[][] board) {
		this.board = board;
		paintComponent(getGraphics());
	}

	@Override
	public void paintComponent(Graphics g) {
		if (g != null) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (board[j][i] == 1) {
						g.setColor(Color.BLACK);
						g.fillRect(j * tileWidth, i * tileWidth, tileWidth, tileWidth);
					} else if (board[j][i] == 2) {
						g.setColor(Color.RED);
						g.fillRect(j * tileWidth, i * tileWidth, tileWidth, tileWidth);
					} else if (board[j][i] == 0) {
						g.setColor(Color.WHITE);
						g.fillRect(j * tileWidth, i * tileWidth, tileWidth, tileWidth);
					}
				}
			}
		} else {
			System.out.println("bylo null!");
		}

	}

}
