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
   public Point[] pointsMax;
   public Point[] pointsMin;
   public Point[] recLimits;
   public double[] x = {};
   public double[] y = {};
   public static String stringForTitle = "";
   public String truncatedSize = "";
   
   
   // Constructor for double arrays
   public XYLineChartExample(double[] x, double[] y, 
          Integer arraysize) {
        super("For Array size = " + stringForTitle.toString());
      
        this.x = x;
        this.y = y;
        this.stringForTitle = Integer.toString(arraysize);
 
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
 
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
   
   // Constructor for Point array
   public XYLineChartExample(Point[] maxArray, Point[] minArray, Point[] recLimit,
         Integer arraysize) {
       super("For Array size = " + stringForTitle.toString());
     
       this.pointsMax = maxArray.clone();     
       this.pointsMin = minArray.clone();
       this.recLimits = recLimit.clone();
       
       
       this.stringForTitle = Integer.toString(arraysize);

       JPanel chartPanel = createChartPanelP();
       add(chartPanel, BorderLayout.CENTER);

       setSize(640, 480);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
   }
 
    private JPanel createChartPanel() {
       String chartTitle = "Array size = " + this.stringForTitle ;
       String xAxisLabel = "Recursion Limit " ;
       String yAxisLabel = "BLAH";
    
       XYDataset dataset = createDataset();
    
       JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
               xAxisLabel, yAxisLabel, dataset);
    
       return new ChartPanel(chart);
   }
    private JPanel createChartPanelP() {
       String chartTitle = "Array Size vs Max, Min and Rec Limit " ;
       String xAxisLabel = "Array Size (x1000) " ;
       String yAxisLabel = "Max, Min of sort (nanoSecs/100K); Rec Limit of Max";
    
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
                
       dataset.addSeries(series1);
//       dataset.addSeries(series2);
//       dataset.addSeries(series3);
    
       return dataset;
   }
 
    /**
     * 
     * @return
     */
    private XYDataset createDatasetP() {
       
       XYSeriesCollection dataset = new XYSeriesCollection();
       XYSeries series1 = new XYSeries("max sort time");
       XYSeries series2 = new XYSeries("min sort time");
       XYSeries series3 = new XYSeries("rec Limit");
      
       for (int i = 0; i < pointsMax.length; i++)
       {
          series1.add(pointsMax[i].getX()*20, pointsMax[i].getY()/100000);
          series2.add(pointsMin[i].getX()*20, pointsMin[i].getY()/100000);
          series3.add(recLimits[i].getX()*20, recLimits[i].getY());
          System.out.println("pointsMax" + pointsMax[i].getX()*20 + " "+ pointsMax[i].getY()/100000 );
          System.out.println("pointsMin" + pointsMin[i].getX()*20 + " "+ pointsMin[i].getY()/100000 );
          System.out.println("recLimits" + recLimits[i].getX()*20 + " "+ recLimits[i].getY() );
       } 
        
    dataset.addSeries(series1);
    dataset.addSeries(series2);
    dataset.addSeries(series3);
 
    return dataset;
}
    
    
}
