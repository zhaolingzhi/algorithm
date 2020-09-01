package template.dp;

public class 错位数组的个数 {
    final static int MOD = 1000000007;

    public int findDerangement(int n) {
        if(n == 1) return 0;
        int ans = 0;
        long[] dp = new long[n + 1];
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            // 1 与 x互换， 其余错位 || 1 放到 x， x放非1的位置，
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return (int)dp[n];
    }
}
