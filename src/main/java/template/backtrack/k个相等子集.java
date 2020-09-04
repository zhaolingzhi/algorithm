package template.backtrack;

public class k个相等子集 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = max > nums[i]? max : nums[i];
        }
        if(sum % k != 0 || max > sum / k) return false;
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, k, sum / k, 0, 0);
    }

    private boolean backtrack(int[] nums, boolean[] used, int k, int target, int cur, int start){
        if(k == 0) return true;
        if(target == cur) return backtrack(nums, used, k - 1, target, 0, 0);
        for(int i = start; i < nums.length; i++){
            if(!used[i] && cur + nums[i] <= target){
                used[i] = true;
                if(backtrack(nums, used, k, target, cur + nums[i], i + 1)) return true;
                used[i] = false;
            }
        }
        return false;
    }

}
