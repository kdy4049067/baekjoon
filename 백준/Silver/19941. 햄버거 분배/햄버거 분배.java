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
        boolean[] visit = new boolean[n];
        int result = 0;

        char[] line = new char[n];
        line = br.readLine().toCharArray();

        for(int i = 0; i < n; i++){
            if(line[i] == 'P'){
                for(int j = i - k; j <= i + k; j++){
                    if(j < 0 || j >= n) continue;
                    if(line[j] == 'H' && !visit[j]){
                        visit[j] = true;
                        result++;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }

}
