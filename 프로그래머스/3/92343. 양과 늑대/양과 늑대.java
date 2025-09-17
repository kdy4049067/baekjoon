import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] childs;
    static int[] Info;
    static int maxSheepCnt = 0;
    
    public int solution(int[] info, int[][] edges) {
        Info = info;
        childs = new ArrayList[info.length];
    
        for(int i = 0; i < edges.length; i++){
            int cur = edges[i][0];
            int next = edges[i][1];
            
            if(childs[cur] == null){
                childs[cur] = new ArrayList<>();
            }
            
            childs[cur].add(next);
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(0);
        
        dfs(0, 0, 0, list);
        
        return maxSheepCnt;
    }
    
    private void dfs(int num, int sheep, int wolf, List<Integer> nexts){
        if(Info[num] == 0) sheep++;
        else wolf++;
        
        if(wolf >= sheep) return;
        maxSheepCnt = Math.max(maxSheepCnt, sheep);
        
        List<Integer> list = new ArrayList<>();
	    list.addAll(nexts);
    	list.remove(Integer.valueOf(num));
                    
        if(childs[num] != null){
            for(int next : childs[num]){
                list.add(next);
            }
        }
                    
        for(int next : list){
            dfs(next, sheep, wolf, list);
        }
    }

}