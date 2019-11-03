package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener {

	private Model model;

	public KeyController(Model model) {
		this.model = model;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				model.getPlayer().setDirection(Direction.UP);
				break;
			case KeyEvent.VK_RIGHT:
				model.getPlayer().setDirection(Direction.RIGHT);
				break;
			case KeyEvent.VK_DOWN:
				model.getPlayer().setDirection(Direction.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				model.getPlayer().setDirection(Direction.LEFT);
				break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
