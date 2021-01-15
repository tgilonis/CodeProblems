package arrays.new_year_chaos;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution
{
    static void minimumBribes(int[] q)
    {
        System.out.println(Arrays.toString(q));
        //can only bribe directly in front
        //print the minimum number of bribes, or 'Too chaotic' if someone bribed more than 2 people

        //a number can only move forward by bribing, but can move backwards by being bribed

        //as such, if a number is more than 2 forwards the queue is too chaotic

            //if a number is more than 2 forwards the queue is too chaotic
        int bribes = 0;

        for (int i = 0; i < q.length; i++)
        {
            if (q[i] - (i + 1) > 2)
            {
                System.out.println("Too chaotic");
                return;
            }
            //for each number, check how many larger numbers are to its left, and add to bribes
            //theory here is that every larger number in front of a number must have bribed that number before
            for(int j = i -1; j >= 0; j--)
            {
                if(q[j]>q[i])
                    bribes++;
            }
        }
        System.out.println(bribes);




        /*
        1 2 5 3 7 8 6 4 -- 7
        (get 3 back)
        1 2 3 5 7 8 6 4
        (get 4 back)
        1 2 3 5 7 8 4 6
        1 2 3 5 7 4 8 6
        1 2 3 5 4 7 8 6
        1 2 3 4 5 7 8 6
        (get 6 back)
        1 2 3 4 5 7 6 8
        1 2 3 4 5 6 7 6
*/

    }

    public static void main(String[] args)
    {
        minimumBribes(new int[] {2,1,5,3,4});
        minimumBribes(new int[] {2,5,1,3,4});
        minimumBribes(new int[] {1, 2, 5, 3, 7, 8, 6, 4});
    }
}
