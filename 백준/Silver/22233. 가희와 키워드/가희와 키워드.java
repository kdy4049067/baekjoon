import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int keyword = Integer.parseInt(st.nextToken());
        int use = Integer.parseInt(st.nextToken());

        Set<String> keySet = new HashSet<>();

        for(int i = 0; i < keyword; i++){
            keySet.add(br.readLine());
        }

        for(int i = 0; i < use; i++){
            String useKeyword = br.readLine();
            String[] keywords = useKeyword.split(",");

            for(int j = 0; j < keywords.length; j++){
                keySet.remove(keywords[j]);
            }

            System.out.println(keySet.size());
        }
    }

}
