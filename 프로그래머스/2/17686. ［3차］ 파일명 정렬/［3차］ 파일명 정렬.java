import java.util.*;

class Solution {
    
    private static List<File> fileList = new ArrayList<>();
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        for(int i = 0; i < files.length; i++){
            String file = files[i];
            boolean check = false;
            StringBuilder head = new StringBuilder();
            StringBuilder num = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            
            for(int j = 0; j < file.length(); j++){
                char c = file.charAt(j);
                if('0' <= c && c <= '9'){
                    num.append(c);
                    check = true;
                }
                else{
                    if(!check){
                        head.append(c);
                    }
                    else{
                        tail.append(file.substring(j));
                        break;
                    }
                }
                
            }
            fileList.add(new File(i, head.toString(), num.toString(), tail.toString()));
        }
        
        Collections.sort(fileList);
        for(int i = 0; i < files.length; i++){
            File file1 = fileList.get(i);
            answer[i] = file1.head + file1.num + file1.tail;
        }
        
        return answer;
    }   
    private static class File implements Comparable<File>{
        int index;
        String head;
        String num;
        String tail;
        
        public File(int index, String head, String num, String tail){
            this.index = index;
            this.head = head;
            this.num = num;
            this.tail = tail;
        }
        
        @Override
        public int compareTo(File f){
            if(this.head.equalsIgnoreCase(f.head)){
                if(Integer.parseInt(this.num) == Integer.parseInt(f.num))
                    return this.index - f.index;
                else{
                    return Integer.parseInt(this.num) - Integer.parseInt(f.num);
                }
                    
            }
            return this.head.toLowerCase().compareTo(f.head.toLowerCase());
        }
    }
    
}
