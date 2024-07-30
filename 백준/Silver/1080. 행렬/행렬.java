import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;

        int[][] a = new int[n][m];
        int[][] b = new int[n][m];

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m ; j++){
                a[i][j] = line.charAt(j) - '0';
            }
        }
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m ; j++){
                b[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != b[i][j] && i + 2 < n && j + 2 < m){
                    for(int k = i; k < i + 3; k++){
                        for(int c = j; c < j + 3; c++){
                            a[k][c] = a[k][c] == 0 ? 1:0;
                        }
                    }
                    count++;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != b[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }
}
