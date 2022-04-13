package DP;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
    static int INF = Integer.MAX_VALUE;
    static ArrayList<int[]>[] a;
    static int[] d;

    public static void dijkstra(int start){  // 정점 start에서 각 노드까지의 최단 거리를 구한다.
        d[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {return o1[1] - o2[1];});
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int cur = pq.peek()[0];
            int dis = pq.peek()[1];
            pq.poll();

            // 최단거리가 아닐 경우 스킵한다.
            if(d[cur] < dis) continue;
            for(int i=0;i<a[cur].size();i++){
                int next = a[cur].get(i)[0];
                int nextDis = dis + a[cur].get(i)[1];

                if(d[next] > nextDis){
                    d[next] = nextDis;
                    pq.add(new int[]{next, nextDis});
                }
            }
        }
    }

    public static void main(String[] args) {
        d = new int[7];
        for(int i=0;i<=6;i++)
            d[i] = INF;

        a = new ArrayList[7];
        for(int i=1;i<=6;i++)
            a[i] = new ArrayList<>();

        a[1].add(new int[]{2,2});a[1].add(new int[]{3,5});a[1].add(new int[]{4,1});
        a[2].add(new int[]{1,2});a[2].add(new int[]{3,3});a[2].add(new int[]{4,2});
        a[3].add(new int[]{1,5});a[3].add(new int[]{2,3});a[3].add(new int[]{4,3});a[3].add(new int[]{5,1});a[3].add(new int[]{6,5});
        a[4].add(new int[]{1,1});a[4].add(new int[]{2,2});a[4].add(new int[]{3,3});a[4].add(new int[]{5,1});
        a[5].add(new int[]{3,1});a[5].add(new int[]{4,1});a[5].add(new int[]{6,2});
        a[6].add(new int[]{3,5});a[6].add(new int[]{5,2});

        dijkstra(2);

        for(int i=1;i<=6;i++){
            System.out.print(d[i]+" ");
        }
    }
}
