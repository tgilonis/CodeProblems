package dictionaries_and_hashmaps.count_triplets;

import java.util.*;

public class Solution
{
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        HashMap<Long, Long> lMap = new HashMap<>(); //if in left map, index is less than current element's
        HashMap<Long, Long> rMap = new HashMap<>(); //if in right map, index is greater than current element's

        for(long num : arr)
            rMap.put(num, rMap.getOrDefault(num, 0L) + 1);

        long count = 0;

        for (long mid : arr)
        {
            rMap.put(mid, rMap.getOrDefault(mid, 0L) - 1);

            if (lMap.containsKey(mid / r) && mid%r==0 && rMap.containsKey(mid * r))
                count += lMap.get(mid/r)*rMap.get(mid*r);

            lMap.put(mid, lMap.getOrDefault(mid, 0L) + 1);
        }
        return count;
    }

    public static void main(String[] args)
    {
        List<Long> arr2 = new ArrayList<>(Arrays.asList(1L,2L,1L,2L,4L));
        List<Long> arr = new ArrayList<>(Arrays.asList(1L,3L,3L,9L,9L,9L,27L,81L));
        System.out.println(countTriplets(arr, 3));
        System.out.println(countTriplets(arr2, 2));
    }
}
