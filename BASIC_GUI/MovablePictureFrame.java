//package com.company;

// **********************************************************************
// * Name: Movable Picture Frame Class                                  *
// * Description: A class designed to create a graphical circle and     *
// *   draws it.                                                        *
// * Author: Luciano Zavala                                             *
// * Date: March 23th, 2021                                             *
// **********************************************************************

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class MovablePictureFrame extends JPanel
{
    private Ellipse2D.Double circleShape;
    private double x;
    private double y;
    protected boolean isToggled = false;

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //Centers the shape
        if(!isToggled)
        {
            x = (.5 * getWidth()) - (.15 * getWidth());
            y = (.5 * getHeight()) - (.15 * getHeight());
        }

        // sets the width and height to 30% of the frame
        double w = (.3 * getWidth());
        double h = (.3 * getHeight());

        //Create the object
        circleShape = new Ellipse2D.Double(x, y, w, h);

        //setts color and drawing circle
        g2d.setColor(Color.GREEN);
        g2d.fill(circleShape);

    }

    //sets the x coordinate
    public void setX(double xC)
    {
        x = xC - (.15 * getWidth());
    }

    //sets the  y coordinate
    public void setY(double yC)
    {
        y = yC - (.15 * getHeight());
    }
}