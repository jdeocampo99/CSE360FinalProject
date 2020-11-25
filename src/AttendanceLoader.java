import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AttendanceLoader extends Menu_Bar {


    private File selectedFile = null;
    private Vector<String> times = new Vector<>();
    public static ArrayList<String[]> attendanceInfo = new ArrayList<>();

    public void chooseAttendanceFile(){
        try{
            // clear the previous data
            times.clear();
            attendanceInfo.clear();
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
                }


                //Implement map that contains asurite ID's, if multiple have been encountered,
                // add the numbers together before adding it to times.
                // We may need a temporary vector to then add to times later
                // SO, we make a map that gets adds every ASURITE ID and initializes the value to 0
                int tNum = 0;
                Map<String, Integer> attendanceMap = new HashMap<String, Integer>(){{
                    for(int i = 0; i < tableInfo.size(); i++){
                        // add every ASURITE ID to a Map
                        //myMap[tableInfo.get(i)[5]] = 0;
                        put(tableInfo.get(i)[5], tNum);
                    }
                }};

                // iterate through attendanceInfo
                for(int j = 0; j < attendanceInfo.size(); j++){
                    // if the hash set of ASURITE ID's matches the attendanceInfo
                    if(attendanceMap.containsKey(attendanceInfo.get(j)[0])){
                        // if the person has multiple inputs, add together their minutes
                        //map.put(key, map.get(key) + value);
                        //map.put(key, (previous value) + current value);
                        attendanceMap.put(attendanceInfo.get(j)[0], attendanceMap.get(attendanceInfo.get(j)[0]) + Integer.parseInt(attendanceInfo.get(j)[1]));
                    }
                }

                // iterate through tableInfo so we are in order
                for(String[] row : tableInfo){
                    // add the value of the row to times
                    //times.add(myMap[row[5]]);
                    times.add(Integer.toString(attendanceMap.get(row[5])));
                }
                // once we obtain full times vector, we pick the date and GO
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

    public void pickDate(Vector<String> times){

        createWindow(times);

    }

    private static void createWindow(Vector<String> times) {
        final String[] input = {""};
        JFrame frame = new JFrame("Swing Tester");
        JTextField jt = new JTextField("Enter Date");
        frame.add(jt);
        jt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get date as a string
                input[0] = jt.getText();

//                System.out.println("Input value: " + input[0]);
//                System.out.println("\nTimes value: " + times.toString());
                data.updateColumns(input[0], times);
                // Update the original file with new Columns of the date we chose
                //data.updateColumns(input[0]);

            }
        });

        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
