import java.util.*;

public class Programmers_81301 {
    Map<String, String> map = new HashMap<>();

    public int solution(String s) {
        String result = "";

        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        String temp = "";

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(map.containsKey(temp)){
                result += map.get(temp);
                temp = "";
            }
            if(ch >= '0' && ch <= '9')
                result += ch;
            else
                temp += ch;
        }
        if(map.containsKey(temp)){
            result += map.get(temp);
            temp = "";
        }

        int answer = Integer.parseInt(result);
        return answer;
    }

    public static void main(String[] args) {
        Programmers_81301 pr = new Programmers_81301();
        int p1 = pr.solution("one4seveneight");
        int p2 = pr.solution("23four5six7");
        int p3 = pr.solution("123");
        int p4 = pr.solution("2three45sixseven");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }
}
