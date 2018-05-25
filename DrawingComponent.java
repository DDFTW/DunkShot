package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class DrawingComponent extends JComponent {

    Ellipse2D.Double ball = new Ellipse2D.Double(100,300,20,20);
    Rectangle hoop = new Rectangle(100,300,20,20);
    Rectangle hoop2 = new Rectangle(300,100, 40, 40);

    public DrawingComponent() {

    }

    //Constructors probably need to be removed or changed, useless right now
    public DrawingComponent(int xLoc, int yLoc, int height, int width) {ball = new Ellipse2D.Double(xLoc, yLoc, height, width); }

    public DrawingComponent(int height, int width) {
        ball = new Ellipse2D.Double(0, 0, height, width);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(new Color(240,12,87));
        g2.fill(ball);
        g2.draw(hoop);
        g2.draw(hoop2);

    }

    public void moveBall(double xChange, double yChange){
        boolean hitHoop = false;
        while(!hitHoop && ball.y <= 950) {
            double start = System.nanoTime();
            while(System.nanoTime() - start <  Math.pow(10, 9)){

            }
            ball.x += xChange;
            ball.y += yChange;
            //yChange -= 5
            if(hoopContainsBall(hoop2, ball.x, ball.y)){
                ball.x = hoop2.x;
                ball.y = hoop2.y;
                hitHoop = true;
            }
        }
    }

    public void moveBall2(double xChange, double yChange){
        ball.x += xChange;
        ball.y += yChange;
    }

    public boolean hoopContains(int mouseX, int mouseY) {
        if(hoop.getX() < mouseX && hoop.getX() + hoop.getWidth() > mouseX && hoop.getY() < mouseY && hoop.getY() + hoop.getHeight() < mouseY) {
            return true;
        }else {
            return false;
        }
    }

    public boolean hoopContainsBall(Rectangle in, double ballX, double ballY) {
        if(in.getX() < ballX && in.getX() + in.getWidth() > ballX && in.getY() < ballY && in.getY() + in.getHeight() < ballY) {
            return true;
        }else {
            return false;
        }
    }

    public void setBallLocation(int xLoc, int yLoc) {
        ball.x = xLoc;
        ball.y = yLoc;
    }

    public double getHoopX(){
        return hoop.getX();
    }

    public double getHoopY(){
        return hoop.getY();
    }

    public void setHoopLocation(int xLoc, int yLoc) {
        hoop = new Rectangle(xLoc, yLoc, 20, 20);
    }

    public void setHoop2Location(int xLoc, int yLoc) {
        hoop2 = new Rectangle(xLoc, yLoc, 20, 20);
    }








}
