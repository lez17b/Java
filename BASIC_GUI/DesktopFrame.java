//package com.company;

// **********************************************************************
// * Name: Desktop Frame App                                            *
// * Description: A code designed to create a graphical unit interphase *
// *  in which the user has four options: create a picture frame,       *
// *  create a movable picture frame, create a randomized picture or    *
// *  finally just quit the program.                                    *
// * Author: Luciano Zavala                                             *
// * Date: March 20th, 2021                                             *
// **********************************************************************

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class DesktopFrame extends JFrame
{
    private final JDesktopPane theDesktop;

    public DesktopFrame()
    {
        super("Homework 5");

        //Desktop Pane
        theDesktop = new JDesktopPane();

        //Menu Bar
        JMenuBar Jmenu = new JMenuBar();

        add(theDesktop);

        theDesktop.setBackground(Color.WHITE);

        //*********************************************************
        //***              Create option *MENU*                  **
        //*********************************************************

        JMenu createMenu = new JMenu("Create");
        createMenu.setMnemonic(KeyEvent.VK_C);

        JMenuItem picture_frame = new JMenuItem("Picture Frame", KeyEvent.VK_P);
        JMenuItem movablePicFrame = new JMenuItem("Movable Picture Frame", KeyEvent.VK_C);
        JMenuItem randomizedPicture = new JMenuItem("Randomized Picture", KeyEvent.VK_R);

        createMenu.add(picture_frame);
        createMenu.add(movablePicFrame);
        createMenu.add(randomizedPicture);


        //*********************************************************
        //***                Quit option *MENU*                  **
        //*********************************************************


        JMenu quitMenu = new JMenu("Quit");
        quitMenu.setMnemonic(KeyEvent.VK_Q);

        JMenuItem exit = new JMenuItem("Exit Program", KeyEvent.VK_X);

        quitMenu.add(exit);

        //Action to exit with the x key
        exit.addActionListener
                (
                        new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                System.exit(0);
                            }
                        }
                );

        //****************************** END *MENU* ***********************************

        // Action Listener to create a picture frame
        picture_frame.addActionListener
                (
                        new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                //Create the picture frame
                                JInternalFrame picFrame = new JInternalFrame("Picture Frame",
                                        true, true, true, true);

                                // Creates the panel
                                PictureFrame panel = new PictureFrame();

                                picFrame.setBackground(Color.BLUE);

                                // Sets the characteristics of the Frame
                                picFrame.setVisible(true);
                                picFrame.setSize((int)(0.7 * theDesktop.getWidth()),
                                        (int)(0.7 * theDesktop.getHeight()));

                                picFrame.setLocation(100,100);
                                picFrame.add(panel);
                                theDesktop.add(picFrame);
                            }
                        }
                );


        //Action Listener to create a Movable picture frame
        movablePicFrame.addActionListener
                (
                        new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent event)
                            {
                                //Frame creation
                                JInternalFrame frame = new JInternalFrame("Movable Picture Frame",
                                        true, true, true, true);

                                //Panel creation
                                MovablePictureFrame panel = new MovablePictureFrame();

                                //Handler class instantiation
                                Handler mouseHandler = new Handler(panel);

                                // Internal Menu
                                JMenuBar internalMenu = new JMenuBar();

                                //Check box item
                                JCheckBoxMenuItem dragCheck = new JCheckBoxMenuItem("Move on Drag");

                                //adding buttons to the internalMenu
                                internalMenu.add(dragCheck);

                                // Drag on Move action performed
                                dragCheck.addActionListener
                                        (
                                                new ActionListener()
                                                {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e)
                                                    {
                                                        if(dragCheck.isSelected())
                                                        {
                                                            panel.isToggled = true;
                                                            panel.addMouseMotionListener(mouseHandler);
                                                        }
                                                        else
                                                        {
                                                            panel.isToggled = false;
                                                            panel.removeMouseMotionListener(mouseHandler);

                                                            //Sets the X coordinates
                                                            panel.setX((.3 * panel.getWidth())
                                                                    - (.3 * panel.getWidth()));

                                                            //Sets the Y coordinates
                                                            panel.setY((.3 * panel.getHeight())
                                                                    - (.3 * panel.getHeight()));
                                                        }
                                                        panel.repaint();
                                                    }
                                                }
                                        );


                                // Sets the menu bar
                                frame.setJMenuBar(internalMenu);

                                frame.setVisible(true);
                                frame.setSize((int)(.5 * theDesktop.getWidth()), (int)(.7 * theDesktop.getHeight()));
                                frame.setLocation((int)(.5 * theDesktop.getWidth()), 0);
                                frame.add(panel);
                                theDesktop.add(frame);
                            }
                        }
                );


        //to create a randomized picture frame
        randomizedPicture.addActionListener
                (
                        new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent event)
                            {
                                // frame title and characteristics
                                JInternalFrame frame = new JInternalFrame("Randomized Picture",
                                        true, true, true, true);

                                // Randomized picture object
                                RandomizedPicture panel = new RandomizedPicture();

                                //Set configurations
                                frame.setVisible(true);
                                frame.setSize(theDesktop.getWidth(), (int)(.5 * theDesktop.getHeight()));
                                frame.setLocation(0, (int)(.5 * theDesktop.getHeight()));
                                frame.add(panel);
                                theDesktop.add(frame);
                            }
                        }
                );

        Jmenu.add(createMenu);
        Jmenu.add(quitMenu);
        setJMenuBar(Jmenu);
    }


}
