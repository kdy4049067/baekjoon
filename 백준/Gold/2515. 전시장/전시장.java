import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[][] draw = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int height = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            draw[i][0] = height;
            draw[i][1] = price;
        }

        Arrays.sort(draw, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0] - o2[0];
                else return o2[1] - o1[1];
            }
        });

        int max = draw[n-1][0];

        int[] result = new int[max+1];
        int index = 0;
        int prev = 0;
        
        for(int i = s; i <= max; i++){
            while(draw[index][0] == prev){
                if(index < n-1)
                    index++;
            }
            
            if(i == draw[index][0]){
                int val = draw[index][1];
                result[i] = Math.max(result[i-1], result[i-s] + val);
                prev = i;
                if(index < n-1)
                    index++;
            }
            else{
                result[i] = Math.max(result[i-1], result[i-s]);
            }
        }

        System.out.println(result[max]);
    }

}
