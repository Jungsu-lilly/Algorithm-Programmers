package DFS_BFS;
import java.util.*;

// 적록색약
public class B_10026 {
    static int N;
    static char[][] a;
    static boolean[][] visited;

    public static void dfs(int x, int y){
        char temp = a[x][y];
        visited[x][y] = true;
        if(x-1>=0 && !visited[x-1][y] && a[x-1][y] == temp) dfs(x-1,y);
        if(y+1< N && !visited[x][y+1] && a[x][y+1] == temp) dfs(x,y+1);
        if(x+1< N && !visited[x+1][y] && a[x+1][y] == temp) dfs(x+1,y);
        if(y-1>=0 && !visited[x][y-1] && a[x][y-1] == temp) dfs(x,y-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            String temp = sc.next();
            for(int j=0;j<N;j++){
                a[i][j] = temp.charAt(j);
            }
        }

        int ans1=0, ans2=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    ans1++;
                }
            }
        }
        // R 과 G를 같게
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(a[i][j] == 'G') a[i][j] = 'R';
                visited[i][j] = false;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    ans2++;
                }
            }
        }

        System.out.println(ans1+" "+ans2);
    }
}
