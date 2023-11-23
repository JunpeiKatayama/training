package parindrome_number;

import java.util.*;

// my answer
// https://leetcode.com/problems/palindrome-number/
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        if(x < 10) {
            return true;
        }
        int n = x;
        int reverse = 0;
        while(n > 0) {
            // x = 111 のとき...
            // 1. reverse = 0 + 1, n = 11
            // 2. reverse = 10 + 1, n = 1
            // 3. reverse = 110 + 1, n = 0
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        return x == reverse;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean a = s.isPalindrome(121);
        boolean b = s.isPalindrome(123);
        boolean c = s.isPalindrome(12121);
        boolean d = s.isPalindrome(12221);
        System.out.println("may be: true," + "actual: " + a);
        System.out.println("may be: false," + "actual: " + b);
        System.out.println("may be: true," + "actual: " + c);
        System.out.println("may be: false," + "actual: " + d);
    }
}
