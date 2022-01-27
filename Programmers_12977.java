import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_12977 {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int[] arr = new int[2998];
        List<Integer> oddNum = new ArrayList();

        for(int i=2; i<arr.length; i++){ // 2 ~ 2997
            if(arr[i] == 0) {
                for (int j = 2 * i; j <= 2997; j += i) {
                    if (arr[j] == 0){
                        arr[j] = 1;
                    }
                }
            }
        }
        for(int i=2;i<=2997;i++){
            if(arr[i] == 0)
                oddNum.add(i);
        }

        int n = nums.length;
        for(int i=0; i< n-2; i++){
            for(int j=i+1; j< n-1; j++){
                for(int k=j+1; k< n; k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(oddNum.contains(sum)){ // 세 수의 합이 소수
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_12977 p = new Programmers_12977();
        int answer1 = p.solution(new int[]{1, 2, 3, 4});
        int answer2 = p.solution(new int[]{1, 2, 7, 6, 4});
        System.out.println(answer1);
        System.out.println(answer2);
    }
}
