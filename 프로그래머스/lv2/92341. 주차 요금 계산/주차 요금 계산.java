import java.util.ArrayList;
import java.util.TreeMap;

class Solution { //기본시간, 기본요금, 단위시간, 단위요금
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int perTime = fees[2];
        int perFee = fees[3];
        int n = records.length;
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for(int i=0;i<n;i++){// 차번호-시간 기입
            String[] s = records[i].split(" ");
            String[] s1 = s[0].split(":");
            int time = (Integer.parseInt(s1[0])) * 60
                    + Integer.parseInt(s1[1]);
            int carNum = Integer.parseInt(s[1]);
            if(map.containsKey(carNum)) {
                map.get(carNum).add(time);
            }
            else {
                map.put(carNum,new ArrayList());
                map.get(carNum).add(time);
            }
        }
        int[] answer = new int[map.size()];
        int x = map.size();
        for(int i=0;i<x;i++){
            int fee =0;
            ArrayList<Integer> list = map.pollFirstEntry().getValue();
            if(list.size()%2==1) list.add(1439);
            int time = 0;
            for(int j=0;j<list.size()/2;j++){//입출입이 2번이상 가능하므로
                time = time + list.get(j*2+1)-list.get(j*2);
            }
            if(time>defaultTime){
                if((time-defaultTime)%perTime ==0)
                    fee = defaultFee + perFee * ((time-defaultTime)/perTime);
                else
                    fee = defaultFee + perFee * ((time-defaultTime)/perTime+1);
            }
            else {
                fee = defaultFee;
            }
            answer[i]=fee;
        }
        return answer;
    }
}