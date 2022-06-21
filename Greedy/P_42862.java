package Greedy;

import java.util.Arrays;

// 체육복
public class P_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer=0;
        int lostNum = lost.length;
        int[] rest = new int[n+1];
        for (int i=1;i<=n;i++) rest[i] = 1;

        for (int i : lost)
            rest[i]--;

        for (int i : reserve)
            rest[i]++;

        Arrays.sort(lost);

        for (int i=1; i<=n; i++) {
            if(rest[i]==0){
                boolean flag = false;
                if(i-1>0 && rest[i-1]==2){
                    rest[i-1]--; rest[i]++;
                    flag = true;
                }
                if(!flag && i+1<=n && rest[i+1]==2){
                    rest[i+1]--; rest[i]++;
                }
            }
        }

        for (int i : rest) {
            if(i>0) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        P_42862 p = new P_42862();
        int ans1 = p.solution(5, new int[]{4,2}, new int[]{1, 3, 5});
        int ans2 = p.solution(5, new int[]{2, 4}, new int[]{3});
        int ans3 = p.solution(7, new int[]{2,3,4}, new int[]{1,2,3,6});

        System.out.println(ans1+"  "+ans2+"  "+ans3);
    }
}
