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
 * This program demonstrates how to draw XY line chart with XYDataset using
 * JFreechart library - jar files jcommon-1.0.23 and jfreechart-1.0.19 This
 * class creates a chart plotting datasets of coordinates. Eacn chart can plot
 * up to three series. The input can be in the form of double arrays or an array
 * of java.awt Points.
 *
 * @author David M Gudeman
 */
public class XYLineChart extends JFrame
{

   protected Point[] pointsMax;
   protected Point[] pointsMin;
   protected Point[] recLimits;
   protected double[] x =
   {};
   protected double[] y =
   {};
   protected static String stringForTitle = "";
   protected String truncatedSize = "";
   protected static boolean DEBUG = false;

   /**
    * Constructor that takes two arrays of doubles, the first representing the x
    * coordinate and the second the y coordinate of a cartesian plane. The third
    * argument is an Integer describing the arraySize. This is to be used for
    * the title in the chart. This calls the private helper function
    * createChartPanel()
    * 
    * @param x
    * @param y
    * @param arraysize
    */
   public XYLineChart(double[] x, double[] y, Integer arraysize)
   {
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
   public XYLineChart(Point[] maxArray, Point[] minArray, Point[] recLimit,
         Integer arraysize)
   {
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

   /**
    * Takes no arguments. Is called by the constructor and in turn calls
    * createData set that makes up to 3 series of data to be graphed. Calls
    * createXYLineChart that graphs the points this function returns that chart
    * 
    * @return ChartPanel object
    */
   private JPanel createChartPanel()
   {
      String chartTitle = "Array size = " + this.stringForTitle;
      String xAxisLabel = "Recursion Limit ";
      String yAxisLabel = "Array Size";

      XYDataset dataset = createDataset();

      JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel,
            yAxisLabel, dataset);

      return new ChartPanel(chart);
   }

   /**
    * Takes no arguments. Is called by the constructor and in turn calls
    * createDatasetP that makes up to 3 series of data to be graphed. Calls
    * createXYLineChart that graphs the points this function returns that chart
    * 
    * @return ChartPanel object
    */
   private JPanel createChartPanelP()
   {
      String chartTitle = "Array Size vs Max, Min and Rec Limit ";
      String xAxisLabel = "Array Size (x1000) ";
      String yAxisLabel = "Max, Min of sort (nanoSecs/100K); Rec Limit of Max";

      XYDataset dataset = createDatasetP();

      JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel,
            yAxisLabel, dataset);

      return new ChartPanel(chart);
   }

   /**
    * Creates a dataSet from the two double arrays which are attributes of the
    * XYLineChart object that calls it
    * 
    * @return dataset of doubles
    */
   private XYDataset createDataset()
   {

      XYSeriesCollection dataset = new XYSeriesCollection();
      XYSeries series1 = new XYSeries("Recursion Limit");
      // XYSeries series2 = new XYSeries("Object 2");
      // XYSeries series3 = new XYSeries("Object 3");

      for (int i = 0; i < x.length; i++)
      {
         series1.add(x[i], y[i]);
      }

      dataset.addSeries(series1);
      // dataset.addSeries(series2);
      // dataset.addSeries(series3);

      return dataset;
   }

   /**
    * Creates a dataSet from the point arrays that are attributes of the
    * XYLineChart object that calls it of the XYLineChart object that calls it
    * 
    * @return dataset of doubles
    */
   private XYDataset createDatasetP()
   {

      XYSeriesCollection dataset = new XYSeriesCollection();
      XYSeries series1 = new XYSeries("max sort time");
      XYSeries series2 = new XYSeries("min sort time");
      XYSeries series3 = new XYSeries("rec Limit");

      for (int i = 0; i < pointsMax.length; i++)
      {
         series1.add(pointsMax[i].getX() * 0.5, pointsMax[i].getY() / 100000);
         series2.add(pointsMin[i].getX() * 0.5, pointsMin[i].getY() / 100000);
         series3.add(recLimits[i].getX() * 0.5, recLimits[i].getY());
         if (DEBUG)
         {
            System.out.println("pointsMax" + pointsMax[i].getX() * 20 + " "
                  + pointsMax[i].getY() / 100000);
            System.out.println("pointsMin" + pointsMin[i].getX() * 20 + " "
                  + pointsMin[i].getY() / 100000);
            System.out.println("recLimits" + recLimits[i].getX() * 20 + " "
                  + recLimits[i].getY());
         }
      }

      dataset.addSeries(series1);
      dataset.addSeries(series2);
      dataset.addSeries(series3);

      return dataset;
   }

}
