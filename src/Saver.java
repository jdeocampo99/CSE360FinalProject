
import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class Saver extends DataTable{

    public void exportToCSV() {

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {

                TableModel model = table.getModel();
                System.out.println(chooser.getSelectedFile());
                FileWriter csv = new FileWriter(new File(String.valueOf(chooser.getSelectedFile())) + ".csv");

                for (int i = 0; i < model.getColumnCount(); i++) {
                    csv.write(model.getColumnName(i) + ",");
                }

                csv.write("\n");

                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        csv.write(model.getValueAt(i, j).toString() + ",");
                    }
                    csv.write("\n");
                }

                csv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


