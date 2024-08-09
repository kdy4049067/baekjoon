import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> q = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            q.add(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < m; i++){
            long first = q.poll();
            long second = q.poll();
            long add = first + second;
            q.add(add);
            q.add(add);
        }

        long result = 0;
        while(!q.isEmpty()){
            result += q.poll();
        }

        System.out.println(result);
    }
}
