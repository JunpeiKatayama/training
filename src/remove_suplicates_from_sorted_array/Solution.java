package remove_suplicates_from_sorted_array;

// answer
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    public int removeDuplicates(int[] nums) {
        // index を 2 つ使って解くというソリューション
        //
        // ソート済み nums は必ず１から始まる、
        // nums[j] には、ソートしたときの新しい値が入る。
        // nums をループして、current と prev が一致しない場合、
        // nums[j] に current をセットし、j をインクリメントする。
        //
        // [1, 1, 2] の場合...
        // 1. j: 1, current: 1, prev: 1 のため、次のループへ
        //    -> nums: [1, 1, 2]
        // 2. j: 1, current: 2, prev: 1 のため、nums[1] を current と置き換え
        //    -> nums: [1, 2, 2]
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a = s.removeDuplicates(new int[]{1, 1, 2});
        int b = s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println("expect: 2, actual: " + a);
        System.out.println("expect: 5, actual: " + b);
    }
}
