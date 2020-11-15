import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    //Initializing gui elements
    static JMenuBar menubar;
    static JMenu file_menu, about_menu;
    static JMenuItem load_roster, add_attendance, save, plot_data;
    static JFrame frame;

    public static void main (String args[]){
        frame = new JFrame("CSE 360 Final Project");
        menubar = new JMenuBar();

        //TODO: Figure out how to change the color of the menu bar to white

        //initializing file menu and its items
        file_menu = new JMenu("File");
        load_roster = new JMenuItem("Load a Roster");
        add_attendance = new JMenuItem("Add Attendance");
        save = new JMenuItem("Save");
        plot_data = new JMenuItem("Plot Data");
        //Adding the menu items to the File menu
        file_menu.add(load_roster);
        file_menu.add(add_attendance);
        file_menu.add(save);
        file_menu.add(plot_data);

        //Initializing "about" menu
        about_menu = new JMenu("About");

        //add the menus to the menu bar
        menubar.add(file_menu);
        menubar.add(about_menu);

        //adding menu bar to the frame
        frame.setJMenuBar(menubar);

        //setting the size of the frame and making it visible
        frame.setSize(500,500);
        frame.setVisible(true);



    }
}
