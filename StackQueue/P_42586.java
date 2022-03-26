package StackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_42586 {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        ArrayList<Integer> times = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            int workLeft = 100 - progresses[i];  // 남은 일
            double time = (double)workLeft / (double)speeds[i]; // 걸리는 시간
            time = Math.ceil(time);
            times.add((int)time); // 걸리는 시간
        }

        que.add(times.get(0));
        for(int i=1; i< times.size(); i++){
            int frontVal = que.peek();
            if(times.get(i) <= frontVal){
                que.add(times.get(i));
            }else{ // times.get(i) > frontval
                int count = 0;
                while(!que.isEmpty()){
                    que.poll(); // 하나씩 빼준다.
                    count++;
                }
                que.add(times.get(i));
                list.add(count);
            }
        }
        int count = 0;
        while(!que.isEmpty()){
            count++;
            que.poll();
        }
        list.add(count);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        P_42586 p = new P_42586();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] answer = p.solution(progresses, speeds);
        for (int i : answer) {
            System.out.print(i+" ");
        }
    }
}
