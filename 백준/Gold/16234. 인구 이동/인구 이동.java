import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;


//오류 2번 index랑 length가 다르다고 뜸 -> 아마도 내가적은 index가 배열의 index보다 클때가 있는 것같은데?

//잘 모르겠는 것 : static메서드 안에 다른 메서드를 이용할 때 value로 파라미터를 전달하는 것과 객체 자체를 전달하는 것은 후의 결과가 다르다
//(메서드가 끝나고 나서 value로 전달한것은 로컬변수같은 느낌으로 취급되서 value가 원래의 값으로 돌아오고, obect로 전달한것은 그냥 바뀐다)
//파라미터로 전달된값이 그 메서드안에서만 사용된다는 말이 맞는것인지?
//1.이런법칙이 적용되는것은 다른 클래스사이에서만 그런것인지?
//2.배열은 object로 쳐주는지?

public class Main {
    static int N; static int L; static int R;
    static boolean isMerged = false;
    static int sum=0;
    static int cnt=0;
    static LinkedList<int[]> route;
    static boolean[][] visited;

    public static void main (String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int[] NLR=Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NLR[0]; L = NLR[1]; R = NLR[2];
        int[][] graph = new int[N][N];
        for(int i=0;i<N;i++){
            graph[i]=Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int answer=0;

        while(true){
            isMerged=false;
            visited = new boolean[N][N];
            //모든좌표 조사하기
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]){
                        route = new LinkedList<>();
                        merge(graph,i,j,visited,route);
                        if(route.size()>1) isMerged=true;
                        for(int[] xy : route){
                            graph[xy[0]][xy[1]]=sum/cnt;
                        }
                        sum=0; cnt=0;
                    }
                }
            }
//            10 100 20 90
//            80 100 60 70
//            70 20 30 40
//            50 20 100 10

            if(!isMerged) break;
            else answer++;
        }
        System.out.println(answer);
    }
    static void merge(int[][] graph,int x,int y,boolean[][] visited,LinkedList<int[]> route){
        if(visited[x][y]!=true){
            visited[x][y]=true;
            route.add(new int[]{x,y});
            cnt++;
            sum +=graph[x][y];
            int f =graph[x][y];
            //위,아래,좌,우로
            if(x!=0 && Math.abs(f-graph[x-1][y])>=L && Math.abs(f-graph[x-1][y])<=R) merge(graph,x-1,y,visited,route);
            if(x!=N-1 && Math.abs(f-graph[x+1][y])>=L && Math.abs(f-graph[x+1][y])<=R) merge(graph,x+1,y,visited,route);
            if(y!=0 && Math.abs(f-graph[x][y-1])>= L && Math.abs(f-graph[x][y-1])<=R) merge(graph,x,y-1,visited,route);
            if(y!=N-1 && Math.abs(f-graph[x][y+1])>=L && Math.abs(f-graph[x][y+1])<=R) merge(graph,x,y+1,visited,route);
        }
    }
}