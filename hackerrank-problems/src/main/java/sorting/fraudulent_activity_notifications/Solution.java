package sorting.fraudulent_activity_notifications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution
{
    static int activityNotifications(int[] expenditure, int d)
    {

        int count = 0;
        int[] currentArray = new int[201];

        Arrays.fill(currentArray, 0);
        for (int i = 0; i < d; i++)
            //increase the frequency of the element in expenditure at index i by 1
            currentArray[expenditure[i]]++;

        for (int startingIndex = d; startingIndex < expenditure.length; startingIndex++)
        {
            int[] temp = new int[201];
            temp[0] = currentArray[0];

            for (int i = 1; i < currentArray.length; i++)
                temp[i] = currentArray[i] + temp[i - 1];



            int[] smallSorted = new int[d];

            for (int i = startingIndex - 1; i >= startingIndex-d; i--)
            {
                int current = expenditure[i];
                smallSorted[temp[current] - 1] = current;
                temp[current] -= 1;
            }

            float median;
            if(d%2==0)
                median = (float)(smallSorted[d/2] + smallSorted[(d/2)-1])/(float)2;

            else
                median = smallSorted[(d/2)];

            if(expenditure[startingIndex]>=median*2)
                count++;

            //update current array with starting-d and starting for remove and add values respectively
            currentArray[expenditure[startingIndex-d]]--;
            currentArray[expenditure[startingIndex]]++;

        }
        return count;
    }

    public static void main(String[] args)
    {
        //System.out.println("Number 0: " + activityNotifications(new int[] {1,2,3,4,4}, 4));
        //System.out.println("Number 2: " + activityNotifications(new int[] {2,3,4,2,3,6,8,4,5}, 5));
        System.out.println("Number 2: " + activityNotifications(new int[] {2,3,4,2,3,6,8,4,5,2,3,4}, 5));
        //System.out.println("Number 1: " + activityNotifications(new int[] {10,20,30,40,50}, 3));
        //countingSort(new int[] {4,3,2,5,4,3,5,1,0,2,5});
        //activityNotifications(new int[] {4,3,2,5,4,3,5,1,0,2,5}, 5);
    }

    static void countingSort(int[] arr)
    {
        int[] c = new int[201];
        Arrays.fill(arr, 0);
        for(int i : arr)
            c[i]++;
        for(int i = 1; i  < c.length; i++)
            c[i]+=c[i-1];
        for(int i = 0; i  < c.length; i++)
            System.out.println(i + " : " + c[i]);
    }

    static int activityNotificationsSinglePass(int[] expenditure, int d) {
        /*int count = 0;
        //Arrays.sort(expenditure);
        System.out.println(Arrays.toString(expenditure));
        int[] currentArray = new int[201];
        Arrays.fill(currentArray, 0);

        //a common theme of increasing efficiency is using an array that records the frequency of occurrences
        for(int i : currentArray)
            currentArray[i] += 1;






        for(int i = d; i < expenditure.length-1; i++)
        {
            int median; //the median corresponds to the median of the last d values
            //as such, set up an arraylist that will keep the last d transactions, and update with each iteration

            //for each expenditure, we need to make sure that the median is being calculated correctly

            if(d%2==0)
            {
                median = (currentArray.get((d/2)) + currentArray.get((d/2)+1)/2);
            }
            else
            {
                median = currentArray.get((d/2)+1);
            }
            System.out.println("E" + expenditure[i]);
            System.out.println("M" + median);
            if(expenditure[i]>=median*2)
            {
                System.out.println("Count");
                count++;
            }

            currentArray.remove((Object)expenditure[i-d]);
            currentArray.add(expenditure[d]);
        }
        return count;*/
        int[] currentArray = new int[201];
        Arrays.fill(currentArray, 0);
        for(int i = 0; i  < d; i++)
            //increase the frequency of the element in expenditure at index i by 1
            currentArray[expenditure[i]]++;

        for(int i = 1; i  < currentArray.length; i++)
            currentArray[i]+=currentArray[i-1];


        System.out.println(Arrays.toString(currentArray));
        int[] smallSorted = new int[d];
        for(int i = d-1; i >=0; i--)
        {
            int current = expenditure[i];
            smallSorted[currentArray[current]-1] = current;
            currentArray[current]-=1;
        }

        System.out.println(Arrays.toString(smallSorted));
        System.out.println(Arrays.toString(currentArray));

        return 0;
    }
}
