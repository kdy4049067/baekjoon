import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<ArrayList<int[]>> list;
    private static int result[];

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList<>();
        result = new int[size+1];

        for(int i = 0; i <= size; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            list.get(from).add(new int[]{to, val});
        }

        for(int i = 1; i <= size; i++){
            solve(i);
            for(int j = 1; j <= size; j++){
                if(result[j] == Integer.MAX_VALUE){
                    System.out.print(0 + " ");
                }
                else
                    System.out.print(result[j] + " ");
            }
            if(i == size) break;
            System.out.println();
        }
    }

    private static void solve(int index){
        Arrays.fill(result, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((int[] o1, int[] o2)->{
            return o1[1] - o2[1];
        });
        q.add(new int[]{index, 0});
        result[index] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for(int[] next : list.get(cur[0])){
                int to = next[0];
                int val = next[1];

                if(result[to] < cur[1]){
                    continue;
                }

                if(result[to] > result[cur[0]] + val){
                    result[to] = result[cur[0]] + val;
                    q.add(new int[]{next[0], result[to]});
                }
            }
        }
    }

}
