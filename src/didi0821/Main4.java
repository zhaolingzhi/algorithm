package didi0821;

import java.util.Scanner;

public class Main4 {

    public int func(int i){
        int a = 0;
        System.out.println(i);
        func(i + 1);
        return a + i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main4 main = new Main4();
        main.func(0);
    }
}
