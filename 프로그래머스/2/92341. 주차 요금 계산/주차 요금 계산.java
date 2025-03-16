import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> inMap = new HashMap<>();
        HashMap<String, Integer> outMap = new HashMap<>();
        int baseTime = fees[0];
        int baseFee = fees[1];
        int extraTime = fees[2];
        int extraFee = fees[3];

        for (int i = 0; i < records.length; i++) {
            String[] cars = records[i].split(" ");
            String time = cars[0];
            String carName = cars[1];
            String status = cars[2];

            String[] carTime = time.split(":");
            int hour = Integer.parseInt(carTime[0]);
            int minute = Integer.parseInt(carTime[1]);
            int realTime = hour * 60 + minute;

            if (status.equals("IN")) {
                inMap.put(carName, realTime);
            } else {
                int inTime = inMap.get(carName);
                inMap.remove(carName);
                if (outMap.containsKey(carName)) {
                    int preInTime = outMap.get(carName);
                    outMap.replace(carName, realTime - inTime + preInTime);
                } else {
                    outMap.put(carName, realTime - inTime);
                }
            }
        }
        int lastTime = 1439;
        for(String car : inMap.keySet()){
            int inTime = inMap.get(car);
            if(outMap.containsKey(car)){
                int preTime = outMap.get(car);
                outMap.replace(car, preTime + lastTime - inTime);
            }
            else{
                outMap.put(car, lastTime - inTime);
            }
        }
        Object[] outKey = outMap.keySet().toArray();
        Arrays.sort(outKey);
        int[] answer = new int[outKey.length];

        for(int i = 0; i < answer.length; i++){
            int result = baseFee;
            String car = String.valueOf(outKey[i]);
            int totalTime = outMap.get(car);
            if(baseTime < totalTime){
                result = (int)(baseFee + Math.ceil((double)(totalTime - baseTime) / extraTime) * extraFee);
            }
            answer[i] = result;

        }
        return answer;
    }
}
