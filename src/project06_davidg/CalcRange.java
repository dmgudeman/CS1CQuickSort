package project06_davidg;

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
   
   public double findIntervalAvg(int index, double[] answersY, 
         int desiredInt, boolean flag)
   {
      double avg = 0.0;
      double sum = 0.0;
    
      
      if (index < desiredInt)
      {
         for (int i = index; i < desiredInt; i++)
         {
            sum += answersY[i];
         } 
         
      }
      if (flag)
      System.out.println("Average of last " + desiredInt + " is " +sum/desiredInt);
      return sum/desiredInt;
      
   }
}
