package old;

import java.util.Arrays;
import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Main6 main = new Main6();
        int nodes = cin.nextInt();
        int edges = cin.nextInt();
        int[] edgeW = new int[edges];
        for (int i = 0; i < edges; i++){
            cin.nextInt();
            cin.nextInt();
            edgeW[i] = cin.nextInt();
        }
        Arrays.sort(edgeW);
        int resEdges = nodes - 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < edges - resEdges; i++){
            min = Math.min(min, edgeW[i + resEdges - 1] - edgeW[i]);
        }
        System.out.println(min);
    }
}
