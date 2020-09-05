package old;

import java.util.Scanner;

public class Main8 {
    int[] tree;

    public Main8(int[] tree) {
        this.tree = tree;
    }

    public String whoWillWin(int a, int b){
        if(a == 1 || isRoot(a, b)){
            return "A";
        }else if (b == 1 || isRoot(b, a)){
            return "B";
        }

        String winner = "";
        while (a != 1 && b != 1){
            a = tree[a - 2];
            if (isRoot(a, b)){
                winner = "A";
                break;
            }
            b = tree[b - 2];
            if (isRoot(b, a)){
                winner = "B";
                break;
            }
        }

        return winner;
    }

    // first is root of second??
    public boolean isRoot(int first, int second){
        boolean ans = false;
        if (first == 1) return true;
        while (second != 1){
            if (first == second){
                return true;
            }else {
                second = tree[second - 2];
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        int m = cin.nextInt();

        int[] tree = new int[n - 1];
        for (int i = 0; i < n - 1; i++){
            tree[i] = cin.nextInt();
        }

        Main8 main = new Main8(tree);

        for (int i = 0; i < m; i++){
            System.out.println(main.whoWillWin(cin.nextInt(), cin.nextInt()));
        }
    }
}
