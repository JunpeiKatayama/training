import java.util.*;
import java.util.stream.IntStream;

// to_sum(my answer)
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

// two_sum(brute force)
// https://leetcode.com/problems/two-sum/editorial/?source=submission-ac#:~:text=Approach%201%3A%20Brute%20Force
// Time complexity : O(n^2) ... O(n) の処理が２つあるため
// Space complexity: 0(1)   ... 必要なスペースが入力配列のサイズに依存しないため一定
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
            