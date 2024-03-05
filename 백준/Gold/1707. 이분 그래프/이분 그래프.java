import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int v = 0;
    static int[] visit;
    static ArrayList<Integer>[] al;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < c; i++){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            visit = new int[v+1];
            al = new ArrayList[v+1];
            for(int j = 0; j < v+1; j++){
                al[j] = new ArrayList<Integer>();
            }
            for(int j = 0; j < e; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                al[start].add(end);
                al[end].add(start);

            }
            group();
        }
    }

    public static void group(){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < v+1; i++){
            if(visit[i] == 0){
                q.add(i);
                visit[i] = 1;
            }
            while(!q.isEmpty()){
                int now = q.poll();
                for(int j = 0; j < al[now].size(); j++) {
                    if (visit[al[now].get(j)] == 0)
                        q.add(al[now].get(j));
                    if (visit[now] == visit[al[now].get(j)]){
                        System.out.println("NO");
                        return;
                    }
                    if(visit[now] == 1 && visit[al[now].get(j)] == 0)
                        visit[al[now].get(j)] = 2;
                    else if(visit[now] == 2 && visit[al[now].get(j)] == 0)
                        visit[al[now].get(j)] = 1;
                }
            }
        }
        System.out.println("YES");
    }
}
