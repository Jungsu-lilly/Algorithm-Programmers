package Greedy;
import java.util.*;
// 프로그래머스 - 큰 수 만들기
public class P_42883 {

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int scope = number.length()-k;
        int idx = 0;

        for(int i=1;i<=scope;i++){
            int max = -1;
            for(int j=0; j<number.length()-(scope-i);j++){
                if(number.charAt(j)=='9'){
                    max = 9;
                    idx = j; break;
                }
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    idx = j;
                }
            }
            answer.append(max);
            number = number.substring(idx+1,number.length());
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        P_42883 p = new P_42883();
//        String ans1 = p.solution("1924", 2);
//        String ans2 = p.solution("1231234", 3);
        String ans3 = p.solution("4177252841", 4);

//        System.out.println(ans1);
//        System.out.println(ans2);
        System.out.println(ans3);
    }
}
