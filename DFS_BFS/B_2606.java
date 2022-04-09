package DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

public class B_2606 {

    static ArrayList<Integer>[] a;
    static boolean visited[];
    static int ans = 0;

    static void dfs(int x){
        visited[x] = true;
        ans++;
        for (Integer node : a[x]) {
            if(!visited[node]){
                dfs(node);
            }
        }
    }
    public static void main(String[] args) {
        int N, M;
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N+1];
        a = new ArrayList[N+1];

        for(int i=1;i<=N;i++)
            a[i] = new ArrayList<Integer>();

        for(int i=0;i<M;i++){
            int  x, y=0;
            x = sc.nextInt(); y = sc.nextInt();
            a[x].add(y); a[y].add(x);
        }

        dfs(1);
        System.out.println(ans-1);
    }
}
