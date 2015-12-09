package project06_davidg;

import java.awt.Point;
import java.text.DecimalFormat;

import javax.swing.SwingUtilities;
/**
 * The purpose of this class is to produce two graphs. The first graph plots the 
 * the maximum time to sort an array at incremented recursion limits up to 300. 
 * The arrays range in size from 20000 to 1000000 at increments of 20000.
 * The second graph plots the value of which recursion limit produced the max, 
 * so this graph ranges from 2 to 300.
 * @author davidgudeman
 *
 */
public class PlotRanges
{
   static int arrayLength;
   static Integer[] randIntArray;
   static Point[] minimumsP;
   static Point[] maximumsP;
   static Point[] answersP;
   
   static int MAX_ARRAYLENGTH = 1000000;
   static int INCREMENT_ARRAYLENGTH = 20000;

   static int TIMES_AROUND_BIG_LOOP = MAX_ARRAYLENGTH/INCREMENT_ARRAYLENGTH;
   
   static int LIM_ITR_TIMES = 300;
   static int LIM_ITR_INTERVAL = 2;

   static final boolean flagInnerLoop = true;
   static final boolean flagOuterLoop = false;
   static int al;
   
   static DecimalFormat numberFormat = new DecimalFormat("#.0000");


   /**
    * Takes an array length and produces a random array of Integers that range 
    * in magnitude from 0 to arrayLength/5.  The array has the arguments length.
    * @param arraySize
    * @return array of Integers
    */
   public static Integer[] makeRandIntArray(int arraySize)
   {     
      Integer[] randIntArray = new Integer[arraySize];
      for (int i = 0; i < arraySize; i++)
      {
         randIntArray[i] = (int) (Math.random() * arraySize / 5);
      }
      return randIntArray;
   }
  
   /**Make an Array of doubles to collect the max times to sort different sizes of 
    * arrays
    * @param arrayLength
    * @returns array of points
    */
   public static Point[] initPointArray(int arrayLength)
   {
      Point[] maximumsP = new Point[TIMES_AROUND_BIG_LOOP];
      for (int p = 0; p < TIMES_AROUND_BIG_LOOP; p++)
      { 
         maximumsP[p] = new Point();
      }
      return maximumsP;
   }
   /**Make an Array of Points to plot the recursion Limit: what recursion limit is 
    * produces the worst time of sorting the various lengths of the Integer array
    * arrays
    * @param arrayLength
    * @returns array of points
    */
   public static Point[] makeRecLimitArray(int arrayLength)
   {
      Point[] recLimitsP = new Point[TIMES_AROUND_BIG_LOOP];
      for (int p = 0; p < TIMES_AROUND_BIG_LOOP; p++)
      { 
         recLimitsP[p] = new Point();
      }
      return recLimitsP;
   }
      

   public static void main(String[] args)
   {
    
      // set up timing
      long startTime, estimatedTime;

      // object from helper classes
      FHsort fh = new FHsort();

//      // make two arrays to collect answers
//      double[] answersX = new double[arraySize];
//      double[] answersY = new double[arraySize];
//      answersP = new Point[arraySize];
//
//      Point maxPoint = new Point();
//      Point minPoint = new Point();

      int lengthTally;

//      // double to catch a single answer
      double ansX = 0.0;
      double ansY = 0.0;
      Point[] maxArrayP = initPointArray(TIMES_AROUND_BIG_LOOP);
      Point[] minArrayP = initPointArray(TIMES_AROUND_BIG_LOOP);
      Point[] recLimitArrayP = initPointArray(TIMES_AROUND_BIG_LOOP);
 
     

      // step through the increasing larger arrays to max of MAX_ARRAYLENGTH
      //
      for( lengthTally = 1; lengthTally <= TIMES_AROUND_BIG_LOOP; lengthTally++)
      {
         // calculate size of array for this iteration
         arrayLength = INCREMENT_ARRAYLENGTH * lengthTally;
         
         // make a random integer array of arrayLength lenth
         Integer[] randIntArray = makeRandIntArray(arrayLength);
         
        
         double[] recLimitD = new double[arrayLength];
         double[] maximumsD = new double[arrayLength];
         double[] minimumsD = new double[arrayLength];
         double maximumD = 0.0;
         double minimumD = 1.0E18; // a ridiculously large number to initialize
        
         int iterOfMax = 0;
            
      
      for (int i = 2; i < LIM_ITR_TIMES; 
            i = i + 2)
      {
       
         // set the recusion limit for this loop
         fh.setRecursionLimit(i);

         // capture start time
         startTime = System.nanoTime();
         
         // sort the array
         fh.quickSort(randIntArray);
         
         // stop and calculate elapsed time
         estimatedTime = System.nanoTime() - startTime;
         
         if (estimatedTime > maximumD)
         { 
            maximumD = estimatedTime;
            iterOfMax = i;            
         }
         if (estimatedTime < minimumD)
         { 
            minimumD = estimatedTime;
                       
         }
                 
      } // end of inner i loop 
      // this is to measure at what iteration the max is reached
      Point iterationP = new Point ();
      iterationP.setLocation(lengthTally, iterOfMax);
      Point maximumP = new Point();      
      maximumP.setLocation(lengthTally, maximumD);
      Point minimumP = new Point();
      minimumP.setLocation(lengthTally, minimumD);
      
      maxArrayP[lengthTally - 1 ] = maximumP;
      minArrayP[lengthTally - 1 ] = minimumP;
      recLimitArrayP[lengthTally -1 ] = iterationP;
      System.out.println("maximum ns/M: " +     numberFormat.format(maximumD/1000000)
            + "; iterOfMax: " + iterOfMax + "; arraySize: " + lengthTally*20000);
      System.out.println("maxArrayP.length " + maxArrayP.length);
      
      } // end of outer loop
      System.out.println("maxArrayP.length " + maxArrayP.length);
      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            new XYLineChartExample(maxArrayP, minArrayP,  recLimitArrayP, 
                  maxArrayP.length)
                  .setVisible(true);
         }
      });
   }// end main
}

