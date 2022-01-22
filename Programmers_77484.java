
import java.util.*;

public class Programmers_77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        Arrays.sort(lottos);  Arrays.sort(win_nums);

        int sameNum = 0; // 중복되는 숫자 갯수
        int zeroNum = 0; // 산 로또 안에 있는 0 갯수

        for (int lotto : lottos) {
            if(lotto ==0 ) zeroNum++;
        }

        for(int i=zeroNum; i<win_nums.length; i++){
            for (int number : win_nums) {
                if(lottos[i] == number){
                    sameNum++;
                    break;
                }
            }
        }

        int lowestScore = getTempScore(sameNum);
        answer[1] = lowestScore; // 최저점
        int highestScore = getTempScore(sameNum + zeroNum);
        answer[0] = highestScore; // 최고점

        return answer;
    }

    public int getTempScore(int sameNum) {
        int tempAns;
        switch (sameNum){
            case 6: tempAns = 1; break;
            case 5: tempAns = 2; break;
            case 4: tempAns = 3; break;
            case 3: tempAns = 4; break;
            case 2: tempAns = 5; break;
            default: tempAns = 6; break;
        }
        return tempAns;
    }


    public static void main(String[] args) {
        Programmers_77484 p = new Programmers_77484();
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};
        int[] result = p.solution(lottos, win_nums);

        for (int i : result) {
            System.out.print(i+" ");
        }
    }

}
