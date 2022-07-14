package DP;

import java.util.Scanner;

// 2xn 타일링
public class B_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ans = new int[n+1];
        ans[1] = 1;
        for(int i=2;i<=n;i++){
            if(i==2) ans[i] = 2;
            else ans[i] = (ans[i-1] + ans[i-2])%10007;
        }
        System.out.println(ans[n]%10007);
    }
}
