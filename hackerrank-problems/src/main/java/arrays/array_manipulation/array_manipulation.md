https://www.youtube.com/watch?v=JtJKn_c9lB4&feature=youtu.be

Runtime: O(n + m)
Space Complexity: O(n)

Make sure to use long instead of int to avoid integer overflow.

Don't update all values in your array. Just update the interval's endpoint values as shown below.

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        
        /* Save interval endpoint's "k" values in array */
        long [] array = new long[N + 1];
        while (M-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int k = scan.nextInt();
            array[a-1] += k;
            array[b]   -= k;
        }
        scan.close();
        
        /* Find max value */
        long sum = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            sum += array[i];
            max = Math.max(max, sum);
        }
        
        System.out.println(max);
    }
}
For each of the "m" operations, we do not want to take O(n) time to process it. That's because our runtime will end up being O(nm). To get a O(n+m) runtime, we have to process each operation in O(1) time. To do so, we keep track of just the endpoints, which are just 2 numbers, instead of the O(n) numbers in between the endpoints. This is the main idea to decrease our runtime.

For a value k, we can mark its left endpoint a in the original array, along with its right endpoint b in the original array. To distinguish between a and b we can store +k for a and -k for b. Now, we technically have stored all information that the m operations represent, into an array. Most importantly, we stored it in O(m) time.

The next step is to actually find the maximum value based off of our unique representation of the data. We traverse our array from left to right. Whenever we reach a left endpoint a (which we represented with a positive number), we just add that to our sum. Whenever we reach a right endpoint b (which we represented with a negative number), we subtract that from our sum (well, technically we add a negative value). By doing so, the value sum represents the value that array[i] would have if we had applied all m operations to it. The maximum value of sum that we get while traversing the array is the value we return. If this algorithm is still unclear to you, try walking through HackerRank's Testcase 0 with the code above.

Let's try an example
Let's try to walk through an example. If we have 1 query and it wants to add 100 to elements 2 through 4 inclusive in a 7-element array, we want to have:

[0, 0, 100, 100, 100, 0, 0]
The idea is that we can represent this initially as:

[0, 0, 100, 0, 0, -100, 0]
It's important to realize that this above array is not our final answer. We will walk through the array from array[0] to array[6] to create our final answer. When we reach array[2], it basically tells us that every element from here and to the right of it (array[2] to array[6]) should have 100 added to them. When we reach array[5], it tells us the same thing, except that every element should have -100 added to it. By following these 2 rules, we get

array[0] = 0;
array[1] = 0;
array[2] = 0 + 100 = 100;
array[3] = 0 + 100 = 100;
array[4] = 0 + 100 = 100;
array[5] = 0 + 100 - 100 = 0;
array[5] = 0 + 100 - 100 = 0;
giving us the final array of

[0, 0, 100, 100, 100, 0, 0]