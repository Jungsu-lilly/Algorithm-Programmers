package 완전탐색;
import java.util.*;

// 프로그래머스 - [소수 찾기]
public class P_42839 {
    static Set<Integer> set = new HashSet<>();

    public boolean isPrime(int n){
        if(n==0 || n==1) return false;

        // 홀수만 체크!
        for(int i=3;i<=(int)Math.sqrt(n);i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

    public void permutation(String temp, String s){
        if(!temp.isBlank()) set.add(Integer.parseInt(temp));

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            permutation(temp+c,s.substring(0,i)+s.substring(i+1,s.length()));
        }
    }

    public int solution(String numbers) {
        int answer = 0;
        permutation("", numbers);
        for (Integer i : set) {
            if(i==2) answer++;
            if(i%2!=0 && isPrime(i)) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        P_42839 p = new P_42839();
        int ans = p.solution("123");
        System.out.println(ans);
    }

}
