package meituan0815;

import java.util.Scanner;

public class Main2 {

    public int func(int n, int m){
        int cnt = 0;
        for (int i = 1; i <= n; i++){
            cnt += backtrack(i, n, 1, m);
            cnt %= 998244353;
        }
        return cnt;
    }


    public int backtrack(int v, int n, int idx, int m){
        if (idx == m){
            return 1;
        }else {
            int cnt = 0;
            for (int i = v; i <= n; i += v){
                if (i % v == 0){
                    cnt += backtrack(i, n, idx + 1, m);
                    cnt %= 998244353;
                }
            }
            return cnt;
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main2 main = new Main2();

        System.out.println(main.func(sc.nextInt(), sc.nextInt()));


    }
}
