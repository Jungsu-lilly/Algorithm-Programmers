package DFS_BFS;

import java.util.Scanner;

// 이분 그래프
public class B_1707 {
    static int N,M;
    static int[][] a;
    static int[][] near_Water;
    static boolean[][] visited;

    public static void water(){
        for(int x = 1; x<N-1;x++){
            for(int y=1;y<M-1;y++){
                near_Water[x][y] = 0;
                int temp = 0;
                if(a[x-1][y] == 0) temp++;
                if(a[x][y+1] == 0) temp++;
                if(a[x+1][y] == 0) temp++;
                if(a[x][y-1] == 0) temp++;
                near_Water[x][y] = temp;
            }
        }
    }

    public static void dfs(int x,int y){
        visited[x][y] = true;
        if(!visited[x-1][y] && a[x-1][y]!=0) dfs(x-1,y);
        if(!visited[x][y+1] && a[x][y+1]!=0) dfs(x,y+1);
        if(!visited[x+1][y] && a[x+1][y]!=0) dfs(x+1,y);
        if(!visited[x][y-1] && a[x][y-1]!=0) dfs(x,y-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        a = new int[N][M];
        near_Water = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                a[i][j] = sc.nextInt();
            }
        }
        water();

        int year = 0;
        while(true){
            year++;
            for(int i=1;i<N-1;i++){
                for(int j=1;j<M-1;j++){
                    if(a[i][j] < near_Water[i][j]) a[i][j] = 0;
                    else a[i][j] -= near_Water[i][j];
                }
            }
            int count = 0;
            for(int i=1;i<N-1;i++){
                if(count>=2) break;
                for(int j=1;j<M-1;j++){
                    if(a[i][j] !=0 && !visited[i][j]){
                        dfs(i,j); count++;
                    }
                    if(count>=2) break;
                }
            }
            if(count>=2) break;
            if(count==0){
                System.out.println(0);
                return;
            }
            water();
            for(int i=1;i<N-1;i++){
                for(int j=1;j<M-1;j++)
                    visited[i][j] = false;
            }
        }
        System.out.println(year);
    }
}
