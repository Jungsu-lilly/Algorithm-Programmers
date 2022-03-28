package 완전탐색;
import java.util.*;

// 프로그래머스 - [소수 찾기]
public class P_42839 {
    public int solution(String numbers) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        permutation("",numbers,set);

        for (Integer i : set) {
            if(i==2) ans++;
            if(i%2 != 0 && isPrime(i)) ans++;
        }
        return ans;
    }

    // 소수 판별
    public boolean isPrime(int n){
        if(n==0 || n==1) return false;

        for(int i=3;i<=(int)Math.sqrt(n);i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

    public void permutation(String prefix, String num, HashSet<Integer> set){
        if(!prefix.equals(""))
            set.add(Integer.valueOf(prefix));
        int n = num.length();
        for(int i=0;i<n;i++){
            permutation(prefix+num.charAt(i),num.substring(0,i)+num.substring(i+1,n), set);
        }
    }

    public static void main(String[] args) {
        P_42839 p = new P_42839();
        int ans = p.solution("123");
        System.out.println(ans);
    }

}
