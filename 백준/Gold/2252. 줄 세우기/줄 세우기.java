import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        int [] count = new int[n+1];
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            graph.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
            count[Integer.parseInt(str[1])]++;
        }
        for(int i = 1; i <=n; i++){
            if(count[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int result = q.poll();
            sb.append(result).append(" ");
            for(int i = 0; i < graph.get(result).size(); i++){
                int minus = graph.get(result).get(i);
                count[minus]--;
                if(count[minus] == 0) q.add(minus);
            }
        }
        System.out.println(sb);
    }
}
