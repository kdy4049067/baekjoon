import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static int n;
    private static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if(widthLine(i)) result++;
            if(heightLine(i)) result++;
        }

        System.out.println(result);
    }

    private static boolean widthLine(int index){
        boolean[] check = new boolean[n];

        for(int i = 0; i < n-1; i++){
            int diff = map[index][i] - map[index][i+1];

            if(diff > 1 || diff < -1) return false;
            else if(diff == 1){
                for(int j = 1; j <= l; j++){
                    if(i + j >= n || check[i+j]) return false;
                    if(map[index][i] -1 != map[index][i+j]) return false;
                    check[i+j] = true;
                }
            }
            else if(diff == -1){
                for(int j = 0; j < l; j++){
                    if(i-j < 0 || check[i-j]) return false;
                    if(map[index][i] != map[index][i-j]) return false;
                    check[i-j] = true;
                }
            }
        }

        return true;
    }

    private static boolean heightLine(int index){
        boolean[] check = new boolean[n];

        for(int i = 0; i < n-1; i++){
            int diff = map[i][index] - map[i+1][index];

            if(diff > 1 || diff < -1) return false;
            else if(diff == 1){
                for(int j = 1; j <= l; j++){
                    if(i + j >= n || check[i+j]) return false;
                    if(map[i][index] -1 != map[i+j][index]) return false;
                    check[i+j] = true;
                }
            }
            else if(diff == -1){
                for(int j = 0; j < l; j++){
                    if(i-j < 0 || check[i-j]) return false;
                    if(map[i][index] != map[i-j][index]) return false;
                    check[i-j] = true;
                }
            }
        }

        return true;
        }
    }
