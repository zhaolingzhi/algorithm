package old;

import java.util.Arrays;
import java.util.Scanner;

public class Main7 {

    public long minDis(int[] trees){
        long ans = 0;
        Arrays.sort(trees);
        int i = 0, j = trees.length - 1;
        while (i <= j){
            ans += (long)trees[j--] - (long)trees[i++];
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        Main7 main = new Main7();
        int n = cin.nextInt();
        int[] trees = new int[n];
        for (int i = 0; i < n; i++){
            trees[i] = cin.nextInt();
        }
        System.out.println(main.minDis(trees));
    }
}
