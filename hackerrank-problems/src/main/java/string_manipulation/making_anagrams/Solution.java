package string_manipulation.making_anagrams;

public class Solution
{
    static int alternatingCharacters(String s)
    {
        int count = 0;
        char prevChar = s.charAt(0);
        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i)!=prevChar)
                prevChar = s.charAt(i);
            else
                count++;
        }
        return count;
    }

    public static void main(String[] args)
    {
        System.out.println(alternatingCharacters("AABAAB"));
    }
}
