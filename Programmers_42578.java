import java.util.*;
public class Programmers_42578 {

    public int solution(String[][] clothes){
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            String key = clothe[1];
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        int answer = 1;
        Iterator<Integer> iter = map.values().iterator();

        while(iter.hasNext()){
            int temp = iter.next().intValue();
            answer *= temp+1;
        }

        return answer-1;
    }

    public static void main(String[] args) {
        Programmers_42578 p = new Programmers_42578();
        int answer1 = p.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
        int answer2 = p.solution(new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}});

        System.out.println(answer1);
        System.out.println(answer2);
    }
}
