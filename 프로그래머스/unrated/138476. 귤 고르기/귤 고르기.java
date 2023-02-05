import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        //크기별로 map에 넣어주고 개수가 많은것부터 전체수에서 빼준다
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            if(map.containsKey(tangerine[i]))
                map.put(tangerine[i],map.get(tangerine[i])+1);
            else
                map.put(tangerine[i],1);
        }
        List<Map.Entry<Integer, Integer>> entries =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toList());
        while(k>0){
            k-=entries.get(entries.size()-1-answer).getValue();
            answer++;
        }
        return answer;
    }
}