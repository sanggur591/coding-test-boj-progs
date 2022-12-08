class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder s = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        s.append(new_id);
        int n = s.length();
        for(int i=0;i<n;i++){
            //1.대문자->소문자
            char x =s.charAt(i);
            if(x>=65&&x<=90){
                sb.append((char)(x+32));
            }
            else if(x=='.'||x=='_'||x=='-'||(x>=97&&x<=122||(x>=48&&x<=57))){
                sb.append(x);
            }
        }
        //3. '.' 2개이상 제거
        boolean noSequenceDot = false;
        while(!noSequenceDot){
            int doubleDot = sb.indexOf("..");
            if(doubleDot!=-1) sb.deleteCharAt(doubleDot);
            else noSequenceDot=true;
        }
        //4.첫, 마지막 '.'제거

        boolean noFirstOrLastDot=false;
        while(sb.length()>0&&!noFirstOrLastDot){
            noFirstOrLastDot=true;
            if(sb.charAt(0)=='.') {
                noFirstOrLastDot=false;
                sb.deleteCharAt(0);
            }
            else if(sb.charAt(sb.length()-1)=='.'){
                noFirstOrLastDot=false;
                sb=sb.deleteCharAt(sb.length()-1);
            }
        }
        //5.빈문자열 -> a추가
        if(sb.length()==0) sb.append("aaa");
            //6.길이가 15이상
        else if(sb.length()>=16){
            sb.delete(15,sb.length());
            boolean noLastDot = false;
            while(!noLastDot){
                noLastDot=true;
                if(sb.charAt(sb.length()-1)=='.'){
                    noLastDot=false;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        //7. 길이 2이하 ->3으로
        while(sb.length()<3){
            sb.append(sb.charAt(sb.length()-1));
        }
        answer=sb.toString();
        return answer;
    }
}