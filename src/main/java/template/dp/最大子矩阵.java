package template.dp;

public class 最大子矩阵 {

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

    public int getMaxMatrix(int[][] matrix) {
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            int[] sLine = new int[matrix[0].length];
            for(int j = i; j < matrix.length; j++){
                for(int k = 0; k < sLine.length; k++){
                    sLine[k] += matrix[j][k];
                }
                maxArea = Math.max(maxArea, maxSubArray(sLine));
            }
        }
        return maxArea;
    }

    // 返回地址
    public int[] getMaxMatrixReturnPos(int[][] matrix) {
        int[] pos = new int[4];
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            int[] sLine = new int[matrix[0].length];
            for(int j = i; j < matrix.length; j++){
                int[] dp = new int[sLine.length];
                sLine[0] += matrix[j][0];
                dp[0] = sLine[0];
                maxArea = maxArea > sLine[0]? maxArea : sLine[0];
                int s = 0;
                int e = 0;
                for(int k = 1; k < sLine.length; k++){
                    sLine[k] += matrix[j][k];
                    dp[k] = Math.max(dp[k - 1] + sLine[k], sLine[k]);
                    if(dp[k - 1] > 0){
                        e = k;
                    }else{
                        s = k;
                        e = k;
                    }
                    if(dp[k] > maxArea){
                        maxArea = dp[k];
                        pos[0] = i;
                        pos[1] = s;
                        pos[2] = j;
                        pos[3] = e;
                    }
                }
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        最大子矩阵 main = new 最大子矩阵();
        int[][] matrix = new int[][]{
                {1,3,1},
                {2,1,2},
                {-3,0,1}
        };
        System.out.println(main.getMaxMatrix(matrix));

    }
}
