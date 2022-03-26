package sorting;

import java.util.*;

public class P_42747 {  // H-Index
    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<citations.length;i++){
            list.add(citations[i]);
        }
        int n = list.size();
        // 내림차순으로 정렬
        Collections.sort(list, Collections.reverseOrder());

        int temp = 0;
        for(int i=0; i<n; i++){
            int count = i+1;
            int h = list.get(i);
            if(count >= h && n-count <=h){
                return h;
            }
            else{
                while(i+1 < n && h-1 > list.get(i+1)){
                    h--;
                    if(count >= h && n-count <= h)
                        return h;
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        P_42747 p = new P_42747();
        int solution = p.solution(new int[]{10,10,10,10,10});
        System.out.println(solution);
    }
}
