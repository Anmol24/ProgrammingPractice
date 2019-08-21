/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Bonus Points to solve it without converting it into string.
 */
public class PalindromeNumberLeetcode {

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(1331));
    }
    public static boolean isPalindrome(int x) {
//         if(num < 0 ) return false;
//         if(num < 10) return true;

//         String number = String.valueOf(num);
//         int start = 0;
//         int len = number.length() -1;
//         while(start<len) {
//             if(number.charAt(start)!=number.charAt(len)) return false;
//             start++;
//             len--;
//         }
//         return true;

        if(x<0) return false;
        int digit = 0;
        int num = x;
        while(x>=10) {
            x = x /10;
            digit++;
        }

        while(num>0) {
            int power = (int)Math.pow(10, digit);
            int que = num/power;
            int rem = num %10;
            if(que!=rem) return false;
            num = num%power;
            num = num/10;

            digit -=2;
        }
        return true;



    }
}



