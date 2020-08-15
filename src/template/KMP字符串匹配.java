package template;

public class KMP字符串匹配 {
    //KMP算法（字符串匹配
    public static int[] solve_next(String s) {
        int len = s.length();
        int[] next = new int[len];
        next[0] = -1;
        if (len == 1) {
            return next;
        }
        next[1] = 0;
        int j = 1;
        int k = next[j];
        while (j < len - 1) {
            if (k < 0 || s.charAt(j) == s.charAt(k)) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static int kmp(String s1, String s2) {
        int len_s1 = s1.length();
        int len_s2 = s2.length();
        int next[] = solve_next(s2);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < len_s1) {
            if (j == -1 || s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == len_s2) {
                count++;
                i--;
                j = next[j - 1];
            }
        }
        return count;
    }
}
