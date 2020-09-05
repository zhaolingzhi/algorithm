package meituan0815;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface UnionFind{
    int find(int v);
    void union(int u, int v);
    boolean isConnect(int u, int v);
    void init();
}

abstract class AbstractUnionFind implements UnionFind {
    int[] parents;
    int size;


    public AbstractUnionFind(int size) {
        this.size = size;
        parents = new int[size];
        for (int i = 0; i < size; i++){
            parents[i] = i;
        }
    }

    @Override
    public abstract int find(int v);

    @Override
    public abstract void union(int u, int v);

    @Override
    public boolean isConnect(int u, int v) {
        return find(u) == find(v);
    }

    @Override
    public void init() {
        for (int i = 0; i < size; i++){
            parents[i] = i;
        }
    }
}


class UnionFindQuickUnion extends AbstractUnionFind {

    public UnionFindQuickUnion(int size) {
        super(size);
    }

    @Override
    public int find(int v) {
        int parent = parents[v];
        while (parent != parents[parent]){
            parent = parents[parent];
        }
        return parent;
    }

    @Override
    public void union(int u, int v) {
        int firstParent = find(u);
        int secondParent = find(v);
        if (firstParent != secondParent){
            parents[secondParent] = firstParent;
        }
    }
}

public class Main5 {

    public int func(Map<String, Integer> loc, String[][] tickets){
        UnionFind uf = new UnionFindQuickUnion(loc.size());
        int cnt = 0;
        for (int i = 0; i < tickets.length; i++){
            String start = tickets[i][0];
            String end = tickets[i][1];

            if (uf.find(loc.get(start)) == loc.get(start)){
                uf.init();
            }
            if (loc.get(end) == uf.find(loc.get(start))){
                cnt ++;
                uf.init();
                continue;
            }
            uf.union(loc.get(start), loc.get(end));
        }
        return cnt;
    }


    public static void main(String[] args) {

        String a = new String("abc");
        String b = "abc";
        System.out.println(a.intern() == b);

//        Scanner sc = new Scanner(System.in);
//        Main5 main = new Main5();
//        int n = sc.nextInt();
//        int idx = 0;
//        Map<String, Integer> loc = new HashMap<>();
//        String[][] tickets = new String[n][2];
//        for (int i = 0; i < n; i++){
//            tickets[i][0] = sc.next();
//            tickets[i][1] = sc.next();
//            if (!loc.containsKey(tickets[i][0])){
//                loc.put(tickets[i][0], idx++);
//            }
//            if (!loc.containsKey(tickets[i][1])){
//                loc.put(tickets[i][1], idx++);
//            }
//        }
//        System.out.println(main.func(loc, tickets));
    }
}
