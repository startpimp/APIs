package org.game2d.manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	private int key;
	private boolean typing;

	@Override
	public void keyPressed(KeyEvent e) {typing = true;
	System.out.println("Key pressed");}

	@Override
	public void keyReleased(KeyEvent e) {typing = false;}

	@Override
	public void keyTyped(KeyEvent e) {key = e.getKeyCode();
	System.out.println("Typing");}

	public int getKey() {return key;}
	public boolean isTyping() {return typing;}

}
