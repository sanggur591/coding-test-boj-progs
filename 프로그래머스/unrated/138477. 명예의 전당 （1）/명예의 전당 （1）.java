import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = {};
        LinkedList<Integer> honorList = new LinkedList<>();
        ArrayList<Integer> lowestScores = new ArrayList<>();
        //k가 입력되는 배열의 크기보다 같거나 클때
        if(k>score.length){
            for(int i=0;i<score.length;i++){
                honorList.add(score[i]);
                Collections.sort(honorList);
                lowestScores.add(honorList.get(0));
            }
        }
        else{
            //k번째까지는 그냥 다 넣어준다.
            for(int i=0;i<k;i++){
                honorList.add(score[i]);
                Collections.sort(honorList);
                lowestScores.add(honorList.get(0));
            }//k+1부터는 최저점수와 비교해서 넣어준다
            for(int i=k;i<score.length;i++){
                if(score[i]>honorList.get(0)) {
                    honorList.set(0,score[i]);
                    Collections.sort(honorList);
                }
                lowestScores.add(honorList.get(0));
            }
        }
        return lowestScores.stream().mapToInt(x->x).toArray();
    }
}