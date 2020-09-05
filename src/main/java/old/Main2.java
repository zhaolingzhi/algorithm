//import java.util.*;
//
//public class Main2 {
//
//    Set<Integer> sushu = new HashSet<>();
//
//    public void isSuShu(int v){
//        if (v == 0) return;
//        for (int i = 2; i < Math.sqrt(v); i++){
//            if(v % i == 0){
//                return;
//            }
//        }
//        sushu.add(v);
//    }
//
//    public void backtrack(int[] values, int l){
//        if (l < 3){
//            huiwenCheck(values, l);
//            for (int i = 0; i <= 9; i++){
//                if (i == 0 && l == 0) continue;
//                values[l] = i;
//                backtrack(values, l + 1);
//            }
//        }else if (l == 3){
//            huiwenCheck(values, l);
//        }
//    }
//
//    public int generatValue(int[] value, int l){
//        int v = 0;
//        for (int i = 0; i < l; i++){
//            v = v * 10 + value[i];
//        }
//        return v;
//    }
//
//    public void huiwenCheck(int[] value, int l){
//        if (l == 0) return;
//        int p = l;
//        for (int i = l - 2; i >= 0; i--){
//            value[p++] = value[i];
//        }
//        isSuShu(generatValue(value, p));
//        p = l;
//        for (int i = l - 1; i >= 0; i--){
//            value[p++] = value[i];
//        }
//        isSuShu(generatValue(value, p));
//    }
//
//    int[] maxmin(int v){
//        int[] ans = new int[2];
//        int len = 1;
//        while(v / (int)Math.pow(10, len) > 0){
//            len ++;
//        }
//        ans[0] = v * 10;
//        ans[1] = 9 * (int)Math.pow(10, len) + v;
//        return ans;
//    }
//
//    public int[] removep(int v){
//        String sv = String.valueOf(v);
//        int[] ans = new int[sv.length()];
//        List<Character> chseq = new ArrayList<>();
//        int idx = 0;
//        for (int i = 0; i < sv.length(); i++){
//            Character c = chseq.remove(i);
//            ans[idx++] = new StringBuilder().append(chseq);
//        }
//
//    }
//
//    public int getV(int[] value, int l){
//        int ans = 0;
//        for (int i = 0; i < l; i++){
//            ans = ans * 10 + i;
//        }
//        return ans;
//    }
//
//
//    public int func(int n, int m){
//        int[] value = new int[6];
//        backtrack(value, 0);
//        int cnt = 0;
//        for (int v : sushu){
//            int[] mm = maxmin(v);
//            if(mm[0] <= m && mm[1] >= n){
//                cnt ++;
//            }
//        }
//        return cnt;
//    }
//
//
//
//    public static void main(String[] args){
//        Scanner cin = new Scanner(System.in);
//        Main2 main = new Main2();
//        int n = cin.nextInt();
//        int m = cin.nextInt();
//        System.out.println(main.func(n, m));
//    }
//}
