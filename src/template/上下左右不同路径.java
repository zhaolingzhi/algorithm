package template;

public class 上下左右不同路径 {

    int[] direction = new int[]{-1, 0, 1, 0, -1};
    public int uniquePathsIII(int[][] grid) {
        int zeroCnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0 || grid[i][j] == 1){
                    zeroCnt ++;
                }
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return backtrack(grid, i, j, zeroCnt);
                }
            }
        }
        return 0;
    }

    public int backtrack(int[][] grid, int i, int j, int zeroCnt){
        if(grid[i][j] == 2){
            if(zeroCnt == 0){
                return 1;
            }else{
                // return 1; 不限制每个点都要走
                return 0;
            }
        }
        int cnt = 0;
        grid[i][j] = -1;
        for(int d = 0; d < direction.length - 1; d++){
            int ni = i + direction[d];
            int nj = j + direction[d + 1];
            if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && (grid[ni][nj] == 0 || grid[ni][nj] == 2)){
                cnt += backtrack(grid, ni, nj, zeroCnt - 1);
            }

        }
        grid[i][j] = 0;
        return cnt;
    }
}
