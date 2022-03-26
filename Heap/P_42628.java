package Heap;

import java.util.*;
public class P_42628 {
    public int[] solution(String[] operations) {
        int max , min = 0;
        int curSize = 0;
        // 오름차순 정렬 : 최소값 구하기
        PriorityQueue<Integer> pq1 = new PriorityQueue<>( (o1,o2) -> {return o1 - o2;});
        // 내림차순 정렬 : 최대값 구하기
        PriorityQueue<Integer> pq2 = new PriorityQueue<>( (o1,o2) -> {return o2 - o1;});


        for (String operation : operations) {
            if(operation.startsWith("I")){ // 큐에 숫자 삽입
                StringTokenizer st = new StringTokenizer(operation);
                String s = st.nextToken();
                String s1 = st.nextToken();
                pq1.offer(Integer.parseInt(s1));
                pq2.offer(Integer.parseInt(s1));
            }
            else if(operation.equals("D 1") && !pq2.isEmpty()){  // 큐에서 최댓값을 꺼냅니다.
                Integer poll = pq2.poll();
                pq1.remove(poll);
            }
            else if(operation.equals("D -1") && !pq1.isEmpty()) {  // 큐에서 최솟값을 꺼냅니다.
                Integer poll = pq1.poll();
                pq2.remove(poll);
            }
        }

        if(!pq2.isEmpty())  max = pq2.peek();
        else max = 0;

        if(!pq1.isEmpty())  min = pq1.peek();
        else min = 0;

        int[] answer = {max, min};
        return answer;
    }


    public static void main(String[] args) {

        P_42628 p = new P_42628();
        int[] ans = p.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});

        System.out.println("["+ans[0]+", "+ans[1]+"]");
    }

}
