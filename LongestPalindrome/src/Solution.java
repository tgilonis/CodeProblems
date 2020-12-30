import java.util.stream.IntStream;

public class Solution
{
    int resultStart;
    int resultLength;

    public static void main(String[] args)
    {
        System.out.println(new Solution().longestPalindrome("ababbabaqwewq"));
    }

    public String longestPalindrome(String s)
    {
        if(s.length()<2)
            return s;

        //will need to check each letter twice, once as odd and once as even string length start point

        for(int start = 0; start < s.length()-1; start++)
        {
            checkPalindrome(s, start, start);
            checkPalindrome(s, start, start+1);
        }

        return s.substring(resultStart, resultStart + resultLength);
    }



    void checkPalindrome(
            String s,
            int begin,
            int end)
    {


        while(begin >= 0
                && end < s.length()
                && s.charAt(begin)==(s.charAt(end))) //character equality check has to be after index bounds check
        {
            begin--;
            end++;
        }

        if (resultLength < end - begin - 1)
        {
            resultStart = begin+1;
            resultLength = end - begin - 1;
        }

    }
}
