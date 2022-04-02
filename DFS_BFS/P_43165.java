package DFS_BFS;
import java.util.*;
// 타겟 넘버
public class P_43165 {

    static int answer = 0;
    public void bfs(int[]numbers, int temp, int idx, int target){
        if(idx == numbers.length - 1){
            if(temp == target)
                answer++;
            return;
        }
        int a = numbers[idx+1];
        bfs(numbers, temp+a, idx+1, target);
        bfs(numbers, temp-a, idx+1, target);
    }

    public int solution(int[] numbers, int target) {
        bfs(numbers, numbers[0], 0, target);
        bfs(numbers, -numbers[0], 0, target);
        return answer;
    }

    public static void main(String[] args) {
        P_43165 p = new P_43165();
        int ans1 = p.solution(new int[]{1,1,1,1,1}, 3);
        answer = 0;
        int ans2 = p.solution(new int[]{4,1,2,1}, 4);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
