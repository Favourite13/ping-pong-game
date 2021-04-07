package game.objects;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GameObject {
    protected Color color;
    protected int x, y;
    public ID id;

    public GameObject(int x, int y, ID id, Color color) {
	this.x = x;
	this.y = y;
	this.id = id;
	this.color = color;
    }

    public abstract void move();

    public int getX() {
	return this.x;
    }

    public int getY() {
	return this.y;
    }

    public abstract void render(Graphics g);

    public abstract void update();

    public void setX(int x) {
	this.y = x;
    }

    public void setY(int y) {
	this.y = y;
    }
}
