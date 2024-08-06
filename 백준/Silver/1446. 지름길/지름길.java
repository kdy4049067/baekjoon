import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<ArrayList<Node>> arr;
    public static int[] dp;
    public static int d;
    public static void main(String[]args) throws IOException{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        d = s.nextInt();
        dp = new int[10001];

        arr = new ArrayList<>();
        for(int i = 0; i <= 10001; i++){
            arr.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            int start = s.nextInt();
            int end = s.nextInt();
            int val = s.nextInt();
            arr.get(start).add(new Node(end,val));
        }

        for(int i = 0; i <= d; i++){
            dp[i] = i;
        }

        dijkstra(0);

        System.out.println(dp[d]);
    }

    public static void dijkstra(int start){
        if(start > d) return;
        if(dp[start+1] > dp[start] + 1)
            dp[start+1] = dp[start] + 1;
        for(int i = 0; i < arr.get(start).size(); i++){
            if(dp[start] + arr.get(start).get(i).val < dp[arr.get(start).get(i).end])
                dp[arr.get(start).get(i).end] = dp[start] + arr.get(start).get(i).val;
        }
        dijkstra(start+1);
    }
    public static class Node{
        int end;
        int val;
        public Node(int end, int val){
            this.end = end;
            this.val = val;
        }
    }
}
