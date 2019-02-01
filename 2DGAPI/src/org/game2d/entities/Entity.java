package org.game2d.entities;

import java.awt.Graphics2D;

public interface Entity {
	public abstract void update();
	public abstract void render(Graphics2D g2d);
	public abstract void setup();
}
