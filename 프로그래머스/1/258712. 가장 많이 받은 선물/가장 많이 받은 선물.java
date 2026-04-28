import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int[][] giftInfo = new int[friends.length][friends.length];
        int[] giftIndex = new int[friends.length];
        int[] expectedGift = new int[friends.length];
        
        for(int i = 0; i < gifts.length; i++){
            String[] info = gifts[i].split(" ");
            String giver = info[0];
            String receiver = info[1];
            
            int giverIndex = 0;
            int receiverIndex = 0;
            
            for(int j = 0; j < friends.length; j++){
                if(giver.equals(friends[j])) giverIndex = j;
                if(receiver.equals(friends[j])) receiverIndex = j;
            }
            
            giftInfo[giverIndex][receiverIndex]++;
        }
        
        for(int i = 0; i < giftInfo.length; i++){
            for(int j = 0; j < giftInfo.length; j++){
                if(giftInfo[i][j] > 0){
                    giftIndex[i] += giftInfo[i][j];
                    giftIndex[j] -= giftInfo[i][j];
                }
            }
        }
        
        for(int i = 0; i < giftInfo.length-1; i++){
            for(int j = i+1; j < giftInfo.length; j++){
                if(giftInfo[i][j] == giftInfo[j][i]){
                    if(giftIndex[i] > giftIndex[j]) expectedGift[i]++;
                    else if(giftIndex[i] < giftIndex[j]) expectedGift[j]++;
                }
                else if(giftInfo[i][j] > giftInfo[j][i]) expectedGift[i]++;
                else expectedGift[j]++;
            }
        }
        
        for(int i = 0; i < expectedGift.length; i++){
            answer = Math.max(answer, expectedGift[i]);
        }
        
        return answer;
    }
}
