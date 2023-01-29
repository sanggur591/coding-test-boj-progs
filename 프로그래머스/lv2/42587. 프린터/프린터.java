import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>(Arrays.stream(priorities).boxed().collect(Collectors.toList()));
        while(!queue.isEmpty()){
            int x = queue.poll();
            if(queue.stream().filter(y->y>x).count()>=1) {
                queue.offer(x);
                if(location==0) location= queue.size()-1;
                else location--;
            }
            else {
                answer++;
                if(location==0) break;
                location--;
            }
        }
        return answer;
    }
}