package com.company;


import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class DrawingComponent extends JComponent {

    Ellipse2D.Double ball = new Ellipse2D.Double(100, 500, 40, 40);
    Rectangle hoop = new Rectangle(100, 500, 40, 40);
    Rectangle hoop2 = new Rectangle(300, 200, 40, 40);
    private boolean hitHoop1 = true;
    private boolean hitHoop2 = false;
    private int score = 0;
    private boolean isBeingRealigned = false;

    public DrawingComponent() {}


    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;


        g2.setFont(new Font("not sure", Font.BOLD, 40));
        g2.drawString("" + score, 290, 50);
        g2.setColor(new Color(240, 117, 45));
        g2.fill(ball);
        g2.setColor(new Color(240, 12, 87));
        g2.setStroke(new BasicStroke(5));
        g2.draw(hoop);
        g2.draw(hoop2);

    }

    public void moveBall2(double xChange, double yChange) {

        ball.x += xChange;
        ball.y -= yChange;


        if(xChange != 0 || yChange != 0){
            hitHoop1 =false;
            hitHoop2 = false;
        }

        if (hoop2ContainsBall(hoop2, ball.x, ball.y)) {
            ball.x = hoop2.x;
            ball.y = hoop2.y;
            hitHoop2 = true;
            DunkShotRunner.setInitalChanges(0, 0);

        }

        if (hoopContainsBall(hoop, ball.x, ball.y)) {
            ball.x = hoop.x;
            ball.y = hoop.y;
            hitHoop1 = true;
            DunkShotRunner.setInitalChanges(0, 0);
        }

        if (!hitHoop1 && !hitHoop2) {
            DunkShotRunner.decreaseY();
        }

        if(hitHoop2 && hoop2.y >= 647){
            score++;
        }
    }

    public boolean hoopContainsBall(Rectangle hoop, double ballX, double ballY) {
        if (hoop.getX() <= ballX && hoop.getX() + hoop.getWidth() >= ballX && hoop.getY() <= ballY && hoop.getY() + hoop.getHeight() >= ballY) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hoop2ContainsBall(Rectangle hoop, double ballX, double ballY) {
        if (hoop.getX() -20 <= ballX && hoop.getX() + hoop.getWidth() >= ballX && hoop.getY() -20 <= ballY && hoop.getY() + hoop.getHeight() >= ballY) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isOut(){
        if(ball.x >= 560 || ball.x <= 0){
            return true;
        }else
            return false;
    }

    public double getBallY() {
        return ball.getY();
    }

    public double getHoopX() {
        return hoop.getX();
    }

    public double getHoopY() {
        return hoop.getY();
    }

    public boolean isInHoop2(){
        return hitHoop2;
    }

    public int getScore(){
        return score;
    }

    public void reset() {
        ball = new Ellipse2D.Double(100, 500, 40, 40);
        hoop = new Rectangle(100, 500, 40, 40);
        hoop2 = new Rectangle(300, 200, 40, 40);
        hitHoop1 = true;
        hitHoop2 = false;
        score = 0;
        isBeingRealigned = false;
    }

    public void realign(){
        if(ball.y < 650){
            ball.y += 3;
            hoop.y += 3;
            hoop2.y += 3;
            isBeingRealigned = true;
        }

        if(ball.y >= 650){
            hoop = hoop2;
            hoop2 = new Rectangle( (int)(20 + Math.random() * 550), (int)(125 + Math.random() * 425), 40, 40);
            hitHoop2 = false;
            hitHoop1 = true;
            isBeingRealigned = false;
        }
    }

    public boolean getRealgined() {
        return isBeingRealigned;
    }
}
