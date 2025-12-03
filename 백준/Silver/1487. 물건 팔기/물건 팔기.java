import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        list.sort((int[] o1, int[] o2) ->{
            return o1[0] - o2[0];
        });

        int result = 0;
        int answer = 0;

        for(int i = 0; i < list.size(); i++){
            int tmp = 0;
            int price = list.get(i)[0];

            tmp += price - list.get(i)[1];
            for(int j = i+1; j < list.size(); j++){
                int nextFee = list.get(j)[1];

                if(nextFee >= price) continue;
                tmp += price - nextFee;
            }

            if(tmp > result){
                result = tmp;
                answer = price;
            }
        }

        if(result == 0){
            System.out.println(0);
            return;
        }

        System.out.println(answer);
    }

}
