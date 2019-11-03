package main;

import javax.swing.*;

public class Main {

	static final int START_INTERVAL = 300;//miliseconds between frames
	static final int BOARD_SIZE = 11;
	static final int TILE_WIDTH = 50;
	static final int FRAME_WIDTH = TILE_WIDTH * BOARD_SIZE;
	private Canvas canvas;
	private JFrame frame;
	private Model model;
	private KeyController controller;


	public Main() {

		canvas = new Canvas(FRAME_WIDTH, TILE_WIDTH, BOARD_SIZE);
		frame = new JFrame();
		model = new Model(BOARD_SIZE, canvas);
		controller = new KeyController(model);

		frame.setContentPane(canvas);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas.addKeyListener(controller);
		canvas.setFocusable(true);
		canvas.requestFocus();

		//game loop
		while (model.isRunning()) {
			try {
				model.update();
				Thread.sleep(START_INTERVAL - model.getPointsEarned());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
