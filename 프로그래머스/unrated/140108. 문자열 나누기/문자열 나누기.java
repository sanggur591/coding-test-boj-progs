class Solution {
    public int solution(String s) {
        int answer = 0;
        int sameNum=1; int otherNum=0;
        boolean isFirstChar=true;
        char firstChar='a';
        for(int i=0;i<s.length();i++){
            if(isFirstChar){
                isFirstChar=false;
                sameNum=1; otherNum=0;
                answer++;
                firstChar=s.charAt(i);
            }
            else{
                if(firstChar==s.charAt(i)) sameNum++;
                else otherNum++;
                
                if(sameNum==otherNum) isFirstChar=true;
            }
        }
        return answer;
    }
}