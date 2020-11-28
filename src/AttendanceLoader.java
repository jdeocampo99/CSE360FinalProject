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
 * This class will ask user to select a attendance file and a
 * date of the attendance. Then the class will display the
 * attendance of each student at the end of the table.
 *
 * @author
 *
 */

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AttendanceLoader extends Menu_Bar {


    File selectedFile = null;
    Vector<String> times = new Vector<>();
    static ArrayList<String[]> attendanceInfo = new ArrayList<>();

    /**
     * This method asks user for a file path. Then add the attendance
     * at the end of the table
     */
    public void chooseAttendanceFile() {

        try {
            //chooses the attendance CSV and reads from it
            final JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fc.getSelectedFile();

                //read through the selected file and save each row as an array of strings
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                String line;
                String[] current_row;
                //Save each row as an array of strings, add that to our final array list
                while ((line = reader.readLine()) != null) {
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
                for (int i = 0; i < tableInfo.size(); i++) {
                    // EDIT the times vector here!
                    //if tableInfo name matches attendanceInfo Name
                    for (int j = 0; j < attendanceInfo.size(); j++) {
                        System.out.println("\ntableInfo.get(i)[1]: " + tableInfo.get(i)[5]
                                + "\nattendanceInfo.get(j)[0]): " + attendanceInfo.get(j)[0] + "\n");
                        if (tableInfo.get(i)[5].equals(attendanceInfo.get(j)[0])) {
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
        catch (FileNotFoundException e) {
            System.out.println("Error: file not found!");
        } catch (IOException e) {
            System.out.println("Error: Invalid CSV");
        }
    }
    
     /**
     * This method asks users to select a date
     * @param times a vector to hold the times string
     * @return  a string of date
     */
    public String pickDate(Vector<String> times) {

        String input = createWindow(times);


        System.out.println("Hey THere");

        return input;
    }
     
    /**
     * This class is needed for date picker
     */
    public static class DateLabelFormatter extends AbstractFormatter {
        private String datePattern = "MM-dd-yyyy";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }

     /**
     * This is a helper function creates a new JFrame that allows users to
     * pick a date in a new window.
     *
     * @param times a vector to hold the times string
     * @return a string of date
     */
    private static String createWindow(Vector<String> times) {
        final String[] input = {""};
        JFrame frame = new JFrame("Pick a Date using ... button");
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        frame.add(datePicker);

        datePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get date as a string
                input[0] = datePicker.getJFormattedTextField().getText();

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
