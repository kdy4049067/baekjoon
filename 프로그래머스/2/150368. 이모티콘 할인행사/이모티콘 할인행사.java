import java.util.*;

class Solution {
    public static int[] sales = {10, 20, 30, 40};  
    public static int[] num;                       
    public static PriorityQueue<int[]> pq;       
    public int[] solution(int[][] users, int[] emoticons) {

        num = new int[emoticons.length];
        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });

        perm(0, users, emoticons);

        return pq.poll();
    }

    public void perm(int r, int[][] users, int[] emoticons) {

        if(r == num.length) {
            int service = 0;   
            int money = 0;   

            for(int i = 0; i < users.length; i ++) {
                int sum = 0;
                for(int e = 0; e < emoticons.length; e ++) {
                    if(num[e] >= users[i][0]) {
                        sum += emoticons[e] * (100 - num[e]) / 100; 
                    }
                }
                if(sum >= users[i][1]) service ++;
                else money += sum;               
            }
            pq.offer(new int[] {service, money});
            return;
        }

        for(int i = 0; i < sales.length; i++) {
            num[r] = sales[i];
            perm(r + 1, users, emoticons);
        }

    }
}