package sorting.mark_and_toys;

import java.util.Arrays;

public class Solution
{
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int count = 0;
        int currentCost = 0;
        for(int price : prices)
        {

            currentCost+=price;

            if(currentCost>k)
                return count;
            else
                count++;
        }
        return count;

    }

    public static void main(String[] args)
    {
        System.out.println(maximumToys(new int[] {1,12,5,111,200,1000,10}, 50));
    }
}
