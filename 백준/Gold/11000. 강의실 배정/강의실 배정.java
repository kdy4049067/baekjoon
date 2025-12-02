import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }

        list.sort((int[] o1, int[] o2) ->{
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(list.get(0)[1]);

        for(int i = 1; i < n; i++){
            if(pq.peek() <= list.get(i)[0]){
                pq.poll();
            }

            pq.add(list.get(i)[1]);
        }

        System.out.println(pq.size());
    }

}
