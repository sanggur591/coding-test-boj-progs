class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        long pNum = Long.parseLong(p);
        StringBuilder str = new StringBuilder();
        str.append(t);
        for(int i=0;i<t.length()-pLength+1;i++){
            if(Long.parseLong(str.substring(i,i+pLength))<=pNum)
                answer++;
        }
        return answer;
    }
}