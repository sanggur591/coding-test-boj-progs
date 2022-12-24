import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        List<String> list = Arrays.stream(id_list).collect(Collectors.toList());
        int[][] graph = new int[n][n];
        for(int i=0;i<report.length;i++){
            String[] reportList = report[i].split(" ");
            String reporterId = reportList[0];
            String reportedId = reportList[1];
            graph[list.indexOf(reportedId)][list.indexOf(reporterId)]=1;
        }
        for(int i=0;i<n;i++){
            if(Arrays.stream(graph[i]).sum()>=k){
                for(int j=0;j<n;j++){
                    if(graph[i][j]==1){
                        answer[j]++;
                    }
                }
            }
        }
        return answer;
    }
}