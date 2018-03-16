/*package whatever //do not write package name here */

import java.io.*;
import java.util.Arrays;
class GFG {
    public static double[] getRandDistArray(int n, double m, double min, double Precision )
    {
        double randArray[] = new double[n];
        double sum = 0;

        // Generate n random numbers
        for (int i = 0; i < randArray.length; i++)
        {
            randArray[i] = Math.random()+i;
            sum += randArray[i];
        }

        // check number value
        int cnt = 0;
        while (true)
        {
            if ((randArray[cnt] / sum * m) < min)
            {
                sum -= randArray[cnt];    
                randArray[cnt] = Math.random();
                sum += randArray[cnt];
                cnt = -1;
            }
        
            cnt++;
            if (cnt >= randArray.length)
            {
                break;
            }
            
        }
        // Normalize sum to m
        double remain = m;
        for (int i = 0; i < randArray.length-1; i++)
        {
            randArray[i] /= sum;
            randArray[i] *= m;
            randArray[i]  = (int)(randArray[i]/Precision);
            randArray[i]  = randArray[i] * Precision;
            remain -= randArray[i];
        }
        randArray[randArray.length-1] = remain;

        return randArray;
    }
    
    public static void main (String[] args) {
        double sum[] = getRandDistArray(6, 39, 0.0001, 0.1);
        Arrays.sort(sum);
        for (int i = 0; i < sum.length; i++)
        {
            System.out.printf("%.1f\n", sum[i]);
        }
    }
}
