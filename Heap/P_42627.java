package Heap;

import java.util.*;

public class P_42627 {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0; // 몇 개의 작업을 완료 했는지
        int jobIdx = 0; // jobs 배열 인덱스
        int end = 0; // 최신 작업이 끝난 시각

        // 원본 배열: 작업 요청 시점 오름차순 정렬
        Arrays.sort(jobs, (o1,o2) -> {return o1[0] - o2[0];});

        // 우선순위 큐 : 작업 소요시간 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return o1[1] - o2[1];
        });

        // 디스크에 들어온 요청이 모두 완료될 때까지 반복
        while(count < jobs.length){
            // 현재 시각(end) 까지 들어온 요청을 모두 큐에 넣음
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= end){
                pq.offer(jobs[jobIdx++]);
            }

            if(pq.isEmpty()){ // 디스크가 작업을 수행하고 있지 않을 때
                end = jobs[jobIdx][0];
            }
            else{
                int[] temp = pq.poll();
                answer += end - temp[0] + temp[1];
                end += temp[1];
                count++;
            }
        }
        return (int)Math.floor(answer / jobs.length);
    }

    public static void main(String[] args) {
        P_42627 p = new P_42627();
        int ans = p.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println(ans);
    }
}
