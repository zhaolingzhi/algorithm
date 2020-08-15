package template;

import java.util.Arrays;

public class 最长上升子序列 {
            //最长上升子序列

        /*
        比如：2 5 3 4 1 7 6  其中最长上升子序列是 2 3 4 7
        */
        public int lengthOfLIS(int[] nums){
            if(nums.length == 0) return 0;
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int maxLen = 1;

            for(int i = 0; i < nums.length; i++){
                for(int j = 0; j < i;j ++){
                    if(nums[i] > nums[j]){
                        dp[i] = dp[i] < dp[j] + 1? dp[j] + 1 : dp[i];
                        maxLen = dp[i] > maxLen? dp[i] : maxLen;
                    }
                }
            }
            return maxLen;
        }

        public int lengthOfLISQuick(int[] nums){
            if(nums.length == 0) return 0;
            int[] lengthRecorder = new int[nums.length + 1];
            int idx = 0;
            lengthRecorder[0] = Integer.MIN_VALUE;
            for(int i = 0; i < nums.length; i++){
                for(int j = idx; j >= 0; j--){
                    if(nums[i] > lengthRecorder[j]){
                        lengthRecorder[j + 1] = nums[i];
                        idx = idx > j + 1? idx : j + 1;
                        break;
                    }else if(nums[i] == lengthRecorder[j]){
                        break;
                    }
                }
            }
            return idx;
        }
}
