class Solution {// 1. 두 수의 최소공배수를 비교하는 것을 연달아한다 2. 모든수를 인수분해하고 다 곱한다.(지수가 더큰걸로 적용)
    public int solution(int[] arr) {
        if(arr.length==1) return arr[0];
        int bigNum = arr[0] > arr[1] ? arr[0] : arr[1];
        int smallNum = arr[0] < arr[1] ? arr[0] : arr[1];
        int x = gcd(bigNum, smallNum);
        int result = arr[0]*arr[1]/x;
        for(int i=2;i<arr.length;i++){
            bigNum = result > arr[i] ? result : arr[i];
            smallNum = result < arr[i] ? result : arr[i];
            x = gcd(bigNum, smallNum);
            result = bigNum*smallNum/x;
        }
        return result;
    }
    int gcd(int a, int b){
        while(b!=0){
            int c =a%b;
            a=b;
            b=c;
        }
        return a;
    }
}