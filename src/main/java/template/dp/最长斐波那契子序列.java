package template.dp;

import java.util.HashMap;
import java.util.Map;

public class 最长斐波那契子序列 {
    public int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> record = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            map.put(A[i], i);
        }
        int n = A.length;
        int max = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = i - 1; j >= 0 && A[j] > A[i] - A[j]; j--){
                if(map.containsKey(A[i] - A[j])){
                    int s = map.get(A[i] - A[j]);
                    int len = record.getOrDefault(s * n + j, 2) + 1;
                    record.put(j * n + i, len);
                    max = Math.max(max, len);
                }
            }
        }
        return max;
    }
}
