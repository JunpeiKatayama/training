package valid_parentheses;

import java.util.*;

// valid parentheses
// https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        // Stack は、要素を上に積み上げていくコレクション
        Stack<Character> stack = new Stack<>();
        // 1. 括弧の始まりとなる文字の場合、それと対応する閉じ括弧を stack に push する
        // 2. stack が空の場合、括弧の始まりの文字でないため、括弧の対応は崩れていると判定できる
        //    stack.pop() が現在の文字と異なる場合、括弧の対応が取れていないと判定できる
        //     -> stack は「積み上げる」コレクションのため、先に push したものの index が増えていく
        //        つまり、「最初に出現した括弧」は「最後に閉じる必要がある」を表現できるコレクションである
        for(Character c: s.toCharArray()) {
            if (c.equals('(')) {
                stack.push(')');
            } else if (c.equals('[')) {
                stack.push(']');
            } else if (c.equals('{')) {
                stack.push('}');
            } else if (stack.isEmpty() || !stack.pop().equals(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean a = s.isValid("([)]");
        boolean b = s.isValid("(]");
        boolean c = s.isValid("()[]{}");
        System.out.println("may be: false, actual: " + a);
        System.out.println("may be: false, actual: " + b);
        System.out.println("may be: true, actual: " + c);
    }
}
