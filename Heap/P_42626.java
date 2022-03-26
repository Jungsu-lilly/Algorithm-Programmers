package Heap;

import java.util.PriorityQueue;

public class P_42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i : scoville) {
            heap.offer(i);
        }
        if(heap.peek()>=K) return 0;

        while(heap.peek()<=K && heap.size() >= 2){
            int a = heap.peek();  heap.poll();
            int b = 2 * heap.peek();  heap.poll();
            heap.offer(a + b);
            answer++;
        }
        if(heap.peek() < K) return -1;
        return answer;
    }

    public static void main(String[] args) {
        P_42626 p = new P_42626();
        int ans = p.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);

        System.out.println(ans);
    }
}
