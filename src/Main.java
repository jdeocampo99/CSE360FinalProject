/**
 * Name			Rebecca Kraft
 *				Justin De Ocampo
 *				Kevin Weinhold
 *				Ishrar Zaman
 * 				Lingge Zhang
 *
 * Email 		rmkraft@asu.edu
 * 				jcdeocam@asu.edu
 * 				kweinho2@asu.edu
 *				izaman1@asu.edu
 * 				lzhan264@asu.edu
 *
 * Class		CSE 360	70605
 * Final Project
 *
 * This class displays a window that allows users to do some operations such as
 * load roster, add attendance, save, and plot data. Team information can be checked
 * in About menu.
 *
 * @author Justin De Ocampo, Rebecca Kraft
 *
 */

import javax.print.attribute.standard.JobPriority;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;



public class Main extends JFrame {
    public static JFrame frame;

    /**
     * Creates and makes the GUI visible
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("CSE 360 Final Project");
        //Adding the menu bar to the frame
        Menu_Bar m = new Menu_Bar();
        frame.setJMenuBar(m.createMenuBar());

        //Display the window.
        frame.setSize(800, 500);
        frame.setVisible(true);
    }

     /**
     * Main function that displays GUI.
     * @param args
     */
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
