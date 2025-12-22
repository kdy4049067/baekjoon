import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr1;
    private static int[] arr2;
    private static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        arr2 = new int[n];
        int INF = 987654321;
        int[] result = new int[n];

        String start = br.readLine();
        String end = br.readLine();

        int check1 = 0;
        int check2 = 0;

        for(int i = 0; i < n; i++){
            arr1[i] = start.charAt(i) - '0';
            arr2[i] = start.charAt(i) - '0';
            result[i] = end.charAt(i) - '0';
        }

        swap(arr2, 0);
        check2++;

        for(int i = 1; i < n; i++){
            if(arr1[i-1] != result[i-1]){
                swap(arr1, i);
                check1++;
            }
            if(arr2[i-1] != result[i-1]){
                swap(arr2, i);
                check2++;
            }
        }

        if(arr1[n-1] != result[n-1]) check1 = INF;
        if(arr2[n-1] != result[n-1]) check2 = INF;

        if(check1 == INF && check2 == INF)
            System.out.println(-1);
        else
            System.out.println(Math.min(check1, check2));

    }

    private static void swap(int[] arr, int i){
        if(i > 0){
            if(arr[i-1] == 1) arr[i-1] = 0;
            else arr[i-1] = 1;
        }

        if(arr[i] == 1) arr[i] = 0;
        else arr[i] = 1;

        if(i == n-1) return;

        if(arr[i+1] == 1) arr[i+1] = 0;
        else arr[i+1] = 1;

        return;
    }

}
