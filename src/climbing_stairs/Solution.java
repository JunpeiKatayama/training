package climbing_stairs;

// climbStairs
// https://leetcode.com/problems/climbing-stairs/description/
// space optimization
// https://leetcode.com/problems/climbing-stairs/solutions/3708750/4-method-s-beat-s-100-c-java-python-beginner-friendly/#:~:text=Approach%204%3A%20Space%20Optimization
class Solution {
    public int climbStairs(int n) {
        // n 段目にいるということは
        // - (n - 1) 番目の階段から 1 段登った
        // - (n - 2) 番目の階段から 2 段登った
        // のどちらかである。
        // つまり、n 段目に至る方法の数は
        // (n - 1 番目の段に到達する方法の数) + (n - 2 番目の段に到達する方法の数)
        // すなわち、フィボナッチ数列の性質を持っている。
        if(n == 0 || n == 1) {
            return 1;
        }
        // 基本ケースより、1, 1, ... から始まるフィボナッチ数列
        int prev = 1;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a = s.climbStairs(2);
        int b = s.climbStairs(3);
        int c = s.climbStairs(4);
        System.out.println("may be: 2, actual: " + a);
        System.out.println("may be: 3, actual: " + b);
        System.out.println("may be: 5, actual: " + c);
    }
}
