import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;
    static int len = 0;
    static int []array;
    static int count;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        len = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());
        array = new int[len];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < len; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        quick_sort(array,0,len-1);
        if(result < count)
            System.out.println(-1);

    }

    private static int partition(int [] array, int start, int end){
        int p = start - 1;
        int criteria = array[end];
        for(int i = start; i < end; i++){
            if(array[i] <= criteria) {
                int temp = array[++p];
                array[p] = array[i];
                array[i] = temp;
                result++;
                if (result == count) {
                    if (array[p] > array[i])
                        System.out.printf("%d %d", array[i], array[p]);

                    if (array[p] <= array[i])
                        System.out.printf("%d %d", array[p], array[i]);
                }
            }
        }
        if(p + 1 != end) {
            int temp = array[p+1];
            array[p+1] = array[end];
            array[end] = temp;

            result++;
            if (result == count) {
                if (array[p+1] <= array[end])
                    System.out.printf("%d %d", array[p+1], array[end]);

                if (array[p+1] > array[end-1])
                    System.out.printf("%d %d", array[end-1], array[p]);
            }
        }
        return p + 1;
    }

    private static void quick_sort(int [] array, int start, int end){
        if(start < end){
            int q = partition(array, start, end);
            quick_sort(array, start, q-1);
            quick_sort(array, q+1, end);
        }
    }
}