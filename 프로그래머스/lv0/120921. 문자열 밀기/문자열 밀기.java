class Solution {
    public int solution(String A, String B) {
        int answer=0;
        String newWord = A;
        //문자열A의 끝과 나머지를 자른후에 새로운 문자열을 만든다
        //새로만든 문자열을 B와 비교한다
        //1-2과정을 A의 개수만큼 반복한다
        if(A.equals(B)) return 0;
        for(int i=0;i<A.length();i++){
            String last = newWord.substring(A.length()-1,A.length());
            String theOthers = newWord.substring(0,A.length()-1);
            newWord=last.concat(theOthers);
            if(newWord.equals(B)){
                return ++answer;
            }
            ++answer;
        }
        return -1;
    }
}