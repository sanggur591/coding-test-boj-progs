class Solution {
    public int solution(int[] array) {
        int[] arr = new int[1000];
        for(int x : array){
            arr[x]++;
        }
        boolean isMulti=false;
        int max =0;
        int maxIndex=0;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]) {
                max=arr[i];
                maxIndex=i;
                isMulti=false;
            }
            else if(arr[i]==max) isMulti=true;
        }
        if(isMulti) return -1;
        return maxIndex;
    }
}