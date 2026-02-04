import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static int n;
    private static int m;
    private static ArrayList<Integer> list = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();

        visited = new boolean[n + 1];
        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                list.add(i);
                dfs(depth + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
