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
				model.getPlayer().setDirection(0);
				break;
			case KeyEvent.VK_RIGHT:
				model.getPlayer().setDirection(1);
				break;
			case KeyEvent.VK_DOWN:
				model.getPlayer().setDirection(2);
				break;
			case KeyEvent.VK_LEFT:
				model.getPlayer().setDirection(3);
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
