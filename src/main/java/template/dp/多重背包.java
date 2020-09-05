package template.dp;

import java.util.Scanner;

public class 多重背包 {




    public static void multiPack(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int V = in.nextInt();
        int[] c = new int[N + 1];
        int[] w = new int[N + 1];
        int[] n = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            w[i] = in.nextInt();
            c[i] = in.nextInt();
            n[i] = in.nextInt();
        }
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= 0; j--) {
                for (int k = 0; k <= n[i]; k++) {
                    if (j >= k * c[i]) {
                        dp[j] = Math.max(dp[j - c[i] * k] + k * w[i], dp[j]);
                    }
                }
            }
        }
        System.out.println(dp[V]);
    }

    //多重背包（二进制优化）
    public static void multiPackBinary(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int V = in.nextInt();
        int[] c = new int[N + 1];
        int[] w = new int[N + 1];
        int[] n = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            w[i] = in.nextInt();
            c[i] = in.nextInt();
            n[i] = in.nextInt();
        }
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            int t = n[i];
            int k = 1;
            while (k < t) {
                for (int j = V; j >= k * c[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - k * c[i]] + k * w[i]);
                }
                k *= 2;
                t -= k;
            }
            for (int j = V; j >= t * c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - t * c[i]] + t * w[i]);
            }
        }
        System.out.println(dp[V]);
    }
}
