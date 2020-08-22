package didi0821;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    public List<int[]> func(int num) {
        List<int[]> ans = new ArrayList<>();
        if (num % 2 != 0 || num > 1966 || num < 220) {
            return ans;
        }
        for (int i = 1; i <= 9; i++) {
            for(int j = 0; j <= 9; j++){
                for (int k = 0; k <= 9; k++){
                    if(i != j && i != k && j != k){
                        int x = i * 100 + j * 10 + k;
                        int y = i * 100 + k * 10 + k;
                        if (x + y == num){
                            ans.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main1 main = new Main1();
        List<int[]> ans = main.func(sc.nextInt());
        System.out.println(ans.size());
        for (int[] item : ans){
            System.out.println(item[0] + " " + item[1]);
        }
    }
}
