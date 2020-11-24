import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.*;
import java.util.ArrayList;

//TODO: this class will probably be implemented as an interface later since we have to create two types of tables for the project
//TODO: might have to make a second DataTable to update tableModel with AttendanceLoader
//Displays the Jtable data
public class DataTable extends RosterLoader {
    static JTable table;
    public DefaultTableModel tableModel;
    //Renders the JTable inside of a scrollpane
    public void renderTable () {
        //Creating the column headers array
        String[] column_titles = {"ID", "First Name","Last Name", "Program", "Level", "ASURITE"};

        tableModel = new DefaultTableModel(column_titles,0);

        //Creating our table and setting constraints
        table = new JTable(tableModel);
        table.setBounds(30,40,200,300);

        //Setting the header to white
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.WHITE);

        //add each row from our data set to our table
        for (String[] row : tableInfo){
            tableModel.addRow(row);
        }

        JScrollPane scroller = new JScrollPane(table);
        frame.add(scroller);
        frame.revalidate();

    }
    public void updateColumns(String date, Vector<Integer> times ){
        // updating Column, potential to add a vector of the times
        // create a list of times that corresponds to what we need to add

        tableModel.addColumn(date, times);

    }

}
