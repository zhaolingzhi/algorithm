package yuanfudao;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public int func(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] values = new int[col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            Arrays.fill(values, 0);
            for (int j = i; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    values[k] = matrix[j][k];
                }
                max = Math.max(maxSum(values), max);
            }
        }
        return max;
    }


    public int maxSum(int[] values) {
        int[] dp = new int[values.length];
        dp[0] = values[0];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(values[i], dp[i - 1] + values[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main1 main = new Main1();
        int[][] matrix = new int[sc.nextInt()][sc.nextInt()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(main.func(matrix));
    }
}
