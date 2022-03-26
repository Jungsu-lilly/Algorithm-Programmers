package StackQueue;

import java.util.*;
public class P_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truck_Num = truck_weights.length;

        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        int temp =0;  // bridge 에 있는 트럭 무게의 합
        for (int w : truck_weights) {
            que1.add(w);
        }
        for(int i=0;i<bridge_length;i++){
            bridge.add(0);
        }

        while(true){
            int front = 0;
            if(!que1.isEmpty())
                front = que1.peek();
            if(que1.isEmpty() && temp ==0) break;

            temp -= bridge.peek();
            bridge.poll();
            if(front + temp <= weight){
                bridge.add(front);
                temp+= front;
                que1.poll();
            }else
                bridge.add(0);
            answer+=1;
        }

        return answer;
    }

    public static void main(String[] args) {
        P_42583 p = new P_42583();
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        int answer = p.solution(bridge_length, weight, truck_weights);
        System.out.println(answer);
    }
}
