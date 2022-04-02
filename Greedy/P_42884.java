package Greedy;
import java.util.*;

// 단속 카메라
public class P_42884 {
    public int solution(int[][] routes) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] r : routes) {
            list.add(r);
        }
        Collections.sort(list, (o1, o2)->{return o1[1] - o2[1];});
        int temp = -30001;
        for (int[] route : list) {
            if(temp < route[0]) {
                temp = route[1];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P_42884 p = new P_42884();
        int answer = p.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}});
        int answer2 = p.solution(new int[][]{{-20, -15}, {-19, -14}, {-13, -12}, {-10, -4}, {-9,-6}});
        int answer3 = p.solution(new int[][]{{-11,-10},{-10,-9},{-11,-9},{-9,-8},{-8,-7},{-7,-6},{-6,-5},{-4,-3}});
        System.out.println(answer);
        System.out.println(answer2);
        System.out.println(answer3);
    }
}
