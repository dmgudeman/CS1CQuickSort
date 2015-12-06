package project06_davidg;


import javax.swing.JFrame;

import org.math.plot.Plot2DPanel;


public class Graph
{
         double[] x = {};
         double[] y = {};

  public Graph (double [] x, double[] y)
  {
     this.x = x;
     this.y = y;
     // create your PlotPanel (you can use it as a JPanel)
     Plot2DPanel plot = new Plot2DPanel();

     // add a line plot to the PlotPanel
     plot.addLinePlot("my plot", x, y);

     // put the PlotPanel in a JFrame, as a JPanel
     JFrame frame = new JFrame("a plot panel");
     frame.setContentPane(plot);
     frame.setVisible(true);
  }
}
