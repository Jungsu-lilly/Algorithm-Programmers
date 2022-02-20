import java.io.*;
import java.util.Scanner;

public class B_1717 {

    // 부모 노드를 가져옴
    public static int getParent(int[] parent, int x){
        if(parent[x] == x) return parent[x];
        else
            return parent[x] = getParent(parent, parent[x]);
    }

    // 노드를 연결해줌
    public static void unionParent(int[] parent, int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    // 부모 노드가 같은지 확인함
    public static boolean findParent(int[]parent, int a, int b){
        int tempA = getParent(parent, a);
        int tempB = getParent(parent, b);

        if(tempA == tempB) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        int[] parent;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n+1];

        for(int i=0;i<n+1;i++)
            parent[i] = i;

        while(m-- > 0){
            int ans1;
            ans1 = sc.nextInt();
            if(ans1 == 0){
                int a = sc.nextInt();
                int b = sc.nextInt();
                unionParent(parent, a, b);
            }
            else { // 1인 경우
                int a = sc.nextInt();
                int b = sc.nextInt();
                boolean answer = findParent(parent, a, b);
                if(answer==true) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
