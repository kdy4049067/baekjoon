import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] degree = new int[n+1];

        ArrayList<ArrayList<int[]>> list = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            list.get(x).add(new int[]{y, k});
            degree[y]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[n+1];

        for(int i = 1; i <= n; i++){
            if(degree[i] == 0) {
                q.add(i);
                result[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int index = q.poll();

            for(int[] info : list.get(index)){
                int pre = info[0];
                int val = info[1];

                result[pre] += result[index] * val;
                degree[pre]--;
                if(degree[pre] == 0){
                    q.add(pre);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            if(list.get(i).isEmpty()){
                System.out.println(i + " " + result[i]);
            }
        }
    }
}
