class Solution {
    
    private int[] sale;
    private int[] percent = new int[]{10, 20, 30, 40};
    private int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        sale = new int[emoticons.length];
        dfs(users, emoticons, 0);
        
        return answer;
    }
    
    private void dfs(int[][] users, int[] emoticons, int start){
        if(sale.length == start){
            calculate(users, emoticons);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            sale[start] = percent[i];
            dfs(users, emoticons, start+1);
        }
    }
    
    private void calculate(int[][] users, int[] emoticons){
        int people = 0;
        int totalPrice = 0;
        
        for(int i = 0; i < users.length; i++){
            int[] userInfo = users[i];
            int rate = userInfo[0];
            int price = userInfo[1];
            int sum = 0;
            for(int j = 0; j < emoticons.length; j++){
                int ePrice = emoticons[j];
                int sPrice = sale[j];

                if(rate <= sPrice){
                    sum += ePrice * (100 - sPrice) * 0.01;
                }
                
            }
            
            if(sum >= price){
                people++;
            }
            else{
                totalPrice += sum;
            }
        }
        
        if(answer[0] < people){
            answer[0] = people;
            answer[1] = totalPrice;
        }
        else if(answer[0] == people && answer[1] < totalPrice) answer[1] = totalPrice;
    }
}