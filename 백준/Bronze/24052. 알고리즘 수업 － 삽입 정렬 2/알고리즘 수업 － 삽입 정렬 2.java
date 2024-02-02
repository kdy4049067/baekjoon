import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int len;
    static int plus;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        len = Integer.parseInt(st.nextToken());
        int check = Integer.parseInt(st.nextToken());
        int [] array = new int[len];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < len; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        insertion_sort(array, check);
        if(check > plus)
            System.out.println(-1);
        else{
        for(int result : array)
            System.out.print(result + " ");
        }
    }

    static void insertion_sort(int [] array, int check){
        for(int i = 1; i < len; i++){
            int value = array[i];
            int loc = i-1;
            while(loc >= 0 && array[loc] > value){
                array[loc+1] = array[loc];
                loc--;
                plus++;
                if(plus == check)
                    return;
            }
            if(loc + 1 != i){
                array[loc+1] = value;
                plus++;
                if(plus == check)
                    return;
            }
        }
    }
}