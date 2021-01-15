package arrays._2D_array;
import java.io.*;
import java.util.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        //an hourglass has a max starting point of [3][3] given we know that the matrix is [5][5], and an
        //hourglass in 3 in width and 3 in height
        //we can iterate through the matrix with this in mind and sum up the hourglasses into a list
        //from there, take the max value
        ArrayList<Integer> hourglassValues = new ArrayList<>();

        for(int j = 0; j <= 3; j++)
            for(int i = 0; i <= 3; i++)
            {
                hourglassValues.add(arr[j][i] + arr[j][i+1] + arr[j][i+2]
                                            + arr[j+1][i+1] +
                        arr[j+2][i] + arr[j+2][i+1] + arr[j+2][i+2]);
            }

        return Collections.max(hourglassValues);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}