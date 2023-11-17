import java.util.*;
import java.util.stream.IntStream;

// my answer
// https://leetcode.com/problems/two-sum/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        return Arrays.stream(nums).mapToObj(num -> {
            final int answer = target - num;
            List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
            int currentIndex = list.indexOf(num);
            if (!list.contains(answer)) {
                return null;
            }
            int partnerIndex = list.lastIndexOf(answer);
            if (partnerIndex == currentIndex) {
                return null;
            }
            return new int[]{currentIndex, partnerIndex};
        }).filter(Objects::nonNull).findFirst().orElse(null);
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = s.twoSum(new int[]{1,2,3,4,5,6}, 6);
        int[] b = s.twoSum(new int[]{3,3}, 6);
        int[] c = s.twoSum(new int[]{3,2,4}, 6);
        int[] d = s.twoSum(new int[]{0,4,3,0}, 0);
        System.out.println("may be: [0, 4]," + "actual: " + Arrays.toString(a));
        System.out.println("may be: [0, 1]," + "actual: " + Arrays.toString(b));
        System.out.println("may be: [1, 2]," + "actual: " + Arrays.toString(c));
        System.out.println("may be: [0, 3]," + "actual: " + Arrays.toString(d));
    }
}

// brute force
// https://leetcode.com/problems/two-sum/editorial/?source=submission-ac#:~:text=Approach%201%3A%20Brute%20Force
// Time complexity  : O(n^2) ... O(n) の処理の中に O(n) の処理があるため
// Space complexity : 0(1)   ... 必要なスペースが入力配列のサイズに依存しないため一定
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

class Test2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] a = s.twoSum(new int[]{1,2,3,4,5,6}, 6);
        int[] b = s.twoSum(new int[]{3,3}, 6);
        int[] c = s.twoSum(new int[]{3,2,4}, 6);
        int[] d = s.twoSum(new int[]{0,4,3,0}, 0);
        System.out.println("may be: [0, 4]," + "actual: " + Arrays.toString(a));
        System.out.println("may be: [0, 1]," + "actual: " + Arrays.toString(b));
        System.out.println("may be: [1, 2]," + "actual: " + Arrays.toString(c));
        System.out.println("may be: [0, 3]," + "actual: " + Arrays.toString(d));
    }
}

// two-pass hash table
// https://leetcode.com/problems/two-sum/editorial/?source=submission-ac#:~:text=Approach%202%3A%20Two%2Dpass%20Hash%20Table
// Time complexity  : O(n) ... O(n) がネストされていないため
// Space complexity : O(n) ... map に入力値分のサイズが必要なため
// 1. key: num, value: index の Map を作成
// 2. nums をループして、Map に補数が存在するかチェック
// 3. 補数が Map に存在する場合、その補数の持つ value(index) が現在検証中の index と一致**しない**場合、解となる
// 　　※補数 ... 1 + x = 10 の x 部分 この場合は 9 が補数
class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        return null;
    }
}

class Test3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int[] a = s.twoSum(new int[]{1,2,3,4,5,6}, 6);
        int[] b = s.twoSum(new int[]{3,3}, 6);
        int[] c = s.twoSum(new int[]{3,2,4}, 6);
        int[] d = s.twoSum(new int[]{0,4,3,0}, 0);
        System.out.println("may be: [0, 4]," + "actual: " + Arrays.toString(a));
        System.out.println("may be: [0, 1]," + "actual: " + Arrays.toString(b));
        System.out.println("may be: [1, 2]," + "actual: " + Arrays.toString(c));
        System.out.println("may be: [0, 3]," + "actual: " + Arrays.toString(d));
    }
}