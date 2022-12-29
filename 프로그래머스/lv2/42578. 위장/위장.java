import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String[] arr : clothes){
            if(hashMap.containsKey(arr[1])) hashMap.put(arr[1],hashMap.get(arr[1])+1);
            else hashMap.put(arr[1],1);
        }
        answer = hashMap.entrySet().stream().mapToInt(set->set.getValue()).reduce(1,(a,b)->a*(b+1));
        return answer-1;
    }
}