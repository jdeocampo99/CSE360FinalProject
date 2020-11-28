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
 * This class asks users to load a roster file.
 *
 * @author
 *
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class RosterLoader extends Menu_Bar {

    private File selectedFile = null;


    /**
     * creates the J File Chooser and reads in the data from the CSV and saves it to a 2d array
     */
    public void chooseFileAndReadInfo(){
        tableInfo = new ArrayList<>();
        try{

            //Open JFileChooser to select file
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
                    //System.out.println(Arrays.toString(current_row));
                    tableInfo.add(current_row);
                }
                //Create the Jtable based on the arraylist information that we have
                createTable();
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

    private void createTable(){
        data = new DataTable();
        data.renderTable();

    }
}
