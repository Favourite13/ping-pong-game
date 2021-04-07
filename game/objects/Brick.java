package game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Brick extends GameObject {

    private int sizeX, sizeY, speed;
    public ID id;
    public boolean up;
    public boolean down;

    public Brick(int x, int y, int sizeX, int sizeY, int speed, ID id, Color color) {
	super(x, y, id, color);
	this.sizeX = sizeX;
	this.sizeY = sizeY;
	this.speed = speed;
	this.up = false;
	this.down = false;
    }

    public void move() {
	if (up) {
	    this.y -= speed;
	}
	if (down) {
	    this.y += speed;
	}
    }

    @Override
    public void render(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2d.setPaint(super.color);
	g2d.fillRect(super.x, super.y, this.sizeX, this.sizeY);
    }

    @Override
    public void update() {
	this.move();
    }

    public int getSizeY() {
	return this.sizeY;
    }

    public int getSizeX() {
	return this.sizeX;
    }
}
