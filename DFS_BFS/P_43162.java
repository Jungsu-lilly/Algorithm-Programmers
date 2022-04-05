package DFS_BFS;
import java.util.*;

// 네트워크
public class P_43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean visited[] = new boolean[n];

        for(int i=0;i<n;i++){
            visited[i] = false;
        }

        for(int i=0;i<n;i++){
            if(visited[i] == false){
                answer++;
                dfs(i,visited,computers);
            }
        }
        return answer;
    }

    public void dfs(int node,boolean[] visited, int[][] computers){
        visited[node] = true;

        for(int i=0;i<computers.length;i++){
            if(visited[i] == false && computers[node][i] == 1){
                dfs(i,visited,computers);
            }
        }
    }

}
