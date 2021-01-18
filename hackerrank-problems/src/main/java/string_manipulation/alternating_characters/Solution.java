package string_manipulation.alternating_characters;

import java.util.HashMap;

public class Solution
{
    static int makeAnagram(String a, String b)
    {
        HashMap<Character, Integer> firstMap = new HashMap<>();

        for(char letter : a.toCharArray())
            firstMap.merge(letter, 1, Integer::sum);

        for(char letter : b.toCharArray())
            firstMap.merge(letter, -1, Integer::sum);

        int count = 0;

        for(Character letter : firstMap.keySet())
        {
            if(firstMap.get(letter)!=0)
                count+=Math.abs(firstMap.get(letter));
        }

        return count;
    }

    public static void main(String[] args)
    {
        System.out.println(makeAnagram("cde", "abc"));
        System.out.println(makeAnagram("cde", "dcf"));
    }
}
