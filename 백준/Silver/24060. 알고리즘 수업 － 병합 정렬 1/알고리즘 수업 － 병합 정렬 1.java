import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] a;
    static int[] sorted;
    static boolean check = false;
    static int count = 0;
    static int ind;

    public static void main(String [] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        ind =  Integer.parseInt(st.nextToken());

        a = new int[size];
        sorted = new int[size];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }


        merge_sort(a,0,size-1);
        if(count < ind) System.out.println(-1);
    }

    public static void merge_sort(int[] a, int left, int right){
        if(left == right) return;

        int mid = (left + right) / 2;
        merge_sort(a, left, mid);
        merge_sort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    public static void merge(int[] a, int left, int mid, int right){
        int l = left;
        int r = mid + 1;
        int index = left;

        while(l <= mid && r <= right) {

            if (a[l] >= a[r]) {
                sorted[index++] = a[r];
                count++;
                if(ind == count) System.out.println(a[r]);
                r++;
            } else {
                sorted[index++] = a[l];
                count++;
                if(ind == count) System.out.println(a[l]);
                l++;
            }
        }
            if(l > mid)
                while(r <= right){
                    sorted[index++] = a[r];
                    count++;
                    if(ind == count) System.out.println(a[r]);
                    r++;
                }

            else if(r > right){
                while(l <= mid){
                    sorted[index++] = a[l];
                    count++;
                    if(ind == count) System.out.println(a[l]);
                    l++;
                }
            }

            for(int i = left; i <= right; i++){
                a[i] = sorted[i];
            }

    }
}
