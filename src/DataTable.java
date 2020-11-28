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
 * This class displays the data in roster file using JTable.
 *
 * @author
 *
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.*;
import java.util.ArrayList;


public class DataTable extends RosterLoader {
    protected static JTable table;

    private DefaultTableModel tableModel;
    
     /**
     * Renders the JTable inside of a scrollpane
     */
    protected void renderTable () {
        //Creating the column headers array
        String[] column_titles = {"ID", "First Name","Last Name", "Program", "Level", "ASURITE"};

        tableModel = new DefaultTableModel(column_titles,0);

        //Creating our table and setting constraints
        table = new JTable(tableModel);
        table.setBounds(30,40,200,300);
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); this is incase we need it not to fit to size
        
        //Setting the header to white
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.WHITE);

        //add each row from our data set to our table
        for (String[] row : tableInfo){
            tableModel.addRow(row);
        }

        JScrollPane scroller = new JScrollPane(table);
        JScrollBar hbar=new JScrollBar(JScrollBar.HORIZONTAL);
        JScrollBar vbar=new JScrollBar(JScrollBar.VERTICAL);
        frame.add(hbar,BorderLayout.SOUTH);
        frame.add(vbar,BorderLayout.EAST);
        frame.add(scroller);
        frame.revalidate();

    }
    
     /**
     * This function updates Column, potential to add a vector of the times
     * creates a list of times that corresponds to what we need to add
     * @param date
     * @param times
     */
    protected void updateColumns(String date, Vector<String> times ){
        tableModel.addColumn(date, times);
    }

}
