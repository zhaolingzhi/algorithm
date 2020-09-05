package template.backtrack;

public class 全排列 {
    //全排列(0 ~ 9)
    static int[] a = new int[10];
    static boolean[] vis = new boolean[10];

    public static void dfs(int step) {
        if (step == 10) {
            for (int i = 0; i < 10; i++) {
                System.out.println(a[i] + " ");
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!vis[i]) {
                vis[i] = true;
                a[step] = i;
                dfs(step + 1);
                vis[i] = false;
            }
        }
    }
}
