package didi0821;

import java.util.Scanner;

public class Main2 {

    public long[][] func(int n){
        long[] array = new long[n * n];
        long[][] ans = new long[n][n];
        if (n == 1){
            ans[0][0] = 1;
            return ans;
        }
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < n * n; i++){
            array[i] = array[i - 1] + array[i - 2];
        }
        final int[] dir = new int[]{0, 1, 0, -1, 0};
        int idx = n * n - 1;
        int i = 0, j = 0;
        int d = 0;
        while (idx >= 0){
            if (i < 0 || i >= n || j < 0 || j >= n || ans[i][j] != 0){
                i -= dir[d];
                j -= dir[d + 1];
                d = (d + 1) % 4;
                i += dir[d];
                j += dir[d + 1];
            }
            ans[i][j] = array[idx--];
            i += dir[d];
            j += dir[d + 1];
        }

        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main2 main = new Main2();
        int n = sc.nextInt();
        if (n == 0){
            return;
        }
        long[][] ans = main.func(n);
        for (int i = 0; i < ans.length; i++){
            for (int j = 0; j < ans.length; j++){
                System.out.print(ans[i][j]);
                if (j < ans.length - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
