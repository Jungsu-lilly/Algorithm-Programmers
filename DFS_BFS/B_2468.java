package DFS_BFS;

import java.util.*;
public class B_2468 {

    static int[][] a;
    static int N;
    static boolean[][] visited;

    public static void dfs(int x, int y, int n){
        visited[x][y] = true;
        if(x-1>=0 && a[x-1][y]>n && !visited[x-1][y]) dfs(x-1,y,n);
        if(y+1< N && a[x][y+1]>n && !visited[x][y+1]) dfs(x,y+1,n);
        if(x+1< N && a[x+1][y]>n && !visited[x+1][y]) dfs(x+1,y,n);
        if(y-1>=0 && a[x][y-1]>n && !visited[x][y-1]) dfs(x,y-1,n);
    }

    public static void clearArr(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        N = sc.nextInt();
        a = new int[N][N];
        visited = new boolean[N][N];

        int min=101, max = -1;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                a[i][j] = sc.nextInt();
                min = Math.min(a[i][j], min);
                max = Math.max(a[i][j], max);
            }
        }

        int ans = 0;
        for(int n = min; n<=max; n++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(a[i][j] >n && !visited[i][j]){
                        dfs(i,j,n);
                        ans++;
                    }
                }
            }
            list.add(ans);
            ans = 0;
            clearArr();
        }
        list.add(1);
        Collections.sort(list,(o1,o2)->{return o2-o1;});
        System.out.println(list.get(0));
    }
}
