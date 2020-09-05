package meituan0815;

import java.util.*;


class UF {
    int[] parent;

    public UF(int size) {
        parent = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            parent[i] = i;
        }
    }

    public int find(int v) {
        int t = v;
        while (parent[t] != t) {
            t = parent[t];
        }
        return t;
    }

    public void union(int u, int v) {
        int ru = find(u);
        int rv = find(v);
        if (ru != rv) {
            parent[ru] = rv;
        }
    }
}

public class Main3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main3 main = new Main3();

        UF uf = new UF(sc.nextInt());
        int rels = sc.nextInt();
        while (rels -- > 0){
            uf.union(sc.nextInt(), sc.nextInt());
        }
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 1; i < uf.parent.length; i++){
            List<Integer> orders = map.getOrDefault(uf.find(i), new ArrayList<>());
            orders.add(i);
            map.put(uf.find(i), orders);
        }
        System.out.println(map.size());
        for (Map.Entry<Integer, List<Integer>> item : map.entrySet()){
            List<Integer> value = item.getValue();
            for (int i = 0; i < value.size(); i++){
                System.out.print(value.get(i));
                if(i < value.size() - 1){
                    System.out.print(" ");
                }else {
                    System.out.print("\n");
                }
            }
        }
    }
}
