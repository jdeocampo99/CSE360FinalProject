import java.awt.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.*;
import org.jfree.data.xy.XYDataset;

public class ScatterPlot extends AttendanceLoader{
    XYDataset dataset = createDataset();
    JFreeChart chart = ChartFactory.createScatterPlot("ScatterPlot","% of Attendance", "Number of Students", dataset, PlotOrientation.VERTICAL,false,false,false);
    XYPlot plot = (XYPlot)chart.getPlot();

    XYDataset createDataset()
    {
        XYSeriesCollection dataset = new XYSeriesCollection();

        for(int i = 0; i<times.size(); i++) {
            XYSeries attendance1 = new XYSeries(times.elementAt(i));
            //here i was trying to set the series variables for each new attendance date
            //but idk how to make new variables in the for loop
        }


    }



}
