import java.io.*;
import java.util.*;

class Solution {

    static ArrayList<Edge> [] lists;
    public int[] solution(int[][] edges) {

        int [] answer = new int[4];
        lists = new ArrayList [findMaxVertex(edges)+1];
        for(int i = 0; i < edges.length; i++){
            int start   = edges[i][0];
            int end     = edges[i][1];

            if(lists[start] == null) {lists[start] = new ArrayList<>();}
            lists[start].add(new Edge(end, true));
            if(lists[end] == null) {lists[end] = new ArrayList<>();}
            lists[end].add(new Edge(start, false));
        }

        for(int i = 1; i < lists.length; i++){
            if(lists[i] == null) continue;
            int out = 0; int in = 0; 
            for(int j = 0; j < lists[i].size(); j++){
                Edge next = lists[i].get(j);
                if(next.isAdvance) out++;
                else in++;
            }
            if(in == 0 && out >=2) {
                answer[0] = i;
                break;
            }
        }
        answer[1] = lists[answer[0]].size();
        for(int i = 0; i < lists[answer[0]].size(); i++){
            Edge next = lists[answer[0]].get(i);
            for(int j = 0; j < lists[next.dest].size(); j++){
                if(lists[next.dest].get(j).dest == answer[0]) {
                    lists[next.dest].remove(lists[next.dest].get(j));
                    break;
                }
            }
        }
        lists[answer[0]].clear();
        for(int i = 1; i < lists.length; i++){
            if(i == answer[0] || lists[i] == null) continue;

            int in = 0; int out = 0;
            for(int j = 0; j < lists[i].size(); j++){
                Edge next = lists[i].get(j);
                if(next.isAdvance) out++;
                else in++;
            }
            if( out == 0) answer[2]++;
            if(in == 2 && out == 2) answer[3]++;
        }

        answer[1] -= (answer[2]+answer[3]);

        return answer;
    }

    public int findMaxVertex (int [][] edges){
        int ans = 0;
        for(int i = 0; i < edges.length; i++){
            ans = Math.max(ans, edges[i][0]);
            ans = Math.max(ans, edges[i][1]);
        }

        return ans;
    }
}

class Edge {
    int dest;
    boolean isAdvance;

    public Edge(int dest, boolean isAdvance){
        this.dest = dest;
        this.isAdvance = isAdvance;
    }
}