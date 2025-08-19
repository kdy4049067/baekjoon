import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;
        int start = 0;
        int end = 0;
        int[] cnt = new int[100001];
        int[] number = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        
        while(end < number.length){
            while(end < number.length && cnt[number[end]] + 1 <= k){
                cnt[number[end]]++;
                end++;
            }
            
            int len = end - start;
            ans = Math.max(ans, len);
            cnt[number[start]]--;
            start++;
        }

        System.out.println(ans);
    }

}
