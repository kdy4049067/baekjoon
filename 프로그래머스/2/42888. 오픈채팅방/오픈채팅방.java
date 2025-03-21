import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();

        for(String str : record){
            String[] user = str.split(" ");
            String status = user[0];
            String id = user[1];
            if(status.equals("Enter") || status.equals("Change")){
                String name = user[2];
                map.put(id, name);
            }
        }

        for(int i = 0; i < record.length; i++){
            String[] user = record[i].split(" ");
            String status = user[0];
            String id = user[1];

            if(status.equals("Enter")){
                String name = map.get(id);
                answer.add(name + "님이 들어왔습니다.");
            }

            if(status.equals("Leave")){
                String name = map.get(id);
                answer.add(name + "님이 나갔습니다.");
            }
        }

        String[] ans = new String[answer.size()];
        answer.toArray(ans);

        return ans;
    }
}
