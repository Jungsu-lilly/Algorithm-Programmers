package 완전탐색;

import java.util.*;

public class P_42840 {
    public int[] solution(int[] answers) {
        int n = answers.length;
        HashMap<Integer, Integer> map = new HashMap<>(3);

        int[] p1 = {1, 2, 3, 4, 5};  // 5
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};  // 8
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};  // 10

        for(int i=0;i<n;i++){
            int ans = answers[i];
            if(p1[i%5] == ans)
                map.put(0, map.getOrDefault(0,0)+1);
            if(p2[i%8] == ans)
                map.put(1, map.getOrDefault(1, 0)+1);
            if(p3[i%10] == ans)
                map.put(2, map.getOrDefault(2, 0)+1);
        }

        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() == o2.getValue())
                    return o1.getKey() - o2.getKey();
                return o2.getValue() - o1.getValue();
            }
        });

        List<Integer> list = new ArrayList<>();
        int max = entries.get(0).getValue();  // 최대 점수
        list.add(entries.get(0).getKey());
        for(int i=1;i<entries.size();i++){
            if(max == entries.get(i).getValue()){
                list.add(entries.get(i).getKey());
            }else break;
        }

        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i)+1;
        }

        return answer;
    }

    public static void main(String[] args) {
        P_42840 p = new P_42840();
        int[] solution = p.solution(new int[]{1,2,3,4,5});
        int[] solution2 = p.solution(new int[]{1,3,2,4,2});

        for (int i : solution) {
            System.out.print(i+" ");
        }
        System.out.println();

        for (int i : solution2) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
