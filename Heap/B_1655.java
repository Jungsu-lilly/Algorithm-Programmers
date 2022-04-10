package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 가운데를 말해요
public class B_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        // 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1,o2)->{return o1-o2;});
        // 최대 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->{return o2-o1;});

        for(int i=0;i<N;i++){
            int a = Integer.parseInt(br.readLine());
            if(minHeap.size() == maxHeap.size())
                maxHeap.add(a);
            else minHeap.add(a);

            if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){ // 두 값을 서로 바꾸어 넣어주어야 함
                int temp = maxHeap.peek(); maxHeap.poll();
                maxHeap.add(minHeap.peek()); minHeap.poll();
                minHeap.add(temp);
            }
            sb.append(maxHeap.peek()+"\n");
        }
        System.out.println(sb);
    }
}
