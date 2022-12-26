class Solution {
    public int solution(int[] common) {
        int answer = 0;
        boolean isMultiple = true;
        boolean isPlus = true;

        for(int i=0;i<common.length-2;i++){
            if(common[i+1]*common[i+1]!=common[i]*common[i+2]) {
                isMultiple=false;
                break;
            }
            if(common[i+1]*2!=common[i]+common[i+2]) {
                isPlus=false;
                break;
            }
        }
        if(isPlus) return 2*common[common.length-1]-common[common.length-2];
        if(isMultiple) return common[common.length-1]*common[common.length-1]/common[common.length-2];
        return answer;
    }
}