import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int user;
    static int relation;
    static boolean[] check = new boolean[user+1];
    static int graph[][];
    static final int INF = 123456789;

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        user = Integer.parseInt(st.nextToken());
        relation = Integer.parseInt(st.nextToken());

        graph = new int[user+1][user+1];

        for(int i = 1; i <= user; i++){
            for(int j = 1; j <= user; j++){
                graph[i][j] = INF;
                if(i == j)
                    graph[i][j] = 0;
            }
        }

        for(int i = 0; i < relation; i++){
            st = new StringTokenizer(br.readLine());
            int human1 = Integer.parseInt(st.nextToken());
            int human2 = Integer.parseInt(st.nextToken());

            graph[human1][human2] = 1;
            graph[human2][human1] = 1;
        }

        for(int i = 1; i <= user; i++){
            for(int j = 1; j <= user; j++){
                for(int k = 1; k <= user; k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int result = INF;
        int index = 0;

        for(int i = 1; i <= user; i++){
            int sum = 0;
            for(int j = 1; j <= user; j++){
                sum += graph[i][j];
            }
            if(result > sum){
                result = sum;
                index = i;
            }
        }

        System.out.println(index);


    }
}
