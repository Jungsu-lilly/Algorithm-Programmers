package 완전탐색;
import java.util.*;

public class P_42842 {  // 프로그래머스 - [카펫]
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        ArrayList<int[]> list = new ArrayList<>();
        list = findBrown(brown, list);
        for (int[] arr : list) {
            if(arr[0]*arr[1] == yellow){
                answer[0] = arr[0]+2;
                answer[1] = arr[1]+2;
            }
        }
        return answer;
    }

    public ArrayList<int[]> findBrown(int brown, ArrayList<int[]> list){
        int a,b=0;
        int temp = brown/2 - 2;
        for(int i=1;i<=temp/2;i++){
            list.add(new int[]{temp-i, i});
        }
        return list;
    }

    public static void main(String[] args) {
        P_42842 p = new P_42842();
        int[] ans1 = p.solution(10,2);
        int[] ans2 = p.solution(8, 1);
        int[] ans3 = p.solution(24, 24);
        System.out.println("["+ans1[0]+", "+ans1[1]+"]");
        System.out.println("["+ans2[0]+", "+ans2[1]+"]");
        System.out.println("["+ans3[0]+", "+ans3[1]+"]");

    }
}
