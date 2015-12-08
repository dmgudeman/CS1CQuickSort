package project06_davidg;

import java.awt.Point;

public class CalcRange
{
   public boolean checkRange(double firstDbl, double secondDbl, int arraySize)
   { 
      double diffDbl = Math.abs(firstDbl -secondDbl);
      System.out.println("dffDbl = " + diffDbl);
      System.out.println("0.01*arraySize = " +  0.01* arraySize);
      if (diffDbl > 0.01*arraySize)
         return true;
               
         return false;
   }
   
   public double findIntervalAvg(int index, Point[] answersP, 
         int desiredInt, boolean flag)
   {
      double avg = 0.0;
      double sum = 0.0;
      System.out.println(index);
      System.out.println(answersP.length);
      if (index > desiredInt)
      {
         System.out.println(index-desiredInt);
         for (int i = 0 ; i < desiredInt; i++)
         {
            System.out.println("i = " + i + ";  desirdInt = " + desiredInt + "; index -i =  " + (index -i) );
          try {
            if(!answersP[index -i].equals(null))
            sum += answersP[index - i].getY();
          } catch (Exception e)
          {
             
          }
         }         
      }
      if (flag)
      System.out.println("Average of last " + desiredInt + " is " +sum/desiredInt);
      return sum/desiredInt;
      
   }
}
