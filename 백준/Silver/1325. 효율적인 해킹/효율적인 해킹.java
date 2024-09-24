import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> computer_relation = new ArrayList<>();
    static int count[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int computer = Integer.parseInt(st.nextToken());
        int relation = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= computer; i++){
            computer_relation.add(new ArrayList<>());
        }

        for(int i = 0; i < relation; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            computer_relation.get(start).add(end);
        }

        visited = new boolean[computer+1];
        count = new int[computer+1];

        for(int i = 1; i <= computer; i++){
            visited = new boolean[computer+1];
            bfs(i);
        }

        int max = 0;
        for(int i = 1; i <= computer; i++){
            if(max < count[i]) max = count[i];
        }

        for(int i = 1; i <= computer; i++){
            if(max == count[i]) System.out.print(i + " ");
        }


    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int p = q.poll();
            for(int i : computer_relation.get(p)){
                if(!visited[i]){
                    count[i]++;
                    visited[i] = true;
                    q.add(i);
                }
            }

        }
    }

}