package template.binary;

public class 二分_最小值最大 {
    static int[] a = {2, 4, 6, 8, 10, 12, 14};

    public static void main(String[] args) {
        System.out.println(a[bsearch_maxMin(10)]);
    }

    private static int bsearch_maxMin(int x) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (x < a[mid]) {  // 不包含自身
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;//返回10
    }
}
