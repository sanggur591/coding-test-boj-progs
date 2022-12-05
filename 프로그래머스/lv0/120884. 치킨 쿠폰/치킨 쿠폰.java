class Solution {
    public int solution(int chicken) {
        int answer = -1;
        //전체쿠폰수 -10 -> +1 순서대로니까 마지막에 받은쿠폰까지해서 9개면 안된다
        //(마지막만아니면 9개여도 상관없음 -10+1=-9로 한번에 연산이 되니까)
        if(chicken==0) return 0;
        answer = chicken/9;
        if(chicken%9==0) answer--;
        return answer;
    }
}