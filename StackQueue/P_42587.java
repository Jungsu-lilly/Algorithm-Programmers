package StackQueue;

import java.util.*;
public class P_42587 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        int length = priorities.length;
        for(int i=0;i<length;i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            boolean flag = false;
            int front = q.peek();
            for(int i=0;i<length;i++){
                if(i==front) continue;
                if(priorities[i] > priorities[front]){
                    q.poll();
                    q.add(front);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                q.poll();
                list.add(front);
                priorities[front] = 0;
            }
        }

        for(int i=0;i<list.size();i++){
            if(list.get(i)==location)
                return i+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        P_42587 p = new P_42587();
        int[] priotities = {2, 1, 3, 2};
        int location = 2;
        int ans = p.solution(priotities, location);
        System.out.println(ans);
    }
}
