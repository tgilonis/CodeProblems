package arrays.array_manipulation;

import java.util.Arrays;
import java.util.Collections;

public class Solution
{
    static long arrayManipulation(int n, int[][] queries)
    {
        Integer[] zero = new Integer[n+1];
        Arrays.fill(zero, 0);
        for(int[] query : queries)
        {
            //mark the endpoints of the array, to balance the summation later
            zero[query[0]-1] += query[2];
            zero[query[1]] -= query[2];
        }
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++)
        {
            //during summation, the negative endpoint (line 16) will balance out
            sum += zero[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(arrayManipulation(5,new int[][] {{1,2,100},
                {2 ,5, 100},
                {3 ,4 ,100}}));

        System.out.println(arrayManipulation(10,new int[][] {{2,6,8},
                {3 ,5, 7},
                {1 ,8 ,1},
                {5 ,9 ,15}}));
    }
}
