package project06_davidg;

import java.awt.Point;

import javax.swing.SwingUtilities;

import cs1c.TimeConverter;

public class Driver
{

   static int arraySize;
   static Integer[] bigArray;
   static Point[] minimumsP;
   static Point[] maximumsP;
   static Point[] answersP;

   static int TIMES_AROUND_BIG_LOOP = 4;
   static int LIM_ITR_TIMES = 2000;
   static int LIM_ITR_INTERVAL = 2;

   static final boolean flagInnerLoop = false;
//   static final boolean flagOuterLoop = false;
   static int al;

   /**
    * Takes an array size as an int and returns an array of random integers that
    * range in magnitude of 0 to array size/5
    * 
    * @param arraySize
    * @return
    */
   public static Integer[] makeArray(int arraySize)
   {
      Integer[] tempArray = new Integer[arraySize];
      for (int i = 0; i < arraySize; i++)
      {
         tempArray[i] = (int) (Math.random() * arraySize / 5);
      }
      return tempArray;
   }

   public static void main(String[] args)
   {
      arraySize = 40000;
      // if (flagOuterLoop)
      // {
      // minimumsP = new Point[TIMES_AROUND_BIG_LOOP];
      // maximumsP = new Point[TIMES_AROUND_BIG_LOOP];
      // for (int p = 0; p < TIMES_AROUND_BIG_LOOP; p++)
      // {
      // minimumsP[p] = new Point();
      // maximumsP[p] = new Point();
      // }
      //
      // for (al = 0; al < TIMES_AROUND_BIG_LOOP; al++)
      // {
      // arraySize = 20000 * (al + 1);
      // }
      // }
      // set up timing
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
      // 300
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
            // System.out.println("answersX " + ansX);
            // System.out.println("answersY " + ansY);
            // report algorithm time
            System.out.println("For RecursionLimit " + i + " "
                  + TimeConverter.convertTimeToString(estimatedTime));
         }
         point.setLocation(ansX, ansY);
         // System.out.println(point.x + "     " + point.y);
         // System.out.println(point.getX() + "   " + point.getY());

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
       * Anonymous class that creates a XYLineChartExample
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
