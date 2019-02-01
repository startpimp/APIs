package org.game2d;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;

import org.game2d.screen.Panel;

public class Display {
	public static int width = 0, height = 0, x, y;
	private static String title;
	private static boolean visible = true, focusable = false, undecorated = false, resizable = true;
	private static Cursor cursor = null;
	private static Color color = null;
	private static Image image = null;
	private static Panel p;
	static JFrame j = new JFrame();
	public static void create() {
		Display.update();
		j.setVisible(true);
		j.setContentPane(p = new Panel());
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void destroy() {
		j.dispose();
		System.exit(0);
	}
	public static void update() {
		j.setTitle(title);
		j.setVisible(visible);
		j.setSize(width, height);
		j.setPreferredSize(new Dimension(width, height));
		j.setFocusable(focusable);
		j.setCursor(cursor);
		j.setBackground(color);
		j.setIconImage(image);
		if(!j.isDisplayable()) {j.setUndecorated(undecorated);}
		j.setLocationRelativeTo(null);
		j.setResizable(resizable);
		j.pack();
	}
	
	// Getters and Setters
	public static int getWidth() {return j.getWidth();}
	public static int getHeight() {return j.getHeight();}
	public static int getX() {return x;}
	public static int getY() {return y;}
	public static boolean isVisible() {return visible;}
	public static boolean isFocusable() {return focusable;}
	public static boolean isUndecorated() {return undecorated;}
	public static boolean isResizable() {return resizable;}
	public static String getTitle() {return title;}
	public static Cursor getCursor() {return cursor;}
	public static Image getIcon() {return image;}
	public static Color getBackground() {return color;}
	public static Panel getPanel() {return p;}
	
	public static void setWidth(int width) {Display.width = width;}
	public static void setHeight(int height) {Display.height = height;}
	public static void setX(int x) {Display.x = x;}
	public static void setY(int y) {Display.y = y;}
	public static void setPosition(int x, int y) {Display.x = x;Display.y = y;}
	public static void setVisible(boolean visible) {Display.visible = visible;}
	public static void setFocusable(boolean focusable) {Display.focusable = focusable;}
	public static void setUndecorated(boolean undecorated) {Display.undecorated = undecorated;}
	public static void setResizable(boolean resizable) {Display.resizable = resizable;}
	public static void setTitle(String title) {Display.title = title;}
	public static void setCursor(Cursor cursor) {Display.cursor = cursor;}
	public static void setIcon(Image image) {Display.image = image;}
	public static void setBackgroundColor(Color color) {Display.color = color;}
}
