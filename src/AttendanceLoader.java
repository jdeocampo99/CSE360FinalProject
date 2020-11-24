import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AttendanceLoader extends Menu_Bar {


    File selectedFile = null;
    Vector<String> times = new Vector<>();
    static ArrayList<String[]> attendanceInfo = new ArrayList<>();
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
                    attendanceInfo.add(current_row);
                    // will probably have to do my times vector calculation here ish
                    //System.out.println("\n\nTable Info: \n" + tableInfo + "\n\n Attendance Info: \n" + attendanceInfo);
                }

                //TODO: add to the previous JTable
                // go through rows, maybe start after the row that contains [ASURITE time]

                Object[] arr = tableInfo.toArray();
                System.out.println("\n\nArrays.toString(tableInfo.toArray()) \n " + Arrays.toString(tableInfo.toArray()));
                System.out.println("\n\ntableInfo.size() \n " + tableInfo.size() + "\nArrays.toString(attendanceInfo.toArray())\n" + Arrays.toString(attendanceInfo.toArray()));
                for(int i = 0; i < tableInfo.size(); i++){
                    // EDIT the times vector here!
                    //if tableInfo name matches attendanceInfo Name
                    for(int j = 0; j < attendanceInfo.size(); j++){
                        System.out.println("\ntableInfo.get(i)[1]: " + tableInfo.get(i)[5]
                        + "\nattendanceInfo.get(j)[0]): " + attendanceInfo.get(j)[0] + "\n");
                        if(tableInfo.get(i)[5].equals(attendanceInfo.get(j)[0])){
                            // add the appropiate time to the times vector
                            System.out.println("times.add BRO");
                            times.add(attendanceInfo.get(j)[1]);
                        }
                    }
                }
                System.out.println("\n Times values in attendanceFile: " + times.toString());

                Vector<Integer> temp = new Vector<>();
                temp.add(10);
                temp.add(20);
                temp.add(30);
                pickDate(times);
                //data.updateColumns(date, times);
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

    public String pickDate(Vector<String> times){

        String input = createWindow(times);


        System.out.println("Hey THere");

        return input;
    }

    private static String createWindow(Vector<String> times) {
        final String[] input = {""};
        JFrame frame = new JFrame("Swing Tester");
        JTextField jt = new JTextField("Enter Date");
        frame.add(jt);
        jt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get date as a string
                input[0] = jt.getText();

                System.out.println("Input value: " + input[0]);
                System.out.println("\nTimes value: " + times.toString());
                data.updateColumns(input[0], times);
                // Update the original file with new Columns of the date we chose
                //data.updateColumns(input[0]);

            }
        });

        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return input[0];
    }

}
