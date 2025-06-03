import java.util.*;

class Solution {
    
    static class Task {
        private String name;
        private int start;
        private int playtime;
        
        public Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
        
        public Task(String name, int playtime) {
            this.name = name;
            this.playtime = playtime;
        }
    }
    
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        PriorityQueue<Task> pq = new PriorityQueue<>(
            (o1, o2) -> (o1.start - o2.start)
        );
        
        for(int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            
            String[] str = plans[i][1].split(":");
            int h = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int start = (h * 60) + m;
            
            int time = Integer.parseInt(plans[i][2]);
            
            pq.add(new Task(name, start, time));
        }

        Stack<Task> remainingTasks = new Stack<>();
        
        while(!pq.isEmpty()) {
            Task currentTask = pq.poll();
            
            String curName = currentTask.name;
            int curStart = currentTask.start;
            int curPlaytime = currentTask.playtime;

            int currentTime = curStart;

            if(!pq.isEmpty()) {
                Task nextTask = pq.peek();

                if(currentTime + curPlaytime < nextTask.start) {
                    answer.add(curName);
                    currentTime += curPlaytime;

                    while(!remainingTasks.isEmpty()) {
                        Task rem = remainingTasks.pop();

                        if(currentTime + rem.playtime <= nextTask.start) {
                            currentTime += rem.playtime;
                            answer.add(rem.name);
                            continue;
                        } 
                        else {
                            int t = rem.playtime - (nextTask.start - currentTime);
                            remainingTasks.push(new Task(rem.name, t));
                            break;
                        }
                    }
                }
                else if(curStart + curPlaytime == nextTask.start) {
                    answer.add(curName);
                    continue;
                }
                else {
                    int t = (nextTask.start - currentTime);
                    remainingTasks.push(new Task(curName, curPlaytime - t));
                }
                
            }

            else {
                if(remainingTasks.isEmpty()) {
                    currentTime += curPlaytime;
                    answer.add(curName);
                }
                else {
                    answer.add(curName);

                    while(!remainingTasks.isEmpty()) {
                        Task rem = remainingTasks.pop();
                        answer.add(rem.name);
                    }
                }
            }
        }
        
        return answer;
    }
}