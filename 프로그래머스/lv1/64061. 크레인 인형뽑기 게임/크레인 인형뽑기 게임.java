import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        //순서대로 꺼내서 스택에 넣어준후 스택에 같은게있으면 빼내준다
        //board => [세로][가로]
        int n= board.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<moves.length;i++){
            int num = moves[i]-1; //가로 입력
            for(int j=0;j<n;j++){
                if(board[j][num]!=0){//세로 조사
                    int popNum = board[j][num];
                    board[j][num]=0;
                    //꺼낸 수가 바구니의 맨위랑 같을때 -> +2
                    if(!stack.isEmpty()&&popNum==stack.peek()){
                        stack.pop();
                        answer+=2;
                    }
                    //다를때 그냥 바구니에 넣어줌
                    else{
                        stack.push(popNum);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}