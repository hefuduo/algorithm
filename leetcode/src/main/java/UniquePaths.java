/**
 * PACKAGE_NAME
 * Created by hefuduo on 3/18/20.
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths2(10, 10));
    }

    /**
     * 动态规划解法
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] table = new int[m][n];
        for (int i = 0; i < n; i++) {
            table[0][i] = 1;
        }
        for (int j = 0; j < m; j++) {
            table[j][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }
        return table[m - 1][n - 1];
    }

    public static int uniquePaths2(int m, int n) {
        int b = m + n - 2;
        int a = m - 1;
//        求 C a/b = b! / {a! * (b-a)!}
        int r1 = 1;
        int r2 = 1;
        int r3 = 1;
        //b!
        for (int i = 1; i <= b; i++) {
            r1 *= i;
        }
        //a!
        for (int j = 1; j <= a; j++) {
            r2 *= j;
        }
        //(b-a)!
        for (int k = 1; k <= (b - a); k++) {
            r3 *= k;
        }

        return r1 / (r2* r3);
    }
}
