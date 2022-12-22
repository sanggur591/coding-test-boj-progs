import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] ingredient) {
        String hamburgerTop = Arrays.stream(ingredient).mapToObj(String::valueOf).collect(Collectors.joining());
        StringBuilder sb = new StringBuilder();
        int answer=0;
        for(int i=0; i<ingredient.length; i++) {
            sb.append(ingredient[i]);
            if(sb.length()>3 && sb.subSequence(sb.length()-4, sb.length()).equals("1231")) {
                answer++;
                sb.delete(sb.length()-4, sb.length());
            }
        }

        return answer;
    }
}