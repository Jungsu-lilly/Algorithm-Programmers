import java.util.*;
public class Programmers_67256 {

    public String solution(int[] numbers, String hand) {
        String result = "";
        Map<Integer, int[]> map = new HashMap<>();
        int[][] location = { {3,1},
                {0,0},
                {0,1},
                {0,2},
                {1,0},
                {1,1},
                {1,2},
                {2,0},
                {2,1},
                {2,2}
        };

        int[] lLocation = {3,0};
        int[] rLocation = {3,2};

        for(int i= 0 ;i<=9;i++){
            map.put(i, location[i]);
        }

        for(int i=0; i<numbers.length; i++){
           int num = numbers[i];

            if(num==1 || num==4 || num==7){ // 1, 4, 7: 왼쪽 엄지로 누름
                result += "L";
                lLocation = map.get(num);
            }
            else if(num== 3|| num==6||num==9){ // 3, 6, 9 : 오른쪽 엄지로 누름
                result += "R";
                rLocation = map.get(num);
            }
            else{ // 2, 5, 8, 0
                int[] numLocation = {map.get(num)[0], map.get(num)[1]};
                int distanceL = Math.abs(numLocation[0] - lLocation[0]) + Math.abs(numLocation[1] - lLocation[1]);
                int distanceR = Math.abs(numLocation[0] - rLocation[0]) + Math.abs(numLocation[1] - rLocation[1]);

                if(distanceL == distanceR){
                    if(hand.equals("right")){
                        result += "R";
                        rLocation = map.get(num);
                    }else if(hand.equals("left")){
                        result += "L";
                        lLocation = map.get(num);
                    }
                }
                else{
                    if(distanceL < distanceR){
                        lLocation = map.get(num);
                        result += "L";
                    }
                    else {
                        rLocation = map.get(num);
                        result += "R";
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Programmers_67256 p = new Programmers_67256();
        String result = p.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        String result2 = p.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
        String result3 = p.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
}
