class Solution {
    public String solution(String polynomial) {
        String answer = "";
        //메타문제로 split을 쓸때는 \\을해준다
        String[] nums = polynomial.replace(" ","").split("\\+");
        int xNum=0;
        int n=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i].contains("x")){
                if(nums[i].length()==1) xNum++;
                else xNum+=Integer.valueOf(nums[i].substring(0,nums[i].length()-1));
            }
            else{
                n+=Integer.valueOf(nums[i]);
            }
        }
        if(xNum==0) {
            //싹다 0일땐 그냥 ""
            // x=0, n은 있음
            if(n!=0) answer+=n;
        }
        else{
            //x가 있고 n=0
            if(n==0) answer+=xNum+"x";
            //둘 다있음
            else answer += xNum+"x + "+n;
        }
        if(xNum==1) answer=answer.replace("1x","x");
        return answer;
    }
}