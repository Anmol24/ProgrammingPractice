import java.util.ArrayList;
import java.util.List;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

 */
public class WordBreakLeetcode {

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("leet");
        dictionary.add("code");
        String word = "leetcode";
        System.out.println(wordBreak(word, dictionary));
    }

    /**
     * We break down the word into length of 1, 2, 3 and so on until n. If word of given length exists in dictionary
     * mark it as true, Else break the word into smaller pieces to see if the individual pieces exist in dictionary or not.
     * For example. if you are checking for leetcode (since it does not exist in dictionary), break it to l, eetcode, le, etcode,
     * lee, tcode, leet, code until all the broken pieces are there in dictionary. And in future if the string changes to isleetcode,
     * then we would need to check if is exist in dictionary or not as we know that leetcode is already there in our dictionary.
     * @param word input word to break
     * @param dictionary dictionary containing list of words
     * @return true/false if the word can be broken into pieces
     */
    private static boolean wordBreak(String word, List<String> dictionary) {
        if(word == null || word.length() == 0 || dictionary == null || dictionary.size() == 0) return false;
        int length = word.length();
        boolean[][] result = new boolean[length][length];
        int j;

        for(int len = 1; len <=length; len++) {
            for(int i = 0; i<=length -len;i++) {
                j = i+len-1;
                if(dictionary.contains(word.substring(i,j+1))) {
                    result[i][j] = true;
                } else {
                    for(int k = i+1;k<=j;k++) {
                        if(result[i][k-1] && result[k][j]) {
                            result[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return result[0][length-1];


    }
}
