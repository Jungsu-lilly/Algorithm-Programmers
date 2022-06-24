package Hash;

import java.util.*;
public class Programmers_42578 {

    public int solution(String[][] clothes) {
        int answer = 1;
        Set<String> set = new HashSet<>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String[] s : clothes) {
            ArrayList<String> temp = map.getOrDefault(s[1], new ArrayList<>());
            temp.add(s[0]);
            map.put(s[1], temp);
            set.add(s[1]);
        }

        for (String s : set) {
            ArrayList<String> list = map.get(s);
            answer *= list.size()+1;
        }

        return answer-1;
    }

    public static void main(String[] args) {
    }
}
