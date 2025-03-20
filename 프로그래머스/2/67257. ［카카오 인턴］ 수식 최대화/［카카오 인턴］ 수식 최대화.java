import java.util.ArrayList;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        String[][] operand = {{"+","-","*"}, {"+","*","-"}, {"-","+","*"}, {"-","*","+"},{"*","+","-"},{"*","-","+"}};
        ArrayList<String> list = new ArrayList<>();
        int index = 0;
        
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*'){
                list.add(expression.substring(index, i));
                list.add(expression.charAt(i) + "");
                index = i + 1;
            }
        }
        list.add(expression.substring(index));
        
        for (int i = 0; i < operand.length; i++) {
            ArrayList<String> sub_list = new ArrayList<String>(list);
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < sub_list.size(); j++) {
                    if (operand[i][k].equals(sub_list.get(j))) {
                        sub_list.set(j - 1, calc(sub_list.get(j - 1), sub_list.get(j), sub_list.get(j + 1)));
                        sub_list.remove(j);
                        sub_list.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(sub_list.get(0))));
        }
 
        return answer;
    }
 
    private static String calc(String num1, String op, String num2) {
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);
 
        if (op.equals("+"))
            return n1 + n2 + "";
        else if (op.equals("-"))
            return n1 - n2 + "";
 
        return n1 * n2 + "";
    }

}