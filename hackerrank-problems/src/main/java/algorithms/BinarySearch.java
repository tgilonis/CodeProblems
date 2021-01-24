package algorithms;

public class BinarySearch
    /*
    Important to remember that binary search should be used for a sorted list.

    In this example, we will work with an sorted list of ascending integers
     */
{
    public static int binarySearch(int[] arr, int num)
    {
        int first = 0;
        int last = arr.length-1;
        int middle = (first+last)/2;


        while(first<=last)
        {
            if(arr[middle]>num)
                last = middle-1;
            else if(arr[middle] == num)
                return middle;

            else
                first = middle+1;

            middle = (last+first)/2;
        }
        return -1;


    }

    public static void main(String[] args)
    {
        int[] muddle = {1,2,3,4,6,8,9,13,21,22};
        System.out.println(binarySearch(muddle, 9));
    }
}
