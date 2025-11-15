import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] a;
    static int ans = Integer.MAX_VALUE;
    private static int totalPeople;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                totalPeople += a[i][j];
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int d1 = 1; d1 < n; d1++) {
                    for (int d2 = 1; d2 < n; d2++) {
                        if (x + d1 + d2 >= n) continue;
                        if (y - d1 < 0) continue;
                        if (y + d2 >= n) continue;

                        solveFor(x, y, d1, d2);
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static void solveFor(int x, int y, int d1, int d2) {
        boolean[][] region = new boolean[n][n];

        for (int i = 0; i <= d1; i++) {
            region[x + i][y - i] = true;
            region[x + d2 + i][y + d2 - i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            region[x + i][y + i] = true;
            region[x + d1 + i][y - d1 + i] = true;
        }

        int[] sum = new int[5];

        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (region[i][j]) break;
                sum[0] += a[i][j];
            }
        }

        for (int i = 0; i <= x + d2; i++) {
            for (int j = n - 1; j > y; j--) {
                if (region[i][j]) break;
                sum[1] += a[i][j];
            }
        }

        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (region[i][j]) break;
                sum[2] += a[i][j];
            }
        }

        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = n - 1; j >= y - d1 + d2; j--) {
                if (region[i][j]) break;
                sum[3] += a[i][j];
            }
        }

        sum[4] = totalPeople;

        for (int i = 0; i < 4; i++) {
            sum[4] -= sum[i];
        }

        Arrays.sort(sum);

        ans = Math.min(ans, sum[4] - sum[0]);
    }
}
