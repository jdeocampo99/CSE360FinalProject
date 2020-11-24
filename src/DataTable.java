import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;

//TODO: this class will probably be implemented as an interface later since we have to create two types of tables for the project

//Displays the Jtable data
public class DataTable extends RosterLoader {
    static JTable table;
    // TODO: figure out why this Cannot be made public
    public DefaultTableModel tableModel;
    //Renders the JTable inside of a scrollpane
    public void renderTable () {
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
    public void updateColumns(String s){

        // updating Column
        tableModel.addColumn(s);

    }

}
