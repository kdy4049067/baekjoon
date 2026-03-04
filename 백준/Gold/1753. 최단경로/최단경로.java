import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    private static int[] dist;
    private static int v;
    private static final int m = Integer.MAX_VALUE;
    private static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        dist = new int[v+1];

        pq = new PriorityQueue<>((int[] o1, int[] o2)->{
            return o1[1] - o2[1];
        });

        for(int i = 1; i <= v; i++){
            dist[i] = m;
        }

        dist[start] = 0;

        for(int i = 0; i <= v; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            list.get(s).add(new int[]{f, val});
        }

        pq.add(new int[]{start, 0});

        dik();

        for(int i = 1; i <= v; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }
    }

    private static void dik(){
        while(!pq.isEmpty()){
            int[] curNode = pq.poll();

            if(dist[curNode[0]] < curNode[1]) continue;

            for(int[] nextNode : list.get(curNode[0])){
                if(dist[nextNode[0]] > curNode[1] + nextNode[1]){
                    dist[nextNode[0]] = curNode[1] + nextNode[1];
                    pq.add(new int[]{nextNode[0], curNode[1] + nextNode[1]});
                }
            }
        }
    }

}
