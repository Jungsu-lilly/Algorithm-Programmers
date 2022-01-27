import java.util.*;

public class Programmers_86051 {

    public int solution(int[] numbers) {
        int answer = 0;
        int[] arr = new int[10];
        for(int i=0; i<=9;i++){
            arr[i] = -1;
        }

        for(int i=0;i<numbers.length;i++){
            int num = numbers[i];
            arr[num] = 1;
        }

        for(int i=0;i<=9;i++){
            if(arr[i] == -1)
                answer+=i;
        }

        return answer;
    }


    public static void main(String[] args) {
        Programmers_86051 p = new Programmers_86051();
        System.out.println(p.solution(new int[]{1,2,3,4,6,7,8,0}));
        System.out.println(p.solution(new int[]{5,8,4,0,6,7,9}));
    }

}
