package template.backtrack;

public class 不重复一般组合 {
    //不重复一般组合（例如，从4个中选3个所有组合）
    static int[] a = {1, 1, 2, 4};

    public static void select_combination(int k, int n) {
        if (k == n) {
            for (int i = 0; i < n; i++) {
                System.out.println(a[i] + " ");
            }
            return;
        }
        for (int i = k; i < a.length; i++) {
            if (needSwap(k, i)) {
                swap(i, k);
                select_combination(k + 1, n);
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
