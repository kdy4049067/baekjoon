import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int friendsLength = friends.length;
        HashMap<String, Integer> giftMap = new HashMap<>();
        for(int i = 0; i < friendsLength; i++){
            giftMap.put(friends[i], i );
        }
        
        int [][] giftRelation = new int[friendsLength][friendsLength];
        int [] giftIndex = new int[friendsLength];
        
        for(int i = 0; i < gifts.length; i++){
            String[] splitGifts = gifts[i].split(" "); 
            String sender = splitGifts[0];
            String receiver = splitGifts[1];
            int senderIndex = giftMap.get(sender);
            int receiverIndex = giftMap.get(receiver);
            giftIndex[senderIndex]++;
            giftIndex[receiverIndex]--;
            giftRelation[senderIndex][receiverIndex]++;
        }
        
        for(int i = 0; i < friendsLength; i++){
            int count = 0;
            for(int j = 0; j < friendsLength; j++){
                if(i == j) continue;
                
                if(giftRelation[i][j] > giftRelation[j][i]){
                    count++;
                    continue;
                }
                else if(giftRelation[i][j] == giftRelation[j][i]){
                    if(giftIndex[i] > giftIndex[j]) count++;
                }
            }
            if(answer < count){
                answer = count;
            }
        }
        return answer;
    }
}