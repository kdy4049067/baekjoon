import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String[] channel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        channel = new String[n];

        for (int i = 0; i < n; i++) {
            channel[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        
        int index = 0;
        
        while(!channel[index].equals("KBS1")){
            index++;
            sb.append("1");
        }
        
        while(index > 0){
            swap(index, index-1);
            index--;
            sb.append("4");
        }
        
        while(!channel[index].equals("KBS2")){
            index++;
            sb.append("1");
        }
        
        while(index > 1){
            index--;
            sb.append("4");
        }

        System.out.println(sb.toString());
    }
    
    private static void swap(int a, int b){
        String temp = channel[a];
        
        channel[a] = channel[b];
        channel[b] = temp;
    }

}
