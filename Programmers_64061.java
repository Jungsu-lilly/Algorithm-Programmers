import java.util.*;
public class Programmers_64061 {

    public int solution(int[][] board, int[] moves) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int n = board.length;
        int[] idxOfLane = new int[n];
        for(int i=0;i<n;i++){
            idxOfLane[i] = n-1;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<=n-1;j++){
                if(board[j][i] == 0){
                    idxOfLane[i]--;
                }else break;
            }
        }

        for (int num : moves) {
            int idx = idxOfLane[num-1];
            int xIndex = (n-1)-idx;
            int yIndex = num - 1;
            int number = board[xIndex][yIndex];
            if(number != 0){
                board[xIndex][yIndex] = 0;
                if(idxOfLane[num-1]!=0)
                    idxOfLane[num-1]--;
                if(!stack.isEmpty() && number == stack.peek()){
                    stack.push(number);
                    stack.pop(); stack.pop();
                    result += 2;
                }else
                    stack.push(number);
            }else{ // 뽑기 했는데 빈 경우

            }
        }
        return result;
    }




    public static void main(String[] args) {
        Programmers_64061 p =new Programmers_64061();

        int result = p.solution(new int[][]{
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
            },
                new int[]{1, 5, 3, 5, 1, 2, 1, 4});
        System.out.println(result);
    }
}
