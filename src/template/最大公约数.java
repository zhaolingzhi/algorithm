package template;

public class 最大公约数 {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    //（快速GCD）
    public static int qGCD(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if ((a & 1) == 0 && (b & 1) == 0) {
            return qGCD(a >> 1, b >> 1) << 1;
        } else if ((b & 1) == 0) {
            return qGCD(a, b >> 1);
        } else if ((a & 1) == 0) {
            return qGCD(a >> 1, b);
        } else {
            return qGCD(Math.abs(a - b), Math.min(a, b));
        }
    }

    public static long extGCD(long a, long b, long x, long y) {
        if(b == 0) {
            x = 1;
            y = 0;
            return a;
        }else {
            long d = extGCD(b, a % b, y, x);
            long temp = y;
            y = x - (a / b) * y;
            x = temp;
            return d;
        }
    }
}
