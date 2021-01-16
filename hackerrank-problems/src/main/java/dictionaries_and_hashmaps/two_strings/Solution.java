package dictionaries_and_hashmaps.two_strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution
{
    static String twoStrings(String s1, String s2)
    {
        //do two strings share a common substring (down to one character in length)

       /* for(int i = 0; i < s1.length(); i++)
        {
            if(s2.contains(s1.substring(i, i+1)))
            {
                return "Yes";
            }
        }
       return "No";*/

        Set<String> s1Set = new HashSet<>(Arrays.asList(s1.split("")));
        Set<String> s2Set = new HashSet<>(Arrays.asList(s2.split("")));
        s1Set.retainAll(s2Set);
        if(s1Set.size()>0)
            return "Yes";
        else
            return "No";


    }

    public static void main(String[] args)
    {
        System.out.println(twoStrings("hello", "world"));
    }
}
