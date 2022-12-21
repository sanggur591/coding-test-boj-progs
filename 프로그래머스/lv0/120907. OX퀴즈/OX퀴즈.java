class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i=0;i<quiz.length;i++) {
            String str = quiz[i];
            String[] list = str.split(" ");
            int x = Integer.parseInt(list[0]);
            int y = Integer.parseInt(list[2]);
            int z = Integer.parseInt(list[4]);
            if(list[1].equals("+")) answer[i]= x+y==z ? "O" : "X";
            else if(list[1].equals("-")) answer[i]= x-y==z ? "O" : "X";
        }
        return answer;
    }
}