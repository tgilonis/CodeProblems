package dictionaries_and_hashmaps.frequency_queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution
{

    static List<Integer> freqQuery(List<List<Integer>> queries)
    {

        HashMap<Integer, Integer> queryHistory = new HashMap<>(); //maps the number (key) to its frequency (value)
        HashMap<Integer, Integer> integerFrequency = new HashMap<>(); //maps the frequency (key) to the number of instances
        //of that frequency (value)
        List<Integer> output = new ArrayList<>();

        for(List<Integer> query : queries)
        {
            int operation = query.get(0);
            int data = query.get(1);

            System.out.println("Operation: " + operation);
            System.out.println("Data: " + data);
            System.out.println("Starting Query history: ");
            queryHistory.keySet().forEach(key ->
                    System.out.println("Key: " + key + ", Value: " + queryHistory.get(key)));
            System.out.println("Starting Frequency map: ");
            integerFrequency.keySet().forEach(key ->
                    System.out.println("Key: " + key + ", Value: " + integerFrequency.get(key)));


            if(operation==1)
            {
                if(queryHistory.get(data)!=null)
                    integerFrequency.put(queryHistory.get(data),integerFrequency.getOrDefault(data, 0)-1);

                System.out.println(queryHistory.get(data));

                queryHistory.merge(data, 1, Integer::sum);

                System.out.println(queryHistory.get(data));
                //add frequency map update here
                //when we update data, we need to decrement the frequency at the value it was at and increment
                //the frequency at the number it's going to
                integerFrequency.put(queryHistory.get(data), integerFrequency.getOrDefault(queryHistory.get(data), 0)+1);
            }

            else if(operation==2)
            {
                if(queryHistory.get(data)!=null && queryHistory.get(data)!=0)
                {
                    //need to do the opposite of the first operation - decrement the number we were at and increment
                    //the number we going to
                    queryHistory.merge(data, -1, Integer::sum);
                    integerFrequency.put(queryHistory.get(data), integerFrequency.getOrDefault(queryHistory.get(data), 0)-1);
                    integerFrequency.put(queryHistory.get(data)-1, integerFrequency.getOrDefault(queryHistory.get(data), 0)+1);
                }
            }




            else if(operation==3)
            {
                if(integerFrequency.getOrDefault(data, 0)==data)
                {
                    System.out.println("1");
                    output.add(1);
                }
                else
                {
                    System.out.println("0");
                    output.add(0);
                }
                //check frequency map and print/update accordingly
            }
            System.out.println("Ending Query history: ");
            queryHistory.keySet().forEach(key ->
                    System.out.println("Key: " + key + ", Value: " + queryHistory.get(key)));
            System.out.println("Ending Frequency map: ");
            integerFrequency.keySet().forEach(key ->
                    System.out.println("Key: " + key + ", Value: " + integerFrequency.get(key)));

        }

        return output;
    }

    public static void main(String[] args)
    {

    }
}
