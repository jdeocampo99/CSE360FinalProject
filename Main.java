import javax.print.attribute.standard.JobPriority;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Main extends JFrame implements ActionListener {
    //Initializing gui elements
    static JMenuBar menubar;
    static JMenu file_menu, about_menu;
    static JMenuItem load_roster, add_attendance, save, plot_data, about_team;
    static JFrame frame;
    JTextArea infopage;
    String message = "Team Members: Hank Hill from king of the hill";
    public JMenuBar createMenuBar()  {
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
        about_team = new JMenuItem("Team Information");
        about_menu.add(about_team);
        //add the menus to the menu bar
        menubar.add(file_menu);
        menubar.add(about_menu);
        menubar.setBackground(Color.WHITE);
        //adding menu bar to the frame
        frame.setJMenuBar(menubar);

        //setting the size of the frame and making it visible

        load_roster.addActionListener(this);
        about_team.addActionListener(this);
        return menubar;
    }
    public void actionPerformed(ActionEvent e) {

        JMenuItem command = (JMenuItem) (e.getSource());
        if (command.getText() == "Load a Roster")
        {

            final JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(null);
            File selectedFile = fc.getSelectedFile();

        }
        else if (command.getText() == "Team Information")
        {
            JOptionPane.showMessageDialog(infopage , message);
        }
    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("CSE 360 Final Project");
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main newFrame = new Main();
        frame.setJMenuBar(newFrame.createMenuBar());
        //Display the window.
        frame.setSize(500, 500);
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