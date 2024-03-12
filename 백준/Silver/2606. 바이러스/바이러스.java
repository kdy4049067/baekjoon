import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] virus;
    static boolean check[];
    static int size = 0;
    static int result = 0;
    public static void main(String []args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        virus = new int[size+1][size+1];
        check = new boolean[size+1];
        StringTokenizer st;
        for(int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            virus[start][end] = 1;
            virus[end][start] = 1;
        }

        dfs(1);
        System.out.println(result-1);
    }

    public static void dfs(int n){
        check[n] = true;
        result++;
        for(int i = 0; i <= size; i++){
            if(virus[n][i] == 1 && !check[i]){
                dfs(i);
            }
        }
    }

}
