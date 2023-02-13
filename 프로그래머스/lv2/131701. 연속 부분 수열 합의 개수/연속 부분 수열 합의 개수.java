import java.util.ArrayList;
import java.util.HashSet;
class Solution {
    public int solution(int[] elements) {
        //각각의 부분들을 만들어준다
        int size = elements.length;
        ArrayList<Integer> newElements = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<elements.length;i++){
            newElements.add(elements[i]);
        }
        for(int i=0;i<elements.length;i++){
            newElements.add(elements[i]);
        }
        for(int i=1;i<=elements.length;i++){
            for(int j=0;j< newElements.size();j++){
                int num=0;
                for(int k=0;k<i;k++){
                    if(j+k< newElements.size()) num+=newElements.get(j+k);
                }
                set.add(num);
            }
        }
        return set.size();
    }
}