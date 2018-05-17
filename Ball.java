import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Ball extends JComponent {
		//Ellipse2D.Double ball = new Ellipse2D.Double((int)(20 + 360*Math.random()), 350, 20, 20);
	 private int x;
	 private int y;
	 private int xChange;
	 private int yChange;
	 private double gConstant = -9.8;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		x = (int)(20 + 360*Math.random());
		
		g2.setColor(Color.ORANGE);
		g2.fillOval(x, 350, 20, 20);
		
	}
	
	public void calculateChanges(double power) {
	//	xChange = (int) (power* Math.acos(a) )
		//need angle 
	}
	
	public  boolean contain(int xIn, int yIn) {
		if(xIn > x && xIn < x + 20 && yIn > y && yIn < y+20) {
			return true;
		}else
			return false;
	}
	
	public boolean isInMotion() {
		if(xChange == 0 && yChange == 0)
			return false;
		else
			return true;
	}
	
	public void move() {
		for(int i = 0; y <= 600 /*&& isInBasket == false */; i ++) {
			x += xChange;
			y += yChange;
			yChange -= 40;
			repaint();
		}
	}
	
	public void moveTemp(int changeXIn, int changeYIn) {
		for(int i = 0; y <= 600 /*&& isInBasket == false */; i ++) {
			x += changeXIn;
			y += changeYIn;
			changeYIn -= 10;
			repaint();
		}
	}
	
}
