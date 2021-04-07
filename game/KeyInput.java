package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.objects.Brick;

public class KeyInput extends KeyAdapter {
    private Brick left, right;

    public KeyInput(Brick left, Brick right) {
	this.left = left;
	this.right = right;
    }

    public void keyPressed(KeyEvent e) {
	switch (e.getKeyCode()) {
	case KeyEvent.VK_W:
	    this.left.up = true;
	    break;
	case KeyEvent.VK_S:
	    this.left.down = true;
	    break;
	case KeyEvent.VK_UP:
	    this.right.up = true;
	    break;
	case KeyEvent.VK_DOWN:
	    this.right.down = true;
	    break;
	}
    }

    public void keyReleased(KeyEvent e) {
	switch (e.getKeyCode()) {
	case KeyEvent.VK_W:
	    this.left.up = false;
	    break;
	case KeyEvent.VK_S:
	    this.left.down = false;
	    break;
	case KeyEvent.VK_UP:
	    this.right.up = false;
	    break;
	case KeyEvent.VK_DOWN:
	    this.right.down = false;
	    break;
	}
    }
}
