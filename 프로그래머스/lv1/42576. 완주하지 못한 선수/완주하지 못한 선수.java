
import java.util.HashMap;


class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //동명이인이 있을 수 있으므로 map을 이용하여서 카운트해준다
        //참여자명단을 hashmap으로 옮겨준다
        HashMap<String,Integer> map = new HashMap<>();
        for(String player : participant){
            if(map.containsKey(player)){
                map.put(player,map.get(player)+1);
            }else{
                map.put(player,1);
            }
        }
        //completion에 명단이 있을때 옮겨준 hashmap을 하나씩 빼준다
        for(String player : completion){
            if(map.containsKey(player)){
                map.put(player,map.get(player)-1);
            }
        }
        //나머지를 return해준다
        String result="";
        for(String key : map.keySet()){
            if(map.get(key)==1){
                result = key;
            }
        }
        return result;
    }
}