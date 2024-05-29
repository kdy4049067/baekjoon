import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int count = 0;
        int num = s.nextInt();

        int []array = new int[8];

        int n = num / 2;

        int sum = 0;
        for(int i = n; i <= num - count; i++) {
            String str = String.valueOf(i);
            int result = i;
            while(result > 0){
                result /= 10;
                count++;
            }
            for (int j = 0; j < count; j++) {
                array[j] = str.charAt(j) - '0';
                sum += array[j];
            }
            if(num == sum + i){
                System.out.println(i);
                return;
            }
            sum = 0;
            count = 0;
        }
        System.out.println(0);

    }
}
