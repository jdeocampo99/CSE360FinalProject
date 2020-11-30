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
 * This class displays a scatter plot based on the data of students' 
 * attendance. The X axis is % of Attendance and the Y axis is Number 
 * of students. 
 *
 * @author
 *
 */
import java.awt.Color;
import java.util.Vector;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.*;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;

public class ScatterPlot extends DataTable{
    XYDataset dataset = createDataset();

    /**
     * This method obtains the data from DataTable and
     * calculates the percentage of attendance of each
     * student. Then it counts the numbers of the students
     * that have same percentage of attendance.
     * @return a XYDataset
     */
    XYDataset createDataset()
    {
        XYSeriesCollection dataset = new XYSeriesCollection();
        int numStudents = table.getRowCount();
        double percentAttendance;
        int studentCount;

        for(int i =6; i<table.getColumnCount(); i++)
        {
            XYSeries series = new XYSeries((String)table.getColumnName(i));
            for(int j =0; j<numStudents; j++)
            {
                studentCount = 0;
                for(int k = 0; k<numStudents; k++)
                {
                    if (Integer.parseInt((String)table.getValueAt(k,i)) == Integer.parseInt((String)table.getValueAt(j,i))) {
                        studentCount++;
                    }
                }
                percentAttendance = (Double.parseDouble((String)table.getValueAt(j,i))/75)*100;
                 if(percentAttendance >= 100)
                {
                    percentAttendance = 100;
                    studentCount++;
                }
                series.add(percentAttendance,studentCount);
            }
            dataset.addSeries(series);
        }


        createWindow(dataset);
        return dataset;
    }

    /**
     * This method creates a new java frame that can display
     * scatter plot using the XYDataset from DataTable.
     * @param data a dataset that is obtained from DataTable
     */
    private static void createWindow(XYDataset data) {
        final String[] input = {""};
        JFrame frame = new JFrame("Scatter Plot");
        JFreeChart chart = ChartFactory.createScatterPlot("","% of Attendance", "Number of Students", data, PlotOrientation.VERTICAL,true,false,false);
        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(255,228,196));
        ChartPanel panel = new ChartPanel(chart);
        frame.add(panel);

        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
