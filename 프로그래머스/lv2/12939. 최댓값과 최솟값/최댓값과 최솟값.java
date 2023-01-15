import java.util.Arrays;

class Solution {//최솟값과 최댓값
    public String solution(String s) {
        String answer = "";
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        answer=answer+arr[0]+" "+arr[arr.length-1];
        return answer;
    }
}