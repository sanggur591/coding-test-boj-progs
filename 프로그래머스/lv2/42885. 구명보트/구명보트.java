import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;

        for(int i = people.length-1;i>=0;i--){
            if(left==i) {
                answer++;
                break;
            } else if(left>i) {
                break;
            }
            if(people[left]+people[i]<=limit){
                answer++;
                left++;
            } else { answer++;}
        }
        return answer;
    }
}