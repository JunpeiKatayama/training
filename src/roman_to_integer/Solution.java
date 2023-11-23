package roman_to_integer;

import java.util.*;
import java.util.stream.IntStream;

// my answer
// https://leetcode.com/problems/roman-to-integer/
class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int n = 0;
        for(int i = 0; i < s.length(); i++) {
            final String current = Character.toString(s.charAt(i));
            String next = null;
            if(s.length() > i + 1) {
                next = Character.toString(s.charAt(i + 1));
            }
            if(next != null && map.containsKey(current + next)) {
                n += map.get(current + next);
                i += 1;
            } else {
                n += map.get(current);
            }
        }
        return n;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a = s.romanToInt("CMI");
        int b = s.romanToInt("II");
        int c = s.romanToInt("III");
        int d = s.romanToInt("IIII");
        int e = s.romanToInt("V");
        int f = s.romanToInt("X");
        int g = s.romanToInt("L");
        int h = s.romanToInt("C");
        int i = s.romanToInt("D");
        int j = s.romanToInt("M");
        int k = s.romanToInt("MCMXCIV");
        System.out.println("may be: 901," + "actual: " + a);
        System.out.println("may be: 2," + "actual: " + b);
        System.out.println("may be: 3," + "actual: " + c);
        System.out.println("may be: 4," + "actual: " + d);
        System.out.println("may be: 5," + "actual: " + e);
        System.out.println("may be: 10," + "actual: " + f);
        System.out.println("may be: 50," + "actual: " + g);
        System.out.println("may be: 100," + "actual: " + h);
        System.out.println("may be: 500," + "actual: " + i);
        System.out.println("may be: 1000," + "actual: " + j);
        System.out.println("may be: 1994," + "actual: " + k);
    }
}

// https://leetcode.com/problems/roman-to-integer/solutions/3651672/best-method-c-java-python-beginner-friendly/
class Solution2 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int n = 0;
        for(int i = 0; i < s.length(); i++) {
            // XI を例にすると、X より小さな数字 I が後に来ているので、10 - 1 の 9 になる
            // これを汎化すると、1 つずつ足して行って current < next が成り立つとき next を引いてやるだけで OK となる
            // OutOfBounds を防ぐため、next が存在しない場合は無視
            if(i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                n -= map.get(s.charAt(i));
            } else {
                n += map.get(s.charAt(i));
            }
        }
        return n;
    }
}

class Test2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int a = s.romanToInt("CMI");
        int b = s.romanToInt("II");
        int c = s.romanToInt("III");
        int d = s.romanToInt("IIII");
        int e = s.romanToInt("V");
        int f = s.romanToInt("X");
        int g = s.romanToInt("L");
        int h = s.romanToInt("C");
        int i = s.romanToInt("D");
        int j = s.romanToInt("M");
        int k = s.romanToInt("MCMXCIV");
        System.out.println("may be: 901," + "actual: " + a);
        System.out.println("may be: 2," + "actual: " + b);
        System.out.println("may be: 3," + "actual: " + c);
        System.out.println("may be: 4," + "actual: " + d);
        System.out.println("may be: 5," + "actual: " + e);
        System.out.println("may be: 10," + "actual: " + f);
        System.out.println("may be: 50," + "actual: " + g);
        System.out.println("may be: 100," + "actual: " + h);
        System.out.println("may be: 500," + "actual: " + i);
        System.out.println("may be: 1000," + "actual: " + j);
        System.out.println("may be: 1994," + "actual: " + k);
    }
}
