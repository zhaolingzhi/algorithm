package template;

public class 不重复全排列 {
    //不重复全排列
    static int[] a = {1, 1, 2};

    public static void dfs(int k) {
        if (k == a.length) {
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i] + " ");
            }
            return;
        }
        for (int i = k; i < a.length; i++) {
            if (needSwap(k, i)) {
                swap(i, k);
                dfs(k + 1);
                swap(i, k);
            }
        }
    }

    public static boolean needSwap(int from, int to) {
        for (int i = from; i < to; i++) {
            if (a[to] == a[i]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
