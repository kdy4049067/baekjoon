import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[]args)throws IOException {
        int []array = new int[6];
        int MaxWidthI = 0, MaxWidth = 0, MaxHeight = 0, MaxHeightI = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            array[i] = Integer.parseInt(st.nextToken());

            if ((direction == 1 || direction == 2) && MaxWidth < array[i]) {
                MaxWidth = array[i];
                MaxWidthI = i;
            } else if ((direction == 3 || direction == 4) && MaxHeight < array[i]) {
                MaxHeight = array[i];
                MaxHeightI = i;
            }
        }
            int right, left, minWidth, minHeight;

            if(MaxWidthI + 1 == 6) right = 0;
            else right = MaxWidthI + 1;

            if(MaxWidthI - 1 == -1) left = 5;
            else left = MaxWidthI -1;

            minHeight = Math.abs(array[right] - array[left]);

            if(MaxHeightI + 1 == 6) right = 0;
            else right = MaxHeightI + 1;

            if(MaxHeightI - 1 == -1) left = 5;
            else left = MaxHeightI - 1;

            minWidth = Math.abs(array[right] - array[left]);
        System.out.println(((MaxHeight*MaxWidth) - (minHeight*minWidth)) * k);
        }
    }
