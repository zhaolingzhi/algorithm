package template.dp;

public class 最大连续子串 {

    public int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArrayNoArray(int[] nums){
        int s = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++){
            s = Math.max(s + nums[i], nums[i]);
            max = Math.max(max, s);
        }
        return max;
    }

    public int maxSubArrayNoArrayRound(int[] nums){
        int s = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length * 2; i++){
            s = Math.max(s + nums[i % nums.length], nums[i % nums.length]);
            max = Math.max(max, s);
        }
        return max;
    }
}
