package project06_davidg;
import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 * This program demonstrates how to draw XY line chart with XYDataset
 * using JFreechart library.
 * @author www.codejava.net
 *
 */
public class XYLineChartExample extends JFrame {
   public Point[] pointsMax = {};
   public double[] x = {};
   public double[] y = {};
   public static String arraySize = "";
   public String truncatedSize = "";
   
   
   // Constructor for double arrays
   public XYLineChartExample(double[] x, double[] y, 
          Integer arraysize) {
        super("For Array size = " + arraySize.toString());
      
        this.x = x;
        this.y = y;
        this.arraySize = Integer.toString(arraysize);
 
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
 
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
   
   // Constructor for Point array
   public XYLineChartExample(Point[] points, 
         Integer arraysize) {
       super("For Array size = " + arraySize.toString());
     
       this.pointsMax = points;
       this.arraySize = Integer.toString(arraysize);

       JPanel chartPanel = createChartPanel();
       add(chartPanel, BorderLayout.CENTER);

       setSize(640, 480);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
   }
 
    private JPanel createChartPanel() {
       String chartTitle = "Array size = " + this.arraySize ;
       String xAxisLabel = "Recursion Limit " ;
       String yAxisLabel = "Time to Complete Sort (nanoSeconds/10,000)";
    
       XYDataset dataset = createDataset();
    
       JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
               xAxisLabel, yAxisLabel, dataset);
    
       return new ChartPanel(chart);
   }
    private JPanel createChartPanelP() {
       String chartTitle = "Array size = " + this.arraySize ;
       String xAxisLabel = "Recursion Limit " ;
       String yAxisLabel = "Time to Complete Sort (nanoSeconds/10,000)";
    
       XYDataset dataset = createDatasetP();
    
       JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
               xAxisLabel, yAxisLabel, dataset);
    
       return new ChartPanel(chart);
   }
 
    
    private XYDataset createDataset() {
      
       XYSeriesCollection dataset = new XYSeriesCollection();
       XYSeries series1 = new XYSeries("Recursion Limit");
//       XYSeries series2 = new XYSeries("Object 2");
//       XYSeries series3 = new XYSeries("Object 3");
      
       for (int i = 0; i < x.length; i++)
       {
          series1.add(x[i], y[i]);
       }
             
//       series1.add(10000.0, 20000.0);
//       series1.add(20000.0, 30000.0);
//       series1.add(30000.0, 20000.5);
//       series1.add(30000.5, 20000.8);
//       series1.add(40000.2, 60000.0);
//    
//       series2.add(2.0, 1.0);
//       series2.add(2.5, 2.4);
//       series2.add(3.2, 1.2);
//       series2.add(3.9, 2.8);
//       series2.add(4.6, 3.0);
//    
//       series3.add(1.2, 4.0);
//       series3.add(2.5, 4.4);
//       series3.add(3.8, 4.2);
//       series3.add(4.3, 3.8);
//       series3.add(4.5, 4.0);
    
       dataset.addSeries(series1);
//       dataset.addSeries(series2);
//       dataset.addSeries(series3);
    
       return dataset;
   }
 
    private XYDataset createDatasetP() {
       
       XYSeriesCollection datasetP = new XYSeriesCollection();
       XYSeries series1P = new XYSeries("Recursion Limit");
//       XYSeries series2 = new XYSeries("Object 2");
//       XYSeries series3 = new XYSeries("Object 3");
      
       for (int i = 0; i < pointsMax.length; i++)
       {
          series1P.add(pointsMax[i].getX(), pointsMax[i].getY());
       } 
        
    datasetP.addSeries(series1P);
//    dataset.addSeries(series2P);
//    dataset.addSeries(series3P);
 
    return datasetP;
}
    
    
}
