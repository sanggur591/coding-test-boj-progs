import java.util.LinkedList;


class Solution {
    public int solution(String str1, String str2) {
        LinkedList<String> list = new LinkedList<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        for(int i=0;i<str1.length()-1;i++){
            char a =str1.charAt(i);
            char b = str1.charAt(i+1);
            if(Character.isAlphabetic(a)&&Character.isAlphabetic(b)) {
                String x = ""+a+b;
                list.add(x);
            }
        }
        int str1Size = list.size();
        int str2Size = 0;
        for(int i=0;i<str2.length()-1;i++){
            char a =str2.charAt(i);
            char b = str2.charAt(i+1);
            if(Character.isAlphabetic(a)&&Character.isAlphabetic(b)) {
                str2Size++;
                String y = ""+a+b;
                if(list.contains(y)){
                    list.remove(y);
                }
            }
        }
        int onlyStr1Size=list.size();
        int andSize=str1Size-onlyStr1Size;
        int totalSize=onlyStr1Size+str2Size;
        if(totalSize==0) return 65536;
        double answer = (double) andSize/totalSize*65536;
        return (int) answer;
    }
}