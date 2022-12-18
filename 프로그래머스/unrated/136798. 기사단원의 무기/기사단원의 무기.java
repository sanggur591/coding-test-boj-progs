class Solution {
    public int solution(int number, int limit, int power) {
        int sum=0;
        for (int i=1;i<=number;i++){
            int x;
            if(i==1) x=1;
            else if(i==2) x=2;
            else{
                //1과 자기자신은 당연히되므로(예외인 1,2는 빼줬다) 먼저 카운트 후 2부터시작
                x=2;
                for(int j=2;j<=Math.sqrt(i);j++){
                    if(i%j==0) x+=2;
                }
                if(i%Math.sqrt(i)==0) x-=1;
                if(x>limit) x=power;
            }
            sum+=x;
        }
        return sum;
    }
}