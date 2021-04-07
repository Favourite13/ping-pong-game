package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.objects.Ball;
import game.objects.Brick;
import game.objects.GameObject;
import game.objects.ID;

public class Game extends Canvas implements Runnable {

    // constants
    private static final long serialVersionUID = 1334260311875361760L;
    private final String TITLE = "*ing *ong";
    public final static int WIDTH = 800;
    public final static int HEIGHT = 600;
    private final int FPS = 75;

    // ball
    private GameObject ball;
    private int ballX;
    private int ballY;
    private int ballSize;
    private int ballSpeed;
    private Color ballColor;

    // player1
    private GameObject left;
    private int leftX;
    private int leftY;
    private int leftSpeed;
    private int leftSizeX;
    private int leftSizeY;
    private Color leftColor;
    // player2
    private GameObject right;
    private int rightX;
    private int rightY;
    private int rightSpeed;
    private int rightSizeX;
    private int rightSizeY;
    private Color rightColor;
    // handler
    private Handler handler;
    // game
    private Color bg = Color.BLACK;
    private boolean running = false;
    // other
    private Thread thread;

    public Game() {
	this.handler = new Handler(this);
	new Window(Game.WIDTH, Game.HEIGHT, this.TITLE, this);

    }

    private void init() {
	running = true;
	ballInit();
	handler.add(ball);
	playersInit();
	handler.add(left);
	handler.add(right);
	this.addKeyListener(new KeyInput((Brick) left, (Brick) right));
    }

    private void ballInit() {
	ballX = WIDTH / 2;
	ballY = HEIGHT / 2;
	ballSize = 20;
	ballSpeed = 5;
	ballColor = Color.RED;
	ball = new Ball(ballX, ballY, ballSize, ballSpeed, ID.BALL, ballColor);
    }

    private void playersInit() {
	// player 1
	leftSizeX = 10;
	leftSizeY = 100;
	leftX = 0;
	leftY = HEIGHT / 2;
	leftSpeed = 1;
	leftColor = Color.GREEN;
	left = new Brick(leftX, leftY, leftSizeX, leftSizeY, leftSpeed, ID.LEFT, leftColor);
	// player 2
	rightSizeX = leftSizeX;
	rightSizeY = leftSizeY;
	rightX = WIDTH - 3 * rightSizeX + 4;
	rightY = HEIGHT / 2;
	rightSpeed = leftSpeed;
	rightColor = Color.GRAY;
	right = new Brick(rightX, rightY, rightSizeX, rightSizeY, rightSpeed, ID.RIGHT, rightColor);
    }

    @Override
    public void run() {
	long start = System.nanoTime();
	double fpns = FPS / 10E8;
	double delta = 0d;
	while (running) {
	    long end = System.nanoTime();
	    delta += (end - start) * fpns;
	    start = end;
	    while (delta >= 1) {
		update();
		render();
		delta--;
	    }
	}
    }

    private void render() {
	BufferStrategy bs = this.getBufferStrategy();
	if (bs == null) {
	    this.createBufferStrategy(3);
	    return;
	}
	Graphics g = bs.getDrawGraphics();
	g.setColor(bg);
	g.fill3DRect(0, 0, WIDTH, HEIGHT, true);
	//
	handler.render(g);
	//
	g.dispose();
	bs.show();
    }

    private void update() {
	handler.update();
    }

    // say we have a span [-3;+3] and we're in the middle at 2
    // then we remain at two
    // say we jumped to +88 then we get back to +3
    // same with -14 – we get back to -3
    // only for y which is this.HEIGHT
    public static int clamp(int val, int min, int max) {
	if (val > max) {
	    return max;
	}
	if (val < min) {
	    return min;
	}
	return val;
    }

    public static void main(String[] args) {
	startGame();
    }

    private static void startGame() {
	new Game();
    }

    public synchronized void start() {
	thread = new Thread(this);
	init();
	thread.start();
    }

    public synchronized void stop() {
	try {
	    thread.join();
	    running = false;
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

}
