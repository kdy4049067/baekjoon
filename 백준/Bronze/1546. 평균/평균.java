import java.util.Scanner;

public class Main{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n];
        long sum = 0;
        long max = 0;
        for(int i = 0; i < n; i++){
            array[i] = s.nextInt();
        }

        for(int j = 0; j < n; j++){
            if(array[j] > max)
                max = array[j];
            sum = sum + array[j];
        }
        System.out.println(sum * 100.0 / max / n);

    }
}