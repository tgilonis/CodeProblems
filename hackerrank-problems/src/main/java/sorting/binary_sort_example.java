package sorting;

import static java.util.Arrays.binarySearch;

public class binary_sort_example
{
    static void iterBinarySearch(int[] arr, int key)
    {
        int first = 0;
        int last = arr.length-1;
        int mid = (first+last)/2;

        while(first<=last)
        {
            if(arr[mid]<key)
                first = mid + 1;
            else if (arr[mid]==key)
            {
                System.out.println("Found: " + mid);
                break;
            }
            else
                last = mid - 1;
            mid = (first + last) / 2;
        }
        if(first>last)
            System.out.println("Not found");
    }

    static void recurBinarySort(int[] arr, int first, int last, int key)
    {

    }

    public static void main(String... args)
    {
        int arr[] = {10,20,30,40,50};
        int key = 30;
        iterBinarySearch(arr, key);
    }
}

