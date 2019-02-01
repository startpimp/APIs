package org.game2d.screen;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import org.game2d.Display;
import org.game2d.entities.Entity;
import org.game2d.manager.KeyManager;

public class Panel extends JPanel implements Runnable {
	ArrayList<Entity> entities = new ArrayList<Entity>();
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running;
	private int totalFrameCount = 0;
	private long targetTime;
	private BufferedImage img;
	private Graphics2D g2d;
	private static KeyManager key = new KeyManager();
	public Panel() {
		setPreferredSize(new Dimension(Display.getWidth(), Display.getHeight()));
		addKeyListener(key);
	}
	private void setMaxFPS(int index) {targetTime = 1000 / index;}
	@Override 
	public void addNotify() {
		super.addNotify();
		thread = new Thread(this);
		thread.start();
	}
	@Override
	public void run() {
		TimerTask updateFPS = new TimerTask() {
			public void run() {totalFrameCount = 0;}
		};
		Timer t = new Timer();
		t.scheduleAtFixedRate(updateFPS, 1000, 1000);
		if (running)return;
		init();
		long startTime;
		long elapsed;
		long wait;
		Display.update();
		while (running) {
			startTime = System.nanoTime();
			update();
			requestRender();
			elapsed = System.nanoTime() - startTime;
			wait = targetTime - elapsed / 1000000;
			if (wait > 0) {try {Thread.sleep(wait);} catch (Exception e) {}}
			totalFrameCount++;
		}
	}
	private void setup() {
		for(int i = 0;i < entities.size();i++) {entities.get(i).setup();}
	}
	private void init() {
		img = new BufferedImage(Display.getWidth(), Display.getHeight(), BufferedImage.TYPE_INT_ARGB);
		g2d = img.createGraphics();
		running = true;
		setup();
		setMaxFPS(-1);
	}
	private void requestRender() {
		render(g2d);
		Graphics g = getGraphics();
		g.drawImage(img, 0, 0, null);
		g.dispose();
	}
	private void update() {
		for(int i = 0;i < entities.size();i++) {entities.get(i).update();}
	}
	private void render(Graphics2D g2d) {
		g2d.clearRect(0, 0, Display.width, Display.height);
		for(int i = 0;i < entities.size();i++) {entities.get(i).render(g2d);}
	}
	public int getFPS() {return totalFrameCount;}
	public void addEntity(Entity e) {entities.add(e);}
	public void clearList() {entities.clear();}
	public KeyManager getKeyManager() {return key;}
}
