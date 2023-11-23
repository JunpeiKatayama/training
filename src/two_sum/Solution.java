package two_sum;

import java.util.*;

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
        int[] a = s.twoSum(new int[]{1,2,3,7,5,6}, 6);
        int[] b = s.twoSum(new int[]{3,3}, 6);
        int[] c = s.twoSum(new int[]{3,2,4}, 6);
        int[] d = s.twoSum(new int[]{0,4,3,0}, 0);
        System.out.println("may be: [0, 4]," + "actual: " + Arrays.toString(a));
        System.out.println("may be: [0, 1]," + "actual: " + Arrays.toString(b));
        System.out.println("may be: [1, 2]," + "actual: " + Arrays.toString(c));
        System.out.println("may be: [0, 3]," + "actual: " + Arrays.toString(d));
    }
}
