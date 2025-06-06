import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] max = new int[3];
        int[] min = new int[3];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            if(i == 0){
               max[0] = min[0] = first;
               max[1] = min[1] = second;
               max[2] = min[2] = third;
            }
            else{
                int beforeMax0 = max[0];
                int beforeMax2 = max[2];
                max[0] = Math.max(max[0], max[1]) + first;
                max[2] = Math.max(max[1], max[2]) + third;
                max[1] = Math.max(Math.max(beforeMax0, max[1]), beforeMax2) + second;

                int beforeMin0 = min[0];
                int beforeMin2 = min[2];
                min[0] = Math.min(min[0], min[1]) + first;
                min[2] = Math.min(min[1], min[2]) + third;
                min[1] = Math.min(Math.min(beforeMin0, min[1]), beforeMin2) + second;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(Math.max(max[0], max[1]), max[2])).append(" ");
        sb.append(Math.min(Math.min(min[0], min[1]), min[2])).append("\n");

        System.out.println(sb.toString());

    }

}
