import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[1 + n];
        int[] dp = new int[500001];
        for (int i = 1; i <= n; i++) {
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);
        int sum = 1;
        for(int i = 1; i <= n; i++){
            if(sum < arr[i])
                break;
            sum += arr[i];

        }
        System.out.println(sum);
    }
}
