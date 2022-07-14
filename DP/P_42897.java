package DP;

public class P_42897 {

    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];

        dp1[0] = money[0]; dp1[1] = dp1[0];
        dp2[0] = 0; dp2[1] = money[1];

        for(int i=2;i<=n-2;i++){
            dp1[i] = Math.max(dp1[i-2]+money[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2]+money[i], dp2[i-1]);
        }
        dp1[n-1] = dp1[n-2];
        dp2[n-1] = Math.max(dp2[n-3]+money[n-1],dp2[n-2]);
        return Math.max(dp1[n-1], dp2[n-1]);
    }

    public static void main(String[] args) {
        P_42897 p = new P_42897();
        int solution = p.solution(new int[]{1, 2, 3, 1});
        System.out.println(solution);
    }
}
