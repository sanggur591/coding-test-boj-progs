import java.util.ArrayList;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        //당첨 순위를 위한 배열
        int[] result = {6,5,4,3,2,1,0};
        ArrayList<Integer> list = new ArrayList<>();
        int zero=0; int hit=0;
        //지워진수 카운트
        for(int lotto : lottos){
            if(lotto!=0){
                list.add(lotto);
            }
            else zero++;
        }
        //지워지지 않은 수들 중에 당첨된 수 카운트
        for(int win_num : win_nums){
            if(list.contains(Integer.valueOf(win_num))){
                hit++;
            }
        }
        //최저:hit된것만 배열에 넣음, 최고:hit+zero를 배열에 넣음
        int hitZero = hit+zero;
        for(int i=0;i<result.length;i++){
            if(hitZero==result[i]) answer[0]=i+1;
            if(hit==result[i])answer[1]=i+1;
        }
        for(int j=0;j<2;j++){
            if(answer[j]==7) answer[j]=6;
        }
        return answer;
    }
}