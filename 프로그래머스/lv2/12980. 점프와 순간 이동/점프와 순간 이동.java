public class Solution {//2배수로부터 얼마나 세부적으로(애매하게) 떨어져있나?
    public int solution(int n) {
        int ans = 1;
        int x=1;
        while(x!=n){
            while(x*2<=n) {//x가 n보다 더 큰 최소의 2의 제곱
                x*=2;
            }
            n-=x;//남은 수 구하기
            if(n==0) break;// 같으면 2의배수 break
            ans++; x=1;
        }
        return ans;
    }
}