import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int deletedZero = 0;
        int times =0;
        while(!s.equals("1")){
            times++;
            int before = s.length();
            int after=s.replace("0","").length();
            deletedZero+=(before-after);
            s=Integer.toBinaryString(after);
        }
        list.add(times); list.add(deletedZero);
        return list.stream().mapToInt(x->x).toArray();
    }
}