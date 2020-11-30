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
 * This class allows users to export the table as an cvs file
 * to certain path.
 *
 * @author Justin De Ocampo
 *
 */
import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class Saver extends DataTable{

     /**
     * This method asks users to find a location and exports the file to the location.
     */
    public void exportToCSV() {

        //Create a file chooser so the user can export the file to any location they wish
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showSaveDialog(null);

        //If they click the approve option, then save the file to the selected location
        if (result == JFileChooser.APPROVE_OPTION) {
            try {

                TableModel model = table.getModel();
                System.out.println(chooser.getSelectedFile());
                FileWriter csv = new FileWriter(new File(String.valueOf(chooser.getSelectedFile())) + ".csv");

                //Writing the column headers to the CSV
                for (int i = 0; i < model.getColumnCount(); i++) {
                    csv.write(model.getColumnName(i) + ",");
                }

                csv.write("\n");

                //Writing the body of the table to the CSV
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        csv.write(model.getValueAt(i, j).toString() + ",");
                    }
                    csv.write("\n");
                }

                //Close the file writer
                csv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


