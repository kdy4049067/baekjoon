import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{
    int end;
    int val;
    Node(int end, int val){
        this.end = end;
        this.val = val;
    }
    @Override
    public int compareTo(Node o){
        return val - o.val;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end,val));
        }
        st = new StringTokenizer(br.readLine());
        int startPos =  Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] check = new boolean[n+1];
        q.add(new Node(startPos,0));
        dist[startPos] = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            int e = node.end;
            int v = node.val;
            if(!check[e]){
                check[e] = true;
                for(Node node1 : list.get(e)){
                    if(!check[node1.end] && dist[node1.end] > dist[e] + node1.val){
                        dist[node1.end] = dist[e] + node1.val;
                        q.add(new Node(node1.end, dist[node1.end]));
                    }
                }
            }
        }
        System.out.println(dist[endPos]);

    }
}
