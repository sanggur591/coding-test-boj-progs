class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int lNum = 10; int rNum=12;
        for( int i=0;i<numbers.length;i++){
            //편의상 0->11로 해주기
            if(numbers[i]==0) numbers[i]=11;
            int floor = (numbers[i]-1)/3;
            int room = (numbers[i]-1)%3;
            //왼
            if(room==0){
                lNum=numbers[i];
                answer=answer+"L";
            }//오
            else if(room==2){
                rNum=numbers[i];
                answer=answer+"R";
            }//중간
            else{
                int rNumFloor = (rNum-1)/3;
                int rNumRoom = (rNum-1)%3;
                int lNumFloor = (lNum-1)/3;
                int lNumRoom = (lNum-1)%3;
                int rDistance = Math.abs(rNumFloor-floor)+Math.abs(rNumRoom-room);
                int lDistance = Math.abs(lNumFloor-floor)+Math.abs(lNumRoom-room);
                //거리가 같을때
                if(rDistance==lDistance){
                    if(hand.equals("left")){
                        lNum=numbers[i];
                        answer=answer+"L";
                    } else if (hand.equals("right")){
                        rNum=numbers[i];
                        answer=answer+"R";
                    }
                }
                //오가 더 가까울때
                else if(rDistance>lDistance){
                    lNum=numbers[i];
                    answer=answer+"L";
                }
                //왼이 더 가까울때
                else if(rDistance<lDistance){
                    rNum=numbers[i];
                    answer=answer+"R";
                }
            }
        }
        return answer;
    }
}