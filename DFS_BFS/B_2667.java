package DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_2667 {
    static int N , M= 0;
    static int[][]a = new int[25][25];
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean visited[][] = new boolean[25][25];
    static int max = 0;
    public void dfs(int x, int y){
        max++;
        visited[x][y] = true;
        if(x-1>=0 && !visited[x-1][y] && a[x-1][y] == 1) {dfs(x-1,y);}
        if(y+1<N && !visited[x][y+1] && a[x][y+1] == 1) {dfs(x,y+1);}
        if(x+1<N && !visited[x+1][y] && a[x+1][y] == 1) {dfs(x+1,y);}
        if(y-1>=0 && !visited[x][y-1] && a[x][y-1] == 1) {dfs(x,y-1);}
    }

    public static void main(String[] args) {
        B_2667 b = new B_2667();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i=0;i<N;i++) {
            String s = "";
            s = sc.next();
            for(int j=0;j<N;j++){
                a[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && a[i][j]==1) {
                    b.dfs(i,j);
                    list.add(max);
                    max = 0;
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
