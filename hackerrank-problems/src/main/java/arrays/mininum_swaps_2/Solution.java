package arrays.mininum_swaps_2;

import java.util.Arrays;

public class Solution
{
    static int minimumSwaps(int[] arr) {
        int numSwaps = 0;
        for(int i = 0; i < arr.length; i ++)
        {
            if (i+1!= arr[i])
            {
                int currentNumIndex = i;
                while (i+1 != arr[currentNumIndex])
                {
                    currentNumIndex++;
                }
                    int numToSwap = arr[currentNumIndex];
                    arr[currentNumIndex] = arr[i];
                    arr[i] = numToSwap;
                    numSwaps++;

            }
        }
        return numSwaps;
    }

    public static void main(String[] args)
    {

        System.out.println("Num swaps = " + minimumSwaps(new int[] {7,1,3,2,4,5,6}));
        System.out.println("Num swaps = " + (minimumSwaps(new int[] {4,3,1,2})));
    }
}
