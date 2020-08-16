package template;

import java.util.*;

public class 有向图 {
    Map<String, Set<String>> adj;
    Map<String, int[]> degree;

    public 有向图() {
        adj = new HashMap<>();
        degree = new HashMap<>();
    }

    public void insert(String start, String end){
        Set<String> endNodes = adj.getOrDefault(start, new HashSet<>());
        endNodes.add(end);
        int[] startd = degree.getOrDefault(start, new int[2]);
        int[] endd = degree.getOrDefault(end, new int[2]);
        startd[0] ++;
        endd[1] ++;
        adj.put(start, endNodes);
        degree.put(start, startd);
        degree.put(end, endd);
    }
}
