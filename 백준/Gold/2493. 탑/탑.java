import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer[]> stack = new Stack<>();
        //graph[x][0]이 수 graph[x][1]이 인덱스 -> 순서대로 끼워넣어준다
        for(int i=0;i<array.length;i++){
            while(!stack.isEmpty()){
                if(stack.peek()[0]>=array[i]){
                    System.out.print(stack.peek()[1]+1+" ");
                    stack.push(new Integer[] {array[i],i});
                    break;
                } else{
                    stack.pop();
                }
            } if(stack.isEmpty()) {
                System.out.print(0+" ");
                stack.push(new Integer[] {array[i],i});
            }
        }
    }
}