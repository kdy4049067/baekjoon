import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[n];

        for(int i = 0; i < n; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < k; i++){
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
        }

        if(map.containsKey(c)) max = Math.max(max, map.size());
        else max = Math.max(max, map.size()+1);

        for(int i = k; i < n; i++){
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);

            if(map.get(sushi[i-k]) == 1) map.remove(sushi[i-k]);
            else map.put(sushi[i-k], map.get(sushi[i-k]) - 1);

            if(map.containsKey(c)) max = Math.max(max, map.size());
            else max = Math.max(max, map.size()+1);
        }

        for(int i = 0; i < k -1; i++){
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);

            int index = i-k+n;
            if(map.get(sushi[index]) == 1) map.remove(sushi[index]);
            else map.put(sushi[index], map.get(sushi[index]) - 1);

            if(map.containsKey(c)) max = Math.max(max, map.size());
            else max = Math.max(max, map.size()+1);
        }

        System.out.println(max);
    }

}
