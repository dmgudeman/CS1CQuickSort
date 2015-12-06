package project06_davidg;

import javax.swing.SwingUtilities;

import cs1c.TimeConverter;

public class Driver
{

   static int arraySize = 20000;

   static Integer[] bigArray = new Integer[arraySize];

   public static Integer[] makeArray(int arraySize)
   {
      for (int i = 0; i < arraySize; i++)
      {
         bigArray[i] = (int) (Math.random() * arraySize/5);
      }
      return bigArray;
   }

   public static void main(String[] args)
   {
      // set up timing
      long startTime, estimatedTime;
      
      // object from helper classes
      FHsort fh = new FHsort();
      CalcRange calcRange = new CalcRange();
      
      // make an array
      Integer[] array = makeArray(arraySize);
      
      // make two arrays to collect answers
      double[] answersX = new  double[arraySize];
      double[] answersY = new double[arraySize];
      
      
      Integer arrayLength = arraySize;

      // double to catch a single answer
      double ansX = 0.0;
      double ansY = 0.0;

      // step through the array at different recursion limits up to value of 300
      for (int i = 2, j = 0; i < 300; i = i + 2)
      {
         System.out.println("i = " + i + "; j = " + j);
         fh.setRecursionLimit(i);

         // capture start time
         startTime = System.nanoTime();

         fh.quickSort(array);
         // stop and calculate elapsed time
         estimatedTime = System.nanoTime() - startTime;
         System.out.println(estimatedTime);
         
         ansX = (double)i;
         System.out.println("answersX " + ansX);
         ansY = (double)estimatedTime/10000;
         System.out.println("answersY " + ansY);
         // report algorithm time
         System.out.println("For RecursionLimit " + i + " "
               + TimeConverter.convertTimeToString(estimatedTime) );
//         if (j>1 && calcRange.checkRange(ansY, answersY[j-1], arraySize))
//         {
         answersX[j] = ansX;
         answersY[j] = ansY;
//         }
         calcRange.findIntervalAvg((int)ansX, answersY, 100, true);
         j++;
      }
      System.out.println();
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
             new XYLineChartExample(answersX,answersY, arrayLength).setVisible(true);
         }
     });
      
     
   }
}
