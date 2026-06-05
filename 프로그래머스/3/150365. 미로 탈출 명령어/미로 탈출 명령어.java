import java.util.*;

class Solution {
    private int[] dx = new int[]{1, 0, 0, -1};
    private int[] dy = new int[]{0, -1, 1, 0};
    private String[] plus = new String[]{"d", "l", "r", "u"};
    private String answer = "";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        dfs(n, m, x-1, y-1, r-1, c-1, k, "");

        if(answer.equals("")) return "impossible";
        return answer;
    }
    
    
    private void dfs(int n, int m, int x, int y, int r, int c, int k, String str){
        if(!answer.equals("")) return;
        
        if(str.length() == k){
            if(x == r && y == c){
                answer = str;
                return;
            }
            return;
        }
        
        int intX = x;
        int intY = y;
        int len = str.length();
            
        int diffX = Math.abs(intX - r);
        int diffY = Math.abs(intY - c);
        int diff = diffX + diffY;
        
        if(diff+len > k) return;
        if(((k-len) - diff) % 2 == 1) return;
        for(int i = 0; i < 4; i++){
            int xx = intX + dx[i];
            int yy = intY + dy[i];
                
            String moveX = String.valueOf(xx);
            String moveY = String.valueOf(yy);
                
            if(xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
            
            dfs(n, m, xx, yy, r, c, k, str+plus[i]);
            }
        }
    
}