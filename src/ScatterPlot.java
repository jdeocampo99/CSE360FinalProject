import java.awt.Color;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.*;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;

public class ScatterPlot extends AttendanceLoader{
    XYDataset dataset = createDataset();

    XYDataset createDataset()
    {
        XYSeriesCollection dataset = new XYSeriesCollection();

        /*
        for(int i = 0; i<times.size(); i++) {
            XYSeries attendance1 = new XYSeries(times.elementAt(i));
            //here i was trying to set the series variables for each new attendance date
            //but idk how to make new variables in the for loop
        }
        System.out.println(attendanceInfo.get(0)[1]);
        //System.out.println(attendanceInfo.get(0)[2]);
        return dataset;
        */

        //TEST DATA
        //Just using manual inputs to test the formatting of the scatter plot
        //Still need to find out how to read data from the file and add to scatter plot
        XYSeries series1 = new XYSeries("Jan 22");
        series1.add(1,11);
        series1.add(2,12);
        series1.add(3,15);
        series1.add(4,16.2);
        series1.add(5,17.5);
        series1.add(6,19.5);
        series1.add(7,21);
        series1.add(8,22);
        series1.add(9,23.5);
        series1.add(10,23.6);

        dataset.addSeries(series1);

        XYSeries series2 = new XYSeries("Jan 23");
        series2.add(1,11.1);
        series2.add(2,12.1);
        series2.add(3,15.1);
        series2.add(4,16.3);
        series2.add(5,17.6);
        series2.add(6,19.6);
        series2.add(7,21.1);
        series2.add(8,22.1);
        series2.add(9,23.6);
        series2.add(10,23.7);

        dataset.addSeries(series2);

        createWindow(dataset);
        return dataset;
    }

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
