package template.math;

public class 快速幂 {
    public static long pow(int a, int b) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= a;
            }
            b >>= 1;
            a *= a;
        }
        return res;
    }
}
