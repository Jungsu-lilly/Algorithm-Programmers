package DFS_BFS;

import java.util.ArrayList;

// DFS (깊이 우선 탐색). 스택 사용
public class dfs {

    static int num = 7;
    static int c[] = new int[8];
    static ArrayList<Integer> a[] = new ArrayList[8];

    public static void dfs(int x){
        if(c[x]==1) return;
        c[x] = 1;
        System.out.print(x+" ");
        for (Integer val : a[x]) {
            dfs(val);
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

        dfs(1);
    }
}
