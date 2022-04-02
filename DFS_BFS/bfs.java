package DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

// BFS (너비 우선 탐색) - 큐를 이용
public class bfs {
    static int number = 7;
    static int[] c = new int[8];
    static ArrayList<Integer> a[] = new ArrayList[8];

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        c[start] = 1;

        while(!q.isEmpty()){
            int x = q.peek();
            q.poll();
            System.out.print(x+" ");

            for (Integer i : a[x]) {
                if(c[i] == 0){
                    q.add(i);
                    c[i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<=7;i++){
            a[i] = new ArrayList<>();
        }
        a[1].add(2); a[2].add(1);
        a[1].add(3); a[3].add(1);
        a[2].add(3); a[3].add(2);
        a[2].add(4); a[4].add(2);
        a[2].add(5); a[5].add(2);
        a[4].add(5); a[5].add(4);
        a[3].add(6); a[6].add(3);
        a[3].add(7); a[7].add(3);
        a[6].add(7); a[7].add(6);


        bfs(1);
    }
}
