import javax.print.attribute.standard.JobPriority;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;



public class Main extends JFrame {
    static JFrame frame;

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