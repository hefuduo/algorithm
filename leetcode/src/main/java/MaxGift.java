/**
 * PACKAGE_NAME
 * Created by hefuduo on 3/18/20.
 */

/**
 * 礼物最大值问题
 */
public class MaxGift {
    public int maxValue(int[][] grid) {
        int[][] f = new int[grid.length][grid[0].length];
        int i = 0, j = 0;
        for (i = 0; i < f.length; i++) {
            for (j = 0; j < f.length; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = grid[i][j];
                } else if (i == 0) {
                    f[i][j] = f[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    f[i][j] = f[i - 1][j] + grid[i - 1][j];
                } else {
                    f[i][j] = Math.max(f[1][j - 1], f[i - 1][j]) + grid[i - 1][j];
                }
            }
        }
        return f[grid.length - 1][grid[0].length];
    }
}
