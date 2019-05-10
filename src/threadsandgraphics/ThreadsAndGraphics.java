/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsandgraphics;

import visual.LandFrame;
import threads.RepaintLandThread;
import threads.SquareThread;
import domain.Point;
import domain.Square;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author root
 */
public class ThreadsAndGraphics {

    public static void main(String[] args) {
        //Speeds
        int speedSlow =20, speedMedium=10, speedFast=5;
        
        
        //create the domain squares
        Square square1 = new Square("Thread-1", new Point(50, 70), 50, 50);
        Square square2 = new Square("Thread-2", new Point(50, 200), 50, 75);
        Square square3 = new Square("Thread-3", new Point(50, 350), 50, 100);
        Square square4 = new Square("Thread-3", new Point(50, 500), 50, 25);

        //create the array list for the frame to paint
        ArrayList<Square> squareList = new ArrayList<>();
        squareList.add(square1);
        squareList.add(square2);
        squareList.add(square3);
        squareList.add(square4);


        //create the new frame and send the square list
        SquareThread st = new SquareThread();
        LandFrame myLand = new LandFrame(squareList);
        myLand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //thread for repainting
        RepaintLandThread repaintThread = new RepaintLandThread(myLand, 100);
        repaintThread.start();

        //thread for controlling the movement of the squares
        SquareThread squareThread1 = new SquareThread(square1, speedFast);
        SquareThread squareThread2 = new SquareThread(square2, speedMedium);
        SquareThread squareThread3 = new SquareThread(square3, speedSlow);
        SquareThread squareThread4 = new SquareThread(square4, speedMedium);
        squareThread1.start();
        squareThread2.start();
        squareThread3.start();
        squareThread4.start();
    }//end main

}
