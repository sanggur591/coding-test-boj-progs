import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        int answer = 0;
        //슷지기 100까지니까 100까지만 배열로 만들어준다(배열의 index+1= 기존의 수)
        ArrayList<Integer> arr = new ArrayList<>();
        int i=1;
        while(arr.size()<100) {
            if(!String.valueOf(i).contains("3")&&i%3!=0){
                arr.add(i);
            }
            i++;
        }
        return arr.get(n-1);
    }
}