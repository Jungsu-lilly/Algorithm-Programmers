package DP;
import java.util.*;

// 정수 삼각형
public class P_43105 {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int answer = 0;
        List<Integer> dp[] = new List[len];
        for(int i=0;i<len;i++)
            dp[i] = new ArrayList<>();
        dp[0].add(triangle[0][0]);

        for(int i=1;i<len;i++){
            for(int j=0;j<=i;j++){
                int temp = triangle[i][j];
                if(j==0){  // j가 맨앞인 경우
                    dp[i].add(dp[i-1].get(0)+temp);
                }else if(j==i){  // j가 맨뒤인 경우
                    dp[i].add(dp[i-1].get(j-1)+temp);
                }else{  // 그 외
                    dp[i].add(Math.max(dp[i-1].get(j-1),dp[i-1].get(j))+temp);
                }
            }
        }

        for(int i=0;i<dp[len-1].size();i++){
            answer = Math.max(answer, dp[len-1].get(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        P_43105 p = new P_43105();
        int ans = p.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
        int ans2 = p.solution(new int[][]{{7},{1,0}});
        System.out.println(ans);
        System.out.println(ans2);
    }
}
