package org.game2d.manager;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CursorManager implements MouseListener {
	static Toolkit tool = Toolkit.getDefaultToolkit();
	public static Cursor setCursor(String cursorFileName) {
		Image img = tool.getImage(cursorFileName);
		Point point = new Point(0,0);
		Cursor cursor = tool.createCustomCursor(img, point, "Cursor");
		return cursor;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
