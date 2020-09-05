package old;

import java.util.Scanner;

public class Main4 {

    public int[] minDictSort(int m, int n, int[] nums){
        int[] ans = new int[n];

        int[] numsRest = new int[n - m];
        boolean[] record = new boolean[n + 1];
        for (int num : nums) {
            record[num] = true;
        }
        for (int i = 1, j = 0; i < record.length; i++){
            if (!record[i]){
                numsRest[j++] = i;
            }
        }
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < numsRest.length && j < nums.length){
            ans[idx++] = numsRest[i] < nums[j]? numsRest[i++] : nums[j++];
        }
        while (i < numsRest.length){
            ans[idx++] = numsRest[i++];
        }
        while (j < nums.length){
            ans[idx++] = nums[j++];
        }

        return ans;
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Main4 main = new Main4();
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++){
            nums[i] = cin.nextInt();
        }
        int[] ans = main.minDictSort(m, n, nums);
        for (int i = 0; i < ans.length; i++){
            System.out.print(ans[i]);
            if (i < ans.length - 1){
                System.out.print(' ');
            }
        }
        System.out.println();
    }
}
