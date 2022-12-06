import java.util.LinkedList;

class Solution {
    public int[] solution(int[] numlist, int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<numlist.length;i++){//numlist를 받는다
            boolean isLast = true;
            for(int j=0;j<list.size();j++){//list조사
                if(Math.abs(n-numlist[i])<Math.abs(n-list.get(j))){
                    list.add(j,numlist[i]);
                    isLast=false;
                    break;
                }
                else if(Math.abs(n-numlist[i])==Math.abs(n-list.get(j))){
                    if(numlist[i]>list.get(j)) list.add(j,numlist[i]);
                    else if(numlist[i]<list.get(j)) list.add(j+1,numlist[i]);
                    isLast=false;
                    break;
                }
            }
            if(isLast) list.add(numlist[i]);
        }
        return list.stream().mapToInt(x->x).toArray();
    }
}