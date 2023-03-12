import java.util.Arrays;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int[] numberClone = number.clone();
        int discountDays = discount.length;
        for(int i=0;i<discountDays;i++){
            for(int j=0;j<10;j++){
                if(j+i==discountDays) break;
                //want랑 같은 문자열이면 비교해주기
                for(int k=0;k<want.length;k++){
                    if(number[k]>0 && discount[i+j].equals(want[k])){
                        number[k]--;
                    }
                }
            }
            if(Arrays.stream(number).sum()==0) answer++;
            //리셋해주기 -> 여기서 배열의 메모리저장하는 방식을 다시 리마인드가 되었다.

            number=numberClone.clone();
        }
        return answer;
    }
}