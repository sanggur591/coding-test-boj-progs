class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb1 = new StringBuilder();
        //각각 2로 나누어준 몫을 구한다
        for(int i=1;i<food.length;i++){
            String x =String.valueOf(i).repeat(food[i]/2);
            //몫으로 나온값(1~중간)까지를 문자열에 나열해준다
            sb1=sb1.append(x);
        }
        //0을 추가해주고 뒤집은 문자열을 추가해준다.
        answer=sb1+"0";
        String reversed = sb1.reverse().toString();
        answer=answer+reversed;
        return answer;
    }
}