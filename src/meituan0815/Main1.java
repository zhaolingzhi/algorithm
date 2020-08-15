package meituan0815;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    private int reverse(int v){
        int r = 0;
        while(v > 0){
            r = r * 10 + v % 10;
            v /= 10;
        }
        return r;
    }

    public List<int[]> func(int n){
        List<int[]> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            int r = reverse(i);
            if (r == i * 4){
                ans.add(new int[]{i, r});
            }
        }
        return ans;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main1 main = new Main1();
        List<int[]> ans = main.func(sc.nextInt());
        System.out.println(ans.size());
        for (int[] item : ans){
            System.out.println(item[0] + " " + item[1]);
        }
    }
}
