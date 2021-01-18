package string_manipulation.sherlock_and_the_valid_string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Solution
{
    static String isValid(String s)
    {
        HashMap<Character, Integer> letterCount = new HashMap<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (char letter : s.toCharArray())
        {
            if (letterCount.containsKey(letter))
                freqMap.merge(letterCount.getOrDefault(letter, 0), -1, Integer::sum);

            letterCount.merge(letter, 1, Integer::sum);
            freqMap.merge(letterCount.getOrDefault(letter, 0), 1, Integer::sum);
        }

        ArrayList<Integer> temp = new ArrayList<>();
        int count = 0;
        for(int num : freqMap.keySet())
        {
            if (freqMap.get(num) > 1)
            {
                count++;
                if(count>1)
                    return "NO";
            }
            if (freqMap.get(num) == 0)
                temp.add(num);
        }
        temp.forEach(freqMap::remove);

        if(freqMap.keySet().size()>2)
            return "NO";
        else
        {
            Integer[] keys = freqMap.keySet().toArray(new Integer[0]);
            if(Math.abs(keys[0]-keys[keys.length-1])>=2)
                if(!(freqMap.getOrDefault(1, 0)==1))
                    return "NO";
        }
        return "YES";
    }




    public static void main(String[] args)
    {

        //System.out.println(isValid("aaaabbcc"));
        System.out.println(isValid("aaaaabc"));
        //System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));

    }
}
