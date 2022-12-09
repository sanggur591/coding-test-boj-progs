import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int distance = y-x;
            int move =0;
            int moveDis=1;
            int moveDisCnt=0;
            while(distance>0){
                moveDisCnt++;
                distance-=moveDis;
                move++;
                if(moveDisCnt%2==0){
                    moveDis++;
                }
            }
            System.out.println(move);
        }
    }
}