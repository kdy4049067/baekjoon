import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        int maxDigit = 0;
        List<String> hints = new ArrayList<>();
        List<String> targets = new ArrayList<>();

        for (String exp : expressions) {
            String[] parts = exp.split(" ");
            for (int i = 0; i <= 4; i += 2) {
                if (parts[i].equals("X")) continue;
                for (char c : parts[i].toCharArray()) {
                    maxDigit = Math.max(maxDigit, c - '0');
                }
            }
            if (parts[4].equals("X")) targets.add(exp);
            else hints.add(exp);
        }

        List<Integer> possibleBases = new ArrayList<>();
        for (int base = maxDigit + 1; base <= 9; base++) {
            boolean isValid = true;
            for (String hint : hints) {
                String[] s = hint.split(" ");
                int n1 = Integer.parseInt(s[0], base);
                int n2 = Integer.parseInt(s[2], base);
                int res = Integer.parseInt(s[4], base);
                
                if (s[1].equals("+")) {
                    if (n1 + n2 != res) isValid = false;
                } else {
                    if (n1 - n2 != res) isValid = false;
                }
                if (!isValid) break;
            }
            if (isValid) possibleBases.add(base);
        }

        String[] answer = new String[targets.size()];
        for (int i = 0; i < targets.size(); i++) {
            String[] s = targets.get(i).split(" ");
            Set<String> resultSet = new HashSet<>();

            for (int base : possibleBases) {
                int n1 = Integer.parseInt(s[0], base);
                int n2 = Integer.parseInt(s[2], base);
                int res = s[1].equals("+") ? n1 + n2 : n1 - n2;

                resultSet.add(Integer.toString(res, base));
            }

            if (resultSet.size() > 1) {
                answer[i] = s[0] + " " + s[1] + " " + s[2] + " = ?";
            } else {
                answer[i] = s[0] + " " + s[1] + " " + s[2] + " = " + resultSet.iterator().next();
            }
        }

        return answer;
    }
}