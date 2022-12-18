import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] survey, int[] choices) {
        //map으로 정렬하는식으로 하지않고 서로다른타입 2개를 다른 리스트에 채워넣고 점수표가 0이상 vs 음수로 성격을 정한다
        String answer = "";
        int[] temper = new int[4];
        List<String> type1 = Arrays.stream(new String[]{"R","C","J","A"}).collect(Collectors.toList());
        List<String> type2 = Arrays.stream(new String[]{"T","F","M","N"}).collect(Collectors.toList());
        for(int i=0;i<survey.length;i++){
            String s = survey[i];
            String c = String.valueOf(s.charAt(1));
            //survey에 있는 2번째 글자가 기준이므로
            if(type1.contains(c)){
                int index = type1.indexOf(c);
                temper[index]+=getScore(choices[i]);
            } else if(type2.contains(c)){
                int index = type2.indexOf(c);
                temper[index]-=getScore(choices[i]);
            }
        }
        for(int i=0;i<4;i++){
            if(temper[i]>=0) answer+=type1.get(i);
            else answer+=type2.get(i);
        }
        return answer;
    }
    public int getScore(int x){
        switch (x){
            case 7: return 3;
            case 6: return 2;
            case 5: return 1;
            case 4: return 0;
            case 3: return -1;
            case 2: return -2;
            case 1: return -3;
        }
        return 0;
    }
}