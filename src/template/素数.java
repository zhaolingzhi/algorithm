package template;

import java.util.Arrays;

public class 素数 {
   static boolean[] is_prime = new boolean[100000];

    public static void prime(int maxN) {
        Arrays.fill(is_prime, true);
        for(int i = 2; i * i < maxN; i++) {
            if(is_prime[i]) {
                for(int j = i * i; j < maxN; j += i) {
                    is_prime[j] = false;
                }
            }
        }
    }
}
