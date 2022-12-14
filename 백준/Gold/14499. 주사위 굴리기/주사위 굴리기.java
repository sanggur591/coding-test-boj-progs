import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] info= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = info[0]; int M = info[1]; // N:세로, M:가로
        int x = info[2]; int y = info[3];
        int k = info[4];
        int[] route = new int[k];
        int[][] graph = new int[N][M];

        for(int i=0;i<N;i++){
            graph[i]= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        route = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //주사위에 있는 수->계속 바뀌므로 수를 직접 정해주지 않고 맵으로 표현한다.
        // + 그래도 배열로 묶어주는 이유는 주사위가 굴러갈때의 순서때문
        String[] diceNum = {"a","b","c","d","e","f"};
        HashMap<String,Integer> dice = new HashMap<>();
        for(int i=0;i<diceNum.length;i++){
            dice.put(diceNum[i],0);
        }
        //주사위가 굴러갈때의 방식
        int yMovedNum =0; int xMovedNum =0; //xy방향으로 각각이동한 수
        //각각 위쪽, 오른쪽을 할때 인덱스+1
        HashMap<String,String> diceFormation = new HashMap<>();
        diceFormation.put("bottom","a");
        diceFormation.put("north","b");
        diceFormation.put("east","c");
        diceFormation.put("south","e");
        diceFormation.put("west","d");
        diceFormation.put("top","f");

        for(int i=0;i<route.length;i++){
            switch (route[i]) {
                case 1:
                    if(y<M-1){
                        y++;
                        String east =diceFormation.get("east");
                        String top =diceFormation.get("top");
                        String west =diceFormation.get("west");
                        String bottom =diceFormation.get("bottom");
                        diceFormation.replace("bottom", east);
                        diceFormation.replace("east", top);
                        diceFormation.replace("top", west);
                        diceFormation.replace("west", bottom);
                        if(graph[x][y]==0) graph[x][y]=dice.get(diceFormation.get("bottom"));
                        else {
                            dice.replace(diceFormation.get("bottom"),graph[x][y]);
                            graph[x][y]=0;
                        }
                        System.out.println(dice.get(diceFormation.get("top")));
                    }
                    break;
                case 2:
                    if(y>0){
                        y--;
                        String east =diceFormation.get("east");
                        String top =diceFormation.get("top");
                        String west =diceFormation.get("west");
                        String bottom =diceFormation.get("bottom");
                        diceFormation.replace("bottom", west);
                        diceFormation.replace("west", top);
                        diceFormation.replace("top", east);
                        diceFormation.replace("east", bottom);
                        if(graph[x][y]==0) graph[x][y]=dice.get(diceFormation.get("bottom"));
                        else {
                            dice.replace(diceFormation.get("bottom"),graph[x][y]);
                            graph[x][y]=0;
                        }
                        System.out.println(dice.get(diceFormation.get("top")));
                    }
                    break;
                case 3:
                    if(x>0){
                        x--;
                        String north =diceFormation.get("north");
                        String top =diceFormation.get("top");
                        String south =diceFormation.get("south");
                        String bottom =diceFormation.get("bottom");
                        diceFormation.replace("bottom", north);
                        diceFormation.replace("north", top);
                        diceFormation.replace("top", south);
                        diceFormation.replace("south", bottom);
                        if(graph[x][y]==0) graph[x][y]=dice.get(diceFormation.get("bottom"));
                        else {
                            dice.replace(diceFormation.get("bottom"),graph[x][y]);
                            graph[x][y]=0;
                        }
                        System.out.println(dice.get(diceFormation.get("top")));
                    }
                    break;
                case 4:
                    if(x<N-1){
                        x++;
                        String north =diceFormation.get("north");
                        String top =diceFormation.get("top");
                        String south =diceFormation.get("south");
                        String bottom =diceFormation.get("bottom");
                        diceFormation.replace("bottom", south);
                        diceFormation.replace("south", top);
                        diceFormation.replace("top", north);
                        diceFormation.replace("north", bottom);
                        if(graph[x][y]==0) graph[x][y]=dice.get(diceFormation.get("bottom"));
                        else {
                            dice.replace(diceFormation.get("bottom"),graph[x][y]);
                            graph[x][y]=0;
                        }
                        System.out.println(dice.get(diceFormation.get("top")));
                    }
                    break;
            }
        }
    }
}