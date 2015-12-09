package project06_davidg;

import java.awt.Point;

import javax.swing.SwingUtilities;

import cs1c.TimeConverter;

/**
 * This class allows you to set three class variables: the size of the 
 * array, how many times you cycle through it at diffenent recursion limits
 * and the interval at which to advance the recursion limit that you are 
 * evaluating. 
 * @author davidgudeman
 *
 */
public class PlotOneMatrix
{

   static int arraySize;  // array size to evaluate
   static Integer[] bigArray; // will hold random integers to be sorted
   static Point[] minimumsP;
   static Point[] maximumsP;
   static Point[] answersP;

   static int LIM_ITR_TIMES = 300; // maximum value of the recursionlimit to be tested
   static int LIM_ITR_INTERVAL = 2; //interval between rec Limits to be tested

   static final boolean flagInnerLoop = true; // debuggin flag

   static int al;

   /**
    * Takes an array size as an int and returns an array of random integers that
    * range in magnitude of 0 to array size/5
    * @param arraySize
    * @return array of Integers
    */
   public static Integer[] makeArray(int arraySize)
   {
      Integer[] integerArray = new Integer[arraySize];
      for (int i = 0; i < arraySize; i++)
      {
         integerArray[i] = (int) (Math.random() * arraySize / 5);
      }
      return integerArray;
   }

   public static void main(String[] args)
   {
      arraySize = 40000;
      
      long startTime, estimatedTime;

      // object from helper classes
      FHsort fh = new FHsort();

      // make two arrays to collect answers
      double[] answersX = new double[arraySize];
      double[] answersY = new double[arraySize];
      answersP = new Point[arraySize];

      Point maxPoint = new Point();
      Point minPoint = new Point();

      Integer arrayLength = arraySize;

      // double to catch a single answer
      double ansX = 0.0;
      double ansY = 0.0;

      bigArray = makeArray(arraySize);

      // step through the array at different recursion limits up to value of
      // ITER_TIMES 
      for (int i = 2, j = 0; i < LIM_ITR_TIMES; i = i + LIM_ITR_INTERVAL, j++)
      {
         Point point = new Point();

         fh.setRecursionLimit(i);

         // capture start time
         startTime = System.nanoTime();

         fh.quickSort(bigArray);
         // stop and calculate elapsed time
         estimatedTime = System.nanoTime() - startTime;

         ansX = (double) i;
         ansY = (double) estimatedTime / 10000;

         if (flagInnerLoop)
         {
           
            System.out.println("For RecursionLimit " + i + " "
                  + TimeConverter.convertTimeToString(estimatedTime));
         }
         point.setLocation(ansX, ansY);
        
         answersP[j] = point;
         if (i == 2)
         {
            maxPoint.setLocation(ansX, ansY);
            minPoint.setLocation(ansX, ansY);

         }
         if (maxPoint.getY() < ansY)
            maxPoint.setLocation(ansX, ansY);
         if (minPoint.getY() > ansY)
            minPoint.setLocation(ansX, ansY);
         answersX[j] = ansX;
         answersY[j] = ansY;

      } // end inner loop (i, j)

      /**
       * Anonymous class calls a new thread that creates a XYLineChartExample 
       */
         SwingUtilities.invokeLater(new Runnable()
         {
            @Override
            public void run()
            {
               new XYLineChart(answersX, answersY, arrayLength)
                     .setVisible(true);
            }
         });
         System.out.println("max = " + maxPoint.getY() + " at recursion limit "
               + maxPoint.getX());
         System.out.println("min = " + minPoint.getY() + " at recursion limit "
               + minPoint.getX());
 

   }// end main
}
