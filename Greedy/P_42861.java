package Greedy;
import java.util.*;

// 섬 연결하기
public class P_42861 {

    public int getParent(int[] parent, int x){
        if(x == parent[x]) return x;
        else
            return parent[x] = getParent(parent, parent[x]);
    }

    public void unionParent(int[] parent, int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    public class Edge{
        int a, b, dis;

        public Edge(int a, int b, int dis) {
            this.a = a;
            this.b = b;
            this.dis = dis;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];

        for(int i=0; i<n;i++)
            parent[i] = i;

        ArrayList<Edge> list = new ArrayList<>();
        for (int[] cost : costs) {
            list.add(new Edge(cost[0], cost[1],cost[2]));
        }

        // 간선 길이 오름차순 정렬
        Collections.sort(list ,(o1, o2) -> {
            if (o1.dis != o2.dis) return o1.dis - o2.dis;
            else return o1.a - o2.a;
        });

        for (Edge edge : list) {
            if(getParent(parent,edge.a) != getParent(parent, edge.b)){
                unionParent(parent, edge.a, edge.b);
                answer += edge.dis;
            }
        }
        return answer;
    }
}
