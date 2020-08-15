package old;

import java.util.Scanner;

public class Main5 {
    public int minDrop(int[] items){
        int sum = 0;
        for (int item : items){
            sum += item;
        }
        return sum - backtrack(items, 0, 0, 0, 0) * 2;
    }

    public int backtrack(int[] items, int wa, int wb, int idx, int maxw){
        if (idx < items.length){
            if (wa == wb){
                maxw = Math.max(maxw, wa);
            }
            // for a
            int maxForA = backtrack(items, wa + items[idx], wb, idx + 1, maxw);
            int maxForB = backtrack(items, wa, wb + items[idx], idx + 1, maxw);
            int maxDrop = backtrack(items, wa, wb, idx + 1, maxw);

            maxw = Math.max(Math.max(maxForA, maxForB),Math.max(maxw, maxDrop));
            return maxw;
        }else {
            if (wa == wb){
                maxw = Math.max(maxw, wa);
            }
            return maxw;
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Main5 main = new Main5();
        int g = cin.nextInt();
        while (g -- > 0){
            int n = cin.nextInt();
            int[] items = new int[n];
            for (int i = 0; i < n; i++){
                items[i] = cin.nextInt();
            }
            System.out.println(main.minDrop(items));
        }
    }
}
