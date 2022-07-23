package DP;
import java.util.*;

// 등굣길
public class P_42898 {
    static int MOD = 1000000007;
    static int dp[][];
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp = new int[n][m];

        for (int[] puddle : puddles)
            dp[puddle[1]-1][puddle[0]-1] = -1;

        for(int i=1;i<=m-1;i++){
            if(dp[0][i] == -1) break;
            dp[0][i] = 1;
        }

        for(int i=1;i<=n-1;i++){
            if(dp[i][0] == -1) break;
            dp[i][0] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(dp[i][j] == -1) continue;
                int left = dp[i][j-1];
                int top = dp[i-1][j];
                if(left!= -1 && top!=-1)
                    dp[i][j] = (left+top)%MOD;
                if(top == -1 && left != -1)
                    dp[i][j] = left;
                if(top != -1 && left == -1)
                    dp[i][j] = top;
                if(top== -1 && left == -1)
                    dp[i][j] = 0;

            }
        }
        answer = dp[n-1][m-1];
        return answer;
    }

    public static void main(String[] args) {
        P_42898 p = new P_42898();
        int ans = p.solution(4, 3, new int[][]{{2,2}});
        System.out.println(ans);
    }
}
