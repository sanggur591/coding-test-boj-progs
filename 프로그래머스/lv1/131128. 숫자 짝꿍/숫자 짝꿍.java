
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        //각각의 수를 세려준후에 바로 스트링으로 리스트로 준다
        for(int i=9;i>=0;i--) {
            int originalLengthOfX = X.length();
            X=X.replace(String.valueOf(i),"");
            int reducedLengthOfX = X.length();
            int iOfX = originalLengthOfX - reducedLengthOfX;

            int originalLengthOfY = Y.length();
            Y=Y.replace(String.valueOf(i),"");
            int reducedLengthOfY = Y.length();
            int iOfY = originalLengthOfY - reducedLengthOfY;

            int duplicatedI = Math.min(iOfX,iOfY);
            answer=answer+String.valueOf(i).repeat(duplicatedI);
        }
        if(answer.isEmpty()) return "-1";
        if(answer.charAt(0)=='0') return "0";
        return answer;
    }
}