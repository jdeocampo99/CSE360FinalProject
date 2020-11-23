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
            //chooses the attendance CSV and reads from it
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
                //TODO: add to the previous JTable

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

    public String pickDate(){

        String input = createWindow();


        System.out.println("Hey THere");

        return input;
    }
    private static String createWindow() {
        final String[] input = {""};
        JFrame frame = new JFrame("Swing Tester");
        JTextField jt = new JTextField("Enter Date");
        frame.add(jt);
        jt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get date as a string
                input[0] = jt.getText();
                System.out.println(input[0]);

                // Update the original file with new Columns of the date we chose
                data.updateColumns(input[0]);

            }
        });


        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        System.out.println(input[0]);
        return input[0];
    }

}
