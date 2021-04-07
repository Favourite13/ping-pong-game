package game;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import game.objects.Ball;
import game.objects.Brick;
import game.objects.GameObject;
import game.objects.ID;

public class Handler {
    private Set<GameObject> set = new HashSet<GameObject>();
    private Ball ball;
    private Game g;

    Handler(Game game) {
	this.g = game;
    }

    public void add(GameObject o) {
	set.add(o);
	if (o.id == ID.BALL) {
	    ball = (Ball) o;
	}
    }

    public void update() {
	for (GameObject el : set) {
	    el.update();
//	    System.out.println(el.id);
	    if (el.id.equals(ID.LEFT)) {
		el.setY(Game.clamp(el.getY(), 0, Game.HEIGHT - ((Brick) el).getSizeY() - 40));
	    }
	    if (!el.id.equals(ID.BALL)) {
		checkCollisions(el);
	    }
	}
    }

    public void render(Graphics g) {
	for (GameObject el : set) {
	    el.render(g);
	}
    }

    private void checkCollisions(GameObject el) {
	// walls Y
	if (ball.getY() <= 0) {
	    ball.setYPos();
	}
	if (ball.getY() >= (Game.HEIGHT - 3 * ball.getSize())) {
	    ball.setYNeg();
	}
	// bricks
	if (ball.getSpeedX() > 0) {
	    // speedX > 0 : right brick
	    if (el.id.equals(ID.RIGHT) && el.getX() <= ball.getX() + ball.getSize()
		    && el.getY() < ball.getY() + ball.getSize() && el.getY() + ((Brick) el).getSizeY() > ball.getY()) {
		ball.invX();
	    } else {
		if (el.id.equals(ID.RIGHT) && el.getX() <= ball.getX() + ball.getSize()
			&& (el.getY() > ball.getY() + ball.getSize()
				|| el.getY() + ((Brick) el).getSizeY() < ball.getY())) {
		    g.stop();
		}
	    }
	} else {
	    // else left
	    if (el.id.equals(ID.LEFT) && el.getX() + ((Brick) el).getSizeX() >= ball.getX()
		    && el.getY() < ball.getY() + ball.getSize() && el.getY() + ((Brick) el).getSizeY() > ball.getY()) {
		ball.invX();
	    } else {
		if (el.id.equals(ID.LEFT) && el.getX() + ((Brick) el).getSizeX() >= ball.getX()
			&& (el.getY() > ball.getY() + ball.getSize()
				|| el.getY() + ((Brick) el).getSizeY() < ball.getY())) {
		    g.stop();
		}
	    }
	}
    }
}
