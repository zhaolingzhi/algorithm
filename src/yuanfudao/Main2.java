package yuanfudao;

import java.util.Scanner;

public class Main2 {
    static StringBuilder ans = new StringBuilder();
    static int[] values;
    public void func(int n){
        dfsFirst(n, 0);

        int lastIdx = 0;
        int rIdx = 0;
        while (rIdx < n){
            lastIdx = rIdx;
            rIdx = 2 * rIdx + 2;
        }
        leaves(n, lastIdx);
        dfsSecond(n, 2);
    }

    public void dfsFirst(int n, int m){
        if(m < n){
            ans.append(values[m]).append(" ");
            dfsFirst(n, 2 * m + 1);
        }
    }

    public void leaves(int n, int rIdx){
        int start = n / 2;
        for(int i = rIdx + 2; i < n; i++){
            ans.append(values[i]).append(" ");
        }
        for(int i = start; i < rIdx; i++){
            ans.append(values[i]).append(" ");
        }
    }

    public void dfsSecond(int n, int m){
        if(m < n){
            dfsSecond(n, 2 * m + 2);
            ans.append(values[m]).append(" ");
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main2 main = new Main2();
        int n = sc.nextInt();
        values = new int[n];
        for (int i = 0; i < n; i++){
            values[i] = sc.nextInt();
        }
        main.func(n);
        System.out.println(ans.toString().trim());
    }
}
