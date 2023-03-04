class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(n!=1){
            a--; b--; 
            a/=2; b/=2;
            a++; b++; answer++;
            if(a==b) break;
        }
        return answer;
    }
}