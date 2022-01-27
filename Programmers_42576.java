import java.util.*;

public class Programmers_42576 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant)
            map.put(s, map.getOrDefault(s,0)+1);

        for (String s : completion)
            map.put(s, map.getOrDefault(s, 0)-1);

        Iterator<String> it = map.keySet().iterator();

        while(it.hasNext()){
            String next = it.next();
            if(map.get(next) != 0){
                answer += next;
                break;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Programmers_42576 p = new Programmers_42576();
        String answer = p.solution(new String[]{"leo", "kiki", "eden"},new String[]{"eden", "kiki"});
        String answer2 = p.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},new String[]{"josipa", "filipa", "marina", "nikola"});
        String answer3 = p.solution(new String[]{"mislav", "stanko", "mislav", "ana"},new String[]{"stanko", "ana", "mislav"});

        System.out.println(answer);
        System.out.println(answer2);
        System.out.println(answer3);
    }
}
