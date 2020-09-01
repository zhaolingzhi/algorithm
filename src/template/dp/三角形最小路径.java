package template.dp;

import java.util.List;

public class 三角形最小路径 {

    // 自上而下
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        int mininum = dp[0];
        for(int i = 1; i < triangle.size(); i++){
            mininum = Integer.MAX_VALUE;
            for(int j = triangle.get(i).size() - 1; j >= 0; j--){
                if(j == 0){
                    dp[j] += triangle.get(i).get(0);
                }else if(j == triangle.get(i).size() - 1){
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                }else{
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                }
                mininum = Math.min(mininum, dp[j]);
            }
        }
        return mininum;
    }

    //自下而上
    public int minimumTotalUp(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for(int i = triangle.size() - 1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
