import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        //이름설정하기
        for(int i=0;i<record.length;i++) {
            String[] s = record[i].split(" ");
            if(s.length==2) continue;
            map.put(s[1],s[2]);
        }
        //채팅창 출력하기
        for(int i=0;i<record.length;i++){
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")){
                list.add(map.get(s[1])+"님이 들어왔습니다.");
            }else if(s[0].equals("Leave")){
                list.add(map.get(s[1])+"님이 나갔습니다.");
            }
        }
        return list.toArray(new String[0]);
    }
}