import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        int count[] = new int[n+1];
        int time[] = new int[n+1];
        for (int i = 0; i <= n; i++) {
            a.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                }
                count[i]++;
                a.get(num).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int [] result = new int[n+1];

        for(int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                q.add(i);
                result[i] = time[i];
            }
        }
        while(!q.isEmpty()){
                int idx = q.poll();
                for(int qq : a.get(idx)){
                    result[qq] = Math.max(result[qq], result[idx] + time[qq]);
                    if(--count[qq] == 0)
                        q.add(qq);

                }
            }
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }

    }

}