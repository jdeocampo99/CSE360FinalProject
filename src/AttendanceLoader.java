import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AttendanceLoader extends Menu_Bar {
    File selectedFile = null;
    static ArrayList<String[]> tableInfo = new ArrayList<>();

    public void chooseAttendanceFile(){
        try{
            final JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                selectedFile = fc.getSelectedFile();

                //read through the selected file and save each row as an array of strings
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                String line;
                String[] current_row;
                //Save each row as an array of strings, add that to our final array list
                while ((line = reader.readLine()) != null){
                    current_row = line.split(",");
                    tableInfo.add(current_row);
                }
                //add to the previous JTable

            }
        }
        //Catching errors
        catch(FileNotFoundException e){
            System.out.println("Error: file not found!");
        }
        catch(IOException e){
            System.out.println("Error: Invalid CSV");
        }
    }
    public static JButton inputButton = new JButton("Send");
    public static JTextArea editTextArea = new JTextArea("Type Here!");
    public static JTextArea uneditTextArea = new JTextArea();

    public void pickDate(){
        createWindow();

        System.out.println("Hey THere");
    }
    private static void createWindow() {
        JFrame frame = new JFrame("Swing Tester");
        JTextField jt = new JTextField("Enter Date");
        frame.add(jt);
        jt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get date as a string
                String input = jt.getText();
                System.out.println(input);
            }
        });
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private static void createUI(final JFrame frame){
//        JPanel panel = new JPanel();
//        LayoutManager layout = new FlowLayout();
//        panel.setLayout(layout);
        JButton button = new JButton("Click here");

    }
}
