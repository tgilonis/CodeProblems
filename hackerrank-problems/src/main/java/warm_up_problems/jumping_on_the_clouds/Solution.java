package warm_up_problems.jumping_on_the_clouds;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        String[] clouds = Arrays.stream(c).mapToObj(String::valueOf).toArray(String[]::new);
        String[] sections = String.join("", clouds).split("1");
        int jumps = sections.length-1;
        for(String section : sections)
            jumps+=section.length()/2;
        return jumps;

    }
    static int simpleJumpingOnClouds(int[] c) {
        int jumps = 0;
        int currentZeros = 0;

        for(int cloud : c)
        {
            if(cloud==0)
            {
                currentZeros += 1;
            }
            else if(cloud==1)
            {
                jumps += currentZeros/2;
                currentZeros = 0;
                jumps += 1;
            }
        }
        jumps += currentZeros/2;

        return jumps;

    }




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
        /*
        System.out.println(jumpingOnClouds(new int[] {0,0,1,0,0,1,0}));

        System.out.println(jumpingOnClouds(new int[] {0,0,0,0,0,0,0,1,0}));*/
        System.out.println("3: " + jumpingOnClouds(new int[] {0,0,0,0,1,0}));
        System.out.println("4: " + jumpingOnClouds(new int[] {0,0,1,0,0,1,0}));
        System.out.println("3: " + jumpingOnClouds(new int[] {0,0,0,1,0,0}));

        System.out.println("9: " + jumpingOnClouds(new int[] {0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0}));

        System.out.println("3: " + jumpingOnClouds(new int[] {0,1,0,1,0,1,0}));
        System.out.println("3: " + jumpingOnClouds(new int[] {0,0,0,0,1,0}));

        System.out.println("Simple 3: " + simpleJumpingOnClouds(new int[] {0,0,0,0,1,0}));
        System.out.println("Simple 4: " + simpleJumpingOnClouds(new int[] {0,0,1,0,0,1,0}));
        System.out.println("Simple 3: " + simpleJumpingOnClouds(new int[] {0,0,0,1,0,0}));
        System.out.println("Simple 9: " + simpleJumpingOnClouds(new int[] {0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0}));
        System.out.println("Simple 3: " + simpleJumpingOnClouds(new int[] {0,1,0,1,0,1,0}));
        System.out.println("Simple 3: " + simpleJumpingOnClouds(new int[] {0,0,0,0,1,0}));


    }
}
