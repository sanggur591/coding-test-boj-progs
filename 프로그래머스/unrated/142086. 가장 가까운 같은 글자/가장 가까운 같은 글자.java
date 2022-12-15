import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        //a-z가 97~122 -> 26개
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(alphabet[ch-97]==-1) {
                list.add(-1);
            }
            else {
                list.add(i-alphabet[ch-97]);
            }
            alphabet[ch-97]=i;
        }
        return list.stream().mapToInt(x->x).toArray();
    }
}