class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String x : babbling){
            int num=0;
            boolean canSpeak= true;
            for(int i=0;i<x.length();i+=2){
                int pass = 0;
                if(i+2<=x.length()){
                    if(num!=1&&x.substring(i,i+2).equals("ye")){
                        num=1; pass=1;
                    }
                     if(num!=2&&x.substring(i,i+2).equals("ma")){
                        num=2; pass=1;
                    }
                }
                if(i+3<=x.length()){
                    if(num!=3&&x.substring(i,i+3).equals("aya")){
                        num=3; pass=2;
                    }
                     if(num!=4&&x.substring(i,i+3).equals("woo")){
                        num=4; pass=2;
                    }
                }
                if(pass==0){
                    canSpeak=false;
                    break;
                }
                if(pass==2) i++;
            }
            if(canSpeak) answer++;
        }
        return answer;
    }
}
