import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((Integer o1, Integer o2) ->{
            return o2 - o1;
        });

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
            pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        int result = 0;

        for(int i = 0; i < n; i++){
            result = pq.poll();
        }

        System.out.println(result);
    }

}
