//package com.company;

// **********************************************************************
// * Name: Handler Class                                                *
// * Description: A class designed to implement MouseMotionListener.    *                                 *
// * Author: Luciano Zavala                                             *
// * Date: March 23th, 2021                                             *
// **********************************************************************

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Handler extends MovablePictureFrame implements MouseMotionListener {
    MovablePictureFrame f;

    public Handler(MovablePictureFrame panel)
    {
        f = panel;
    }

    public void mouseMoved(MouseEvent e){}

    public void mouseDragged(MouseEvent e)
    {
        f.setX(e.getX());
        f.setY(e.getY());
        f.repaint();
    }
}
