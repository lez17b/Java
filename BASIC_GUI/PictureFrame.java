//package com.company;

// **********************************************************************
// * Name: Picture Frame Class                                          *
// * Description: A class designed to create and draw a picture frame.  *                                 *
// * Author: Luciano Zavala                                             *
// * Date: March 23th, 2021                                             *
// **********************************************************************

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class PictureFrame extends JPanel
{
    public void paintComponent(Graphics graph)
    {
        //Draws the circle
        Graphics2D G2D = (Graphics2D)graph;
        Ellipse2D.Double circle;
        G2D.setColor(Color.YELLOW);

        // Sets the coordinates, height and width
        if(this.getHeight() < this.getWidth())
        {
            circle = new Ellipse2D.Double(.7 * this.getWidth(), .1 * this.getHeight()
                    , .25 * this.getHeight(), .25 * this.getHeight());
        }
        else
            circle = new Ellipse2D.Double(.7 * this.getWidth(), .1 * this.getHeight()
                    , .25 * this.getWidth(), .25 * this.getWidth());

        G2D.fill(circle);

        //Draws the brow rectangle
        G2D.setColor(new Color(140,66,19));
        double x = 0;
        double y = (.8 * this.getHeight());
        double w = this.getWidth();
        double h = (.2 * this.getHeight());

        Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, w, h);

        G2D.fill(rectangle);


    }
}