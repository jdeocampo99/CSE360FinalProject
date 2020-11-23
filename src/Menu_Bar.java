import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Menu_Bar extends Main implements ActionListener {
    //Initializing gui elements
    static JMenuBar menubar;
    static JMenu file_menu, about_menu;
    static JMenuItem load_roster, add_attendance, save, plot_data, about_team;

    //Renders the menu bar and its sub components
    public JMenuBar createMenuBar()  {
        menubar = new JMenuBar();
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
        menubar.setOpaque(true);
        menubar.setBackground(Color.WHITE);

        //adding event action listeners to each button in the menu
        load_roster.addActionListener(this);
        about_team.addActionListener(this);
        save.addActionListener(this);
        add_attendance.addActionListener(this);
        plot_data.addActionListener(this);

        return menubar;
    }

    /**
     * Event listener which listens for which button is pressed in the menu
     * @param e
     */
    public void actionPerformed(ActionEvent e) {

        JMenuItem command = (JMenuItem) (e.getSource());

        switch(command.getText()){
            case ("Load a Roster"):
                RosterLoader loader = new RosterLoader();
                loader.chooseFileAndReadInfo();
                break;
            case ("Save"):
                Saver save = new Saver();
                save.exportToCSV();
                break;
            case ("Add Attendance"):
                break;
            case("Plot Data"):
                break;
            case ("Team Information"):
                AboutMenu about_menu = new AboutMenu();
                about_menu.createAboutMenu();;
                break;

        }
    }
}
