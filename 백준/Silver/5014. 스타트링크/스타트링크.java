import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int now = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        boolean check[] = new boolean[total+1];

        Queue<Integer> q = new LinkedList<>();
        q.add(now);
        int count = 0;
        check[now] = true;

        if(now == target){
            System.out.println(0);
            return;
        }
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++){
                int stair = q.poll();
                int plus = stair + up;
                int minus = stair - down;

                if(plus == target || minus == target)
                {
                    System.out.println(count+1);
                    return;
                }
                if(plus <= total && !check[plus]) {
                    q.add(plus);
                    check[plus] = true;
                }
                if(minus >= 1 && !check[minus]){
                    q.add(minus);
                    check[minus] = true;
                }

            }
            count++;
        }
        System.out.println("use the stairs");
    }
}
