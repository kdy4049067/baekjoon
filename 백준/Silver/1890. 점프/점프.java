import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static long[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board = new int[n][n];
        dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                board[i][j] = val;
            }
        }
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = board[i][j];
                int moveX = value + i;
                int moveY = value + j;

                if (value == 0) continue;

                if (moveX < n) {
                    dp[moveX][j] += dp[i][j];
                }

                if (moveY < n) {
                    dp[i][moveY] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }

}
