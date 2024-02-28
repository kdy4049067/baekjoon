import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][]graph;
    static boolean[]check;
    static int s;
    public static void main(String []args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());

        graph = new int[s+1][s+1];
        check = new boolean[s+1];
        for(int i = 1; i <= line; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        int count = 0;
        for(int i = 1; i <= s; i++){
            if(!check[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);

    }

    public static void dfs(int start){
        if(check[start]) return;
        check[start] = true;
        for(int i = 1; i <= s; i++){
            if(graph[start][i] == 1){

                dfs(i);
            }
        }
    }
}
