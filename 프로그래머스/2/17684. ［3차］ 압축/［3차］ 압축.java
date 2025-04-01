import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int next = 27;

        for(int i = 0; i < 26; i++){
            map.put((char)('A'+i) + "", i+1);
        }

        for(int i = 0; i < msg.length(); i++){
            int index = i+1;
            while(index <= msg.length()){
                String sub = msg.substring(i, index);
                if(map.containsKey(sub)){
                    if(index == msg.length()){
                        list.add(map.get(sub));
                        i = index;
                        break;
                    }
                    index++;
                }
                else{
                    list.add(map.get(msg.substring(i, index-1)));
                    map.put(sub, next);
                    next++;
                    i = index-2;
                    break;
                }
            }
        }

        int[] answer = list.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }
}
