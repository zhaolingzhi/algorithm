package old;

import java.util.Scanner;

// 给一个数组，数组中每个数可以拆分成多个数的和，现在要把每个数尽可能拆成素数的和，求这个数组最多能拆出几个素数
// 现在有n个数，1~n, 给定一个1~n之间的子序列，求包含该子序列的n个数组成的最小字典序， n为1~n的不重复序列
// 有一组物品，每个有其价值，将这组物品分给两个人，让两个人获得物品价值相等，获得到最大价值后，剩余的抛弃。求为了获取最大价值需要抛弃的剩余价值。
// 给一个有向图，求生成树中最大权边与最小权边的最大值。

public class Main3 {

    public long maxPrime(int[] nums){
        long cnt = 0;
        for (int num : nums){
            if (num == 1) continue;
            if (num % 2 == 0){
                cnt += num / 2;
            }else {
                cnt += (num - 1) / 2;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Main3 main = new Main3();
        int n = cin.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++){
            nums[i] = cin.nextInt();
        }
        System.out.println(main.maxPrime(nums));
    }
}
