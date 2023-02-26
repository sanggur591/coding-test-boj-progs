class Solution {
    public int[] solution(int brown, int yellow) {
        int YellowXPlusYellowY = (brown-4)/2;
        for (int i=1;i<=yellow;i++){
            if(yellow%i==0){
                int y=i; int x=yellow/y;
                if(YellowXPlusYellowY==x+y) return new int[]{x+2,y+2};
            }
        }

        return null;
    }
}