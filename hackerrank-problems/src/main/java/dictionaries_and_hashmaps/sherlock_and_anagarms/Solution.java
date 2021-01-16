package dictionaries_and_hashmaps.sherlock_and_anagarms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution
{
    static int sherlockAndAnagrams(String s)
    {
        //a word is an anagram of another word when they contain the same letters in a different order

        //if we iterate through a string, create each possible substring, sort the char array and add to dictionary,
        //we can then check the number of appearances of each substring
        //if more than once, we have anagrams

        HashMap<String, Integer> anagramMap = new HashMap<>();
        for(int i = 0; i <= s.length(); i++)
            for(int j = i+1; j <= s.length(); j++)
            {
                char[] sorted = s.substring(i,j).toCharArray();
                Arrays.sort(sorted);
                anagramMap.merge(Arrays.toString(sorted), 1, Integer::sum);
            }

        int count = 0;

        for(String anagram : anagramMap.keySet())
        {
            int matches = anagramMap.get(anagram);
            /*
            If an substring has more than 1 occurrences, it has the number of anagrams equal to the sum of numbers up to
            the number of its occurrences
             */
            while(matches!=1)
            {
                matches --;
                count += matches;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        System.out.println(" 4 - " + sherlockAndAnagrams("abba"));
        System.out.println(" 0 - " + sherlockAndAnagrams("abcd"));
        System.out.println(" 3 - " + sherlockAndAnagrams("ifailuhkqq"));
        System.out.println(" 10 - " + sherlockAndAnagrams("kkkk"));
    }

}
