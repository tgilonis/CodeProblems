package arrays.mininum_swaps_2;

import java.util.Arrays;

public class Solution
{
    static int minimumSwaps(int[] arr) {
        int numSwaps = 0;
        for(int i = 0; i < arr.length; i ++)
        {
            int desiredNum = i+1;
            int currentNumIndex = 0;
            while(desiredNum!=arr[currentNumIndex])
            {
                /*System.out.println("Desired num = " + desiredNum);
                System.out.println("Current num = " + arr[currentNumIndex]);
                System.out.println("Current numIndex = " + currentNumIndex);*/


                currentNumIndex++;
            }
            //System.out.println(Arrays.toString(arr));
            if(i!=currentNumIndex)
            {
                int numToSwap = arr[i];
                arr[i] = desiredNum;
                arr[currentNumIndex] = numToSwap;
                numSwaps++;
            }
            //System.out.println(Arrays.toString(arr));

        }
        //System.out.println(Arrays.toString(arr));
        return numSwaps;


    }

    public static void main(String[] args)
    {

        System.out.println("Num swaps = " + minimumSwaps(new int[] {7,1,3,2,4,5,6}));
        System.out.println("Num swaps = " + (minimumSwaps(new int[] {4,3,1,2})));
    }
}
