package dictionaries_and_hashmaps.ransom_note;

import java.util.HashMap;

public class Solution
{
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        for(String word : magazine)
            wordCount.merge(word, 1, Integer::sum);


        for(String word : note)
        {
            if(wordCount.get(word) != null)
                wordCount.put(word, wordCount.get(word)-1);
            else wordCount.put(word, -1);
        }



        for(String word : wordCount.keySet())
        {
            if(wordCount.get(word)<0)
            {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");


/*
Solution with streams:

List<String> magazineWords = Arrays.stream(magazine).sorted().collect(Collectors.toList());
boolean notRemovedWord = Arrays.stream(ransom).anyMatch(word->!magazineWords.remove(word));
System.out.println(notRemovedWord ? "No" : "Yes");
 */


    }

    public static void main(String[] args)
    {
        checkMagazine(new String[] {"give", "me", "one", "grand", "today", "night"}, new String[] {"give", "one" , "grand", "today"});
    }
}
