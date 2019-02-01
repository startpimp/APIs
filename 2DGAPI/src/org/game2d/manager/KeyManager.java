package org.game2d.manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	private int key;
	private boolean typing;

	@Override
	public void keyPressed(KeyEvent e) {typing = true;}

	@Override
	public void keyReleased(KeyEvent e) {typing = false;}

	@Override
	public void keyTyped(KeyEvent e) {key = e.getKeyCode();}

	public int getKey() {return key;}
	public boolean isTyping() {return typing;}

}
