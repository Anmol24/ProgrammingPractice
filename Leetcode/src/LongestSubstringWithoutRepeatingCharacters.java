import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println("Longest Substring without repeating characters is: " + lengthOfLongestSubstring_2("dvdf"));
        System.out.println("Longest Substring without repeating characters is: " + lengthOfLongestSubstring_1("abcabcbb"));
        System.out.println("Longest Substring without repeating characters is: " + lengthOfLongestSubstring_2("abcaab"));
        System.out.println("Longest Substring without repeating characters is: " + lengthOfLongestSubstring_2("pwwkew"));
        System.out.println("Longest Substring without repeating characters is: " + getUniqueCharacterSubstring("abca"));
    }

    public static int lengthOfLongestSubstring_1(String s) {
        if (s.length() <= 1) return s.length();

        boolean[] mark = new boolean[256];
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mark[(int) c]) {
                // the loop update the new start point
                // and reset flag array
                // for example, abccab, when it comes to 2nd c,
                // it update start from 0 to 3, reset flag for a,b
                maxLen = Math.max(maxLen, i - start);
                while (start < i) {
                    char ch = s.charAt(start);
                    if (c == ch) {
                        start++;
                        break;
                    }
                    mark[(int) ch] = false;
                    start++;
                }
            } else {
                mark[(int) c] = true;

            }
        }
        maxLen = Math.max(maxLen, s.length() - start);
        return maxLen;
    }

    public static int lengthOfLongestSubstring_2(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> characterSet = new HashSet<>();
        while (right<s.length()) {
            if(characterSet.contains(s.charAt(right))) {
                characterSet.remove(s.charAt(left));
                left++;
            } else {
                characterSet.add(s.charAt(right));
                right++;
                max = Math.max(max, characterSet.size());
            }
        }
        return max;
    }
    static String getUniqueCharacterSubstring(String input) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar)+1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        return output;
    }

}
