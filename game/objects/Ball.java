package game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Ball extends GameObject {

    private int size, speedX, speedY;

    public Ball(int x, int y, int size, int speed, ID id, Color color) {
	super(x, y, id, color);
	this.size = size;
	this.speedX = -speed;
	this.speedY = speed;
    }

    public void move() {
	this.x += speedX;
	this.y += speedY;
    };

    public void invX() {
	this.speedX *= -1;
    }

    public void invY() {
	this.speedY *= -1;
    }

    public int getSpeedX() {
	return this.speedX;
    }

    public int getSpeedY() {
	return this.speedY;
    }

    public int getSize() {
	return this.size;
    }

    public void setYPos() {
	this.speedY = this.speedY < 0 ? -this.speedY : this.speedY;
    }

    public void setYNeg() {
	this.speedY = this.speedY > 0 ? -this.speedY : this.speedY;
    }

    @Override
    public void render(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2d.setPaint(super.color);
	g2d.fillArc(super.x, super.y, size, size, 0, 360);
    }

    @Override
    public void update() {
	this.move();
    }

}
