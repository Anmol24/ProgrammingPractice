import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.

 Example 1:

 Input: "()"
 Output: true
 Example 2:

 Input: "()[]{}"
 Output: true
 Example 3:

 Input: "(]"
 Output: false
 Example 4:

 Input: "([)]"
 Output: false
 Example 5:

 Input: "{[]}"
 Output: true
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("{[]}{}[]("));
        System.out.println(isValid("{[]}{}[]"));
        System.out.println(isValid("()()()(())"));
    }

    public static boolean isValid(String s) {
        int len = s.length();
        if(len == 0 ) return true;
        if(len%2!=0) return false;

        Stack<Character> st = new Stack<>();
        for(int i = 0; i<len;i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if(ch == '}' && st.size()>0 && st.peek() == '{') {
                    st.pop();
                } else if(ch == ']' && st.size()>0&& st.peek() == '[') {
                    st.pop();
                } else if(ch == ')' && st.size()>0 && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.size() == 0;
    }
}
