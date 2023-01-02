import java.util.ArrayList;

class Solution {
    //U D R L
    //출발점 -> 도착점이 같은 것은 제외해주고 카운트해주면 된다
    public int solution(String dirs) {
        int answer = 0;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int[] startPoint = {0,0};
        int[] endPoint = {0,0};
        ArrayList<String> list = new ArrayList<>();
        //1. 배열안에 없으면 넣어주고 같은것이 input되지 않으면 카운트해주고
        for( int i=0;i<dirs.length();i++) {
            switch (dirs.charAt(i)) {
                case 'U':
                    if(startPoint[1]!=5){
                        endPoint[0] = startPoint[0] + dx[0];
                        endPoint[1] = startPoint[1] + dy[0];
                    }
                    break;
                case 'D':
                    if(startPoint[1]!=-5){
                        endPoint[0] = startPoint[0] + dx[1];
                        endPoint[1] = startPoint[1] + dy[1];
                    }
                    break;
                case 'R':
                    if(startPoint[0]!=5) {
                        endPoint[0] = startPoint[0] + dx[2];
                        endPoint[1] = startPoint[1] + dy[2];
                    }
                    break;
                case 'L':
                    if(startPoint[0]!=-5) {
                        endPoint[0] = startPoint[0] + dx[3];
                        endPoint[1] = startPoint[1] + dy[3];
                    }
                    break;
            }
            String graphMoving = ""+startPoint[0]+startPoint[1]+endPoint[0]+endPoint[1];
            String reverseGraphMoving = ""+endPoint[0]+endPoint[1]+startPoint[0]+startPoint[1];
            if(!list.contains(graphMoving)&&!(startPoint[0]==endPoint[0]&&startPoint[1]==endPoint[1])){
                list.add(graphMoving);
                list.add(reverseGraphMoving);
            }
            startPoint[0]=endPoint[0];
            startPoint[1]=endPoint[1];
        }

        return list.size()/2;
    }
}