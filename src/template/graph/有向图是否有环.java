package template.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 有向图是否有环 {
    UnionFind uf;

    public 有向图是否有环(int size) {
        uf = new UnionFindQuickUnion(size);
    }

    public boolean checkRing(Map<String, Integer> loc, String[][] edges){

        for (int i = 0; i < edges.length; i++){
            if (loc.get(edges[i][1]).equals(uf.find(loc.get(edges[i][0])))){
                return true;
            }else {
                uf.union(loc.get(edges[i][0]), loc.get(edges[i][1]));
            }
        }

        return false;
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int idx = 0;
        Map<String, Integer> loc = new HashMap<>();
        String[][] tickets = new String[n][2];
        for (int i = 0; i < n; i++){
            tickets[i][0] = sc.next();
            tickets[i][1] = sc.next();
            if (!loc.containsKey(tickets[i][0])){
                loc.put(tickets[i][0], idx++);
            }
            if (!loc.containsKey(tickets[i][1])){
                loc.put(tickets[i][1], idx++);
            }
        }
        有向图是否有环 main = new 有向图是否有环(loc.size());
        System.out.println(main.checkRing(loc, tickets));
    }
}
