package template.dp;

public class 移除盒子 {
    public int removeBoxes(int[] boxes) {
        int[][][] dp = new int[100][100][100];
        return helper(dp, boxes, 0, boxes.length - 1, 0);
    }

    public int helper(int[][][] dp, int[] boxes, int i, int j, int k){
        if(i > j) return 0;
        if(dp[i][j][k] > 0) return dp[i][j][k];
        while(j > i && boxes[j - 1] == boxes[j]){
            j --;
            k ++;
        }
        dp[i][j][k] = helper(dp, boxes, i, j - 1, 0) + (k + 1) * (k + 1);
        for(int m = i; m < j; m++){
            if(boxes[m] == boxes[j]){
                dp[i][j][k] = Math.max(dp[i][j][k], helper(dp, boxes, i, m, k + 1) + helper(dp, boxes, m + 1, j - 1, 0));
            }
        }
        return dp[i][j][k];
    }
}
