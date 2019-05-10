/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import domain.Point;
import domain.Square;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javafx.scene.control.ProgressBar;
import javax.swing.JFrame;

/**
 *
 * @author Fabian
 */
public class LandFrame extends JFrame {

    //variables
    public ArrayList<Square> mySquares;

    //constructor
    public LandFrame(ArrayList<Square> mySquares) {
        super("Shape");

        this.mySquares = mySquares;
        this.setSize(700, 700);
        this.setVisible(true);
    }

    public void x() {
        ProgressBar jp = new ProgressBar(100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //iterate over all squares
        for (Square mySquare : mySquares) {
            g.setColor(Color.blue);
            g.fillRect(mySquare.getPointPosition().getX(), mySquare.getPointPosition().getY(), mySquare.getSizeX(), mySquare.getSizeY());
        } //end for
        g.setColor(Color.BLUE);
        g.drawRect(50, 70, 600, 50);
        
        g.setColor(Color.MAGENTA);
        g.drawRect(50, 200, 600, 75);
        
        g.setColor(Color.green);
        g.drawRect(50, 350, 600, 100);
        
        g.setColor(Color.RED);
        g.drawRect(50, 500, 600, 25);
        
        g.drawString("Thread 1", 50, 60);
        g.drawString("Thread 2", 50, 190);
        g.drawString("Thread 3", 50, 340);
        g.drawString("Thread 4", 50, 490);
    }

    public void paintAgain() {
        repaint();
    }

}
