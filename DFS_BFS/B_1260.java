package DFS_BFS;

import java.util.*;

// DFS와 BFS
public class B_1260 {
    static int N,M,V=0;
    static ArrayList<Integer> a[];
    static Queue<Integer> queue;

    // 깊이 우선 탐색
    public void dfs(int node, boolean[] visited){
        System.out.print(node+" ");
        visited[node] = true;
        for(int i=0;i<a[node].size();i++){
            int n = a[node].get(i);
            if(!visited[n]){
                dfs(n,visited);
            }
        }
    }

    // 너비 우선 탐색
    public void bfs(int node, boolean[] visited){
        while(!queue.isEmpty()){
            int n = queue.peek();
            System.out.print(n+" ");
            queue.poll();

            for(int i =0; i<a[n].size();i++){
                int x = a[n].get(i);
                if(!visited[x]){
                    queue.add(x);
                    visited[x] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        B_1260 b = new B_1260();
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        a = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];
        boolean[] visited2 = new boolean[N+1];
        queue = new LinkedList<>();

        for(int i=0;i<=N;i++)
            a[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x].add(y);
            a[y].add(x);
        }

        for(int i=1;i<=N;i++){
            Collections.sort(a[i]);
        }
        b.dfs(V,visited);
        System.out.println();
        queue.add(V);
        visited2[V] = true;
        b.bfs(V,visited2);
    }

}
