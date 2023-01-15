import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue1 = new LinkedList<>(Arrays.stream(progresses).boxed().collect(Collectors.toList()));
        Queue<Integer> queue2 = new LinkedList<>(Arrays.stream(speeds).boxed().collect(Collectors.toList()));
        int time =0;
        ArrayList<Integer> answer = new ArrayList<>();
        while(!queue1.isEmpty()){
            int out =0;
            while(!queue1.isEmpty()&&queue1.peek()+queue2.peek()*time>=100){
                queue1.poll();
                queue2.poll();
                out++;
            }
            if(out!=0) answer.add(out);
            time++;
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}