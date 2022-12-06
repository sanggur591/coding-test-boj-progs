class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        //크기가 k인배열 -> 각자의 인덱스+1이 그 점수이고, 안에 들어가는 수가 개수
        int[] nums = new int[k];
        //숫자의 개수를 세려준다
        for (int i=0;i<score.length;i++){
            nums[score[i]-1]++;
        }
        int sum=0; //뒤에서 i까지의 전체합
        int box=0;//박스수
        for (int i=k-1;i>=0;i--){
            sum+=nums[i];
            //현재 박싱할 박스 = (전체 - 이전에 박싱한것들)/개수
            int boxing=(sum-box*m)/m;
            box+=boxing;
            //점수더해주기
            answer+=boxing*m*(i+1);
        }
        return answer;
    }
}