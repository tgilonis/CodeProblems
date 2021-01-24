package algorithms;

import java.util.Arrays;

public class TwoPointers
{
    public static void rotate(int[] arr, int step)
    {
        

        step %= arr.length;
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, step-1);
        reverse(arr, step, arr.length-1);
    }

    private static void reverse(int[] arr, int first, int last)
    {
        while(first<last)
        {
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;

            first++;
            last--;
        }
    }



    public static void main(String[] args)
    {
        /*int[] numbers = {1,2,3,4,5,6,7};
        rotate(numbers, 4);
        System.out.println(Arrays.toString(numbers));*/

       /* int[] numbers2 = {1,2,3,4,5,6,7};
        System.out.println(twoSum(numbers2, 7));*/
    }

    public static boolean twoSum(int[] arr, int value)
    {
        int first = 0;
        int last = arr.length-1;

        while(first<last)
        {
            int sum = arr[first+last];
            if(sum<value)
                first++;
            else if(sum==value)
                return true;
            else
                last--;
        }
        return false;
    }

}
