import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        //크기가 n개인 배열을 만들고 도난당한 사람, 여벌인사람을 고려하여 현재 가진 체육복의 수를 넣는다
        int[] arr = new int[n];
        List<Integer> lostList = new ArrayList<>(Arrays.stream(lost).boxed().collect(Collectors.toList()));
        List<Integer> reserveList = new ArrayList<>(Arrays.stream(reserve).boxed().collect(Collectors.toList()));
        LinkedList<Integer> twoList = new LinkedList<>();
        LinkedList<Integer> zeroList = new LinkedList<>();
        for(int i=0;i<n;i++){
            arr[i]+=1;
            if(lostList.contains(i+1)){
                arr[i]-=1;
            }
            if(reserveList.contains(i+1)){
                arr[i]+=1;
            }
            //여분인사람 번호 모으기
            if(arr[i]==2) twoList.add(i);
            //없는사람 번호 모으기
            else if(arr[i]==0) zeroList.add(i);
        }
        //0개인사람 앞에 여벌이있다면 받는다
        //이후 0개인사람 뒤에 여벌이있다면 받는다
        //처음과 끝을 고려해서 코드작성
        //k--는 줄어드는 리스트수를 조정하기 위해서
        for(int k=0;k<zeroList.size();k++){
            int x =zeroList.get(k);
            if(x==0){
                if(twoList.contains(1)) {
                    zeroList.remove(Integer.valueOf(0));
                    twoList.remove(Integer.valueOf(1));
                    k--;
                }
            }
            else if(x>0&&x<n-1){
                if(twoList.contains(x-1)){
                    zeroList.remove(Integer.valueOf(x));
                    twoList.remove(Integer.valueOf(x-1));
                    k--;
                }
                else if(twoList.contains(x+1)){
                    zeroList.remove(Integer.valueOf(x));
                    twoList.remove(Integer.valueOf(x+1));
                    k--;
                }
            }
            else{
                if(twoList.contains(n-2)){
                    zeroList.remove(Integer.valueOf(n-1));
                    twoList.remove(Integer.valueOf(n-2));
                    k--;
                }
            }
        }
        //0개인사람을 세려주고 n에서 빼준다
        return n-zeroList.size();
    }
}