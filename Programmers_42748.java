import java.util.*;
public class Programmers_42748 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0;i< commands.length;i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];

            List<Integer> temp = new ArrayList<>(); int idx = 0;

            for(int j = start-1 ; j <= end-1 ; j++){
                temp.add(array[j]);
            }
            Collections.sort(temp);

            answer[i] = temp.get(k-1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_42748 p = new Programmers_42748();

        int[] result = p.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}
