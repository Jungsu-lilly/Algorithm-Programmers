package Greedy;
import java.util.*;

public class P_42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : people) {
            list.add(i);
        }
        int lIdx = 0;
        int rIdx = people.length-1;

        // 무게 오름차순 정렬
        Collections.sort(list,(o1, o2) -> {return o1 - o2;});

        // 아무도 짝을 지을 수 없다는 뜻
        if(list.get(0)+list.get(1) > limit){
            return people.length;
        }
        while(lIdx <= rIdx){
            if(lIdx == rIdx){
                answer++; break;
            }
            int min = list.get(lIdx);
            int max = list.get(rIdx);

            if(min + max > limit){
                rIdx--;
                answer++;
            }
            else{
                rIdx--; lIdx++ ;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P_42885 p = new P_42885();
        int ans1 = p.solution(new int[]{70, 50, 80, 50}, 100);
        int ans2 = p.solution(new int[]{70, 80, 50}, 100);

        System.out.println(ans1);
        System.out.println(ans2);
    }
}
