package sorting.bubble_sort;

import java.util.Arrays;

public class Solution
{
    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {

        int count = 0;
        boolean sorted = false;

        while(!sorted) //can be done with a while loop or two for loops
        {
            sorted = true;
            for (int j = 0; j < a.length - 1; j++)
            {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1])
                {
                    count++;
                    sorted = false;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }

        }
        System.out.print("Array is sorted in " + count + " swaps.\n");

        System.out.print("First Element: " + a[0] + "\n");

        System.out.print("Last Element: " + a[a.length - 1]);

    }




    public static void main(String[] args)
    {
        countSwaps(new int[] {2,1,3});
        countSwaps(new int[] {3,2,1});
    }
}
