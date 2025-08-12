import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] words = new String[n];
        Map<String, Integer> wordMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            words[i] = br.readLine();
            if(wordMap.containsKey(words[i])){
                int count = wordMap.get(words[i]);
                wordMap.put(words[i], count+1);
                continue;
            }
            wordMap.put(words[i], 1);
        }

        List<String> key = new ArrayList<>(wordMap.keySet());

        Collections.sort(key, (o1, o2) -> {
            if(wordMap.get(o2) - wordMap.get(o1) != 0){
                return wordMap.get(o2) - wordMap.get(o1);
            }

            else if(wordMap.get(o2).equals(wordMap.get(o1)) && o1.length() != o2.length()){
                return o2.length() - o1.length();
            }

            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        
        for(String word : key){
            if(word.length() < m) continue;
            sb.append(word + "\n");
        }

        System.out.println(sb);

    }

}
