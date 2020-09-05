package template.dp;

import java.util.Arrays;

public class 火柴能否搭建正方形 {
    // 平均分成4组
    public boolean makesquare(int[] nums) {
        if (nums.length == 0) return false;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 4 != 0) return false;
        int sideLen = sum / 4;
        boolean[] flags = new boolean[nums.length];
        Arrays.sort(nums);

        return helper(nums, flags, 0, sideLen, sideLen, 0);
    }

    public boolean helper(int[] nums, boolean[] flags, int idx, int res, int sideLen, int side) {
        if (side == 4) return true;
        if (res == 0) return helper(nums, flags, 0, sideLen, sideLen, side + 1);
        if (idx == nums.length) return false;

        if (flags[idx]) return helper(nums, flags, idx + 1, res, sideLen, side);
        if (nums[idx] > res) {
            return false;
        } else {
            flags[idx] = true;
            boolean use = helper(nums, flags, idx + 1, res - nums[idx], sideLen, side);
            if (use) return true;
            flags[idx] = false;
            return helper(nums, flags, idx + 1, res, sideLen, side);
        }
    }
}
