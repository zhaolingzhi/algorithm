package template;

public class 欧拉函数 {
    public static int euler(int n) {
        int res = n;
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                res = res - res / i;
                while(n % i == 0) {
                    n /= i;
                }
            }
        }
        if(n > 1) {
            res = res - res / n;
        }
        return res;
    }
}
