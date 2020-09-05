package meituan0815;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {

        public int maxProfit(int A, int B, int[][] profits){
        int[][] dp = new int[A + 1][B + 1];
        int n = profits.length;
        for (int i = 1; i < n + 1; i++){
            for (int a = A; a >= 0; a--){
                for (int b = B; b >= 0; b--){
                    if (a == 0 && b == 0){
                        continue;
                    }else if (a == 0){
                        dp[a][b] = dp[a][b - 1] + profits[i - 1][1];

                    }else if (b == 0){
                        dp[a][b] = dp[a - 1][b] + profits[i - 1][0];

                    }else {
                        dp[a][b] = Math.max(dp[a - 1][b] + profits[i - 1][0], dp[a][b - 1] + profits[i - 1][1]);
                    }
                }
            }
        }
        return dp[A][B];
    }
//    public int maxProfit(int A, int B, Integer[][] profits) {
//        Arrays.sort(profits, (o1, o2) -> {
//            o2[0] - o1
//        });
//        return dp[A][B];
//    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Main4 main = new Main4();
//        int n = sc.nextInt();
//        int A = sc.nextInt();
//        int B = sc.nextInt();
//        int[][] profits = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            profits[i][0] = sc.nextInt();
//            profits[i][1] = sc.nextInt();
//        }
//        System.out.println(main.maxProfit(A, B, profits));
//    }
}
