package longest_common_prefix;

import java.util.*;

// longest common prefix
// https://leetcode.com/problems/longest-common-prefix/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        // 文字列順にソートして、その最初と最後のプレフィックスを比較すれば OK
        // ソートすることで簡単になる典型的なパターン
        List<String> sorted = Arrays.stream(strs).sorted().toList();
        String first = sorted.get(0);
        String last = sorted.get(sorted.size() - 1);
        int end = Math.min(first.length(), last.length());
        for(int i = 0; i < end; i++) {
            if(first.charAt(i) == last.charAt(i)) {
                ans.append(first.charAt(i));
            } else {
                break;
            }
        }
        return ans.toString();
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        String a = s.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        String b = s.longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        System.out.println("may be: fl, actual: " + a);
        System.out.println("may be: empty, actual: " + b);
    }
}
